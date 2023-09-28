package com.techelevator.dao.pizzaOptions;


import com.techelevator.model.pizzaOptions.Crust;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCrustDao implements CrustDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCrustDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Crust getCrustById(int id) {
        String sql = "SELECT * FROM crusts WHERE crust_id = ?;";
        Crust crust = new Crust();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                crust = mapRowToCrust(row);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return crust;
    }

    public List<Crust> getAllCrusts(){
        String sql = "SELECT * FROM crusts;";
        List<Crust> crustList = new ArrayList<>();
        try {
            Crust crust = new Crust();
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
            while(row.next()){
                crust = mapRowToCrust(row);
                crustList.add(crust);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return crustList;
    }

    public Crust addCrustToTable(Crust crust){
        String sql = "INSERT INTO crusts (name, available, price) VALUES (?, ?, ?) RETURNING crust_id;";
        int newId = -1;
        Crust newCrust = new Crust();
        try{
            newId = jdbcTemplate.queryForObject(sql, Integer.class, crust.getName(), crust.isAvailable(), crust.getPrice());
            newCrust = getCrustById(newId);
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return newCrust;
    }

    private Crust mapRowToCrust(SqlRowSet rs) {
        Crust crust = new Crust();
        crust.setId(rs.getInt("crust_id"));
        crust.setName(rs.getString("name"));
        crust.setAvailable(rs.getBoolean("available"));
        crust.setPrice(rs.getBigDecimal("price"));
        return crust;
    }
}
