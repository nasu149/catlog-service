package org.nasuda.shopping.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.nasuda.shopping.model.Product;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/catlog")
public class GreetingResource {

    @Inject
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> hello() {
        List<Product> result = new ArrayList<Product>();
        try
        (
            Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs   = stmt.executeQuery("select * from test");
        ){
            while(rs.next()){
                String no = rs.getString(1);
                String ename = rs.getString(2);
                System.out.println(no + ename);
                
                Product product = new Product();
                product.setItemId(Integer.parseInt(no));
                product.setName(ename);
                result.add(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
