package com.techelevator.dao.pizzaOptions;


import com.techelevator.model.pizzaOptions.Sauce;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSauceDao implements SauceDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSauceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Sauce getSauceById(int id) {
        String sql = "SELECT * FROM sauces WHERE sauce_id = ?;";
        Sauce sauce = new Sauce();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                sauce = mapRowToSauce(row);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return sauce;
    }

    public List<Sauce> getAllSauces(){
        String sql = "SELECT * FROM sauces;";
        List<Sauce> sauceList = new ArrayList<>();
        try {
            Sauce sauce = new Sauce();
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
            while(row.next()){
                sauce = mapRowToSauce(row);
                sauceList.add(sauce);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return sauceList;
    }

    public Sauce addSauceToTable(Sauce sauce){
        String sql = "INSERT INTO sauces (name, available, price) VALUES (?, ?, ?) RETURNING sauce_id;";
        int newId = -1;
        Sauce newSauce = new Sauce();
        try{
            newId = jdbcTemplate.queryForObject(sql, Integer.class, sauce.getName(), sauce.isAvailable(), sauce.getPrice());
            newSauce = getSauceById(newId);
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return newSauce;
    }

    private Sauce mapRowToSauce(SqlRowSet rs) {
        Sauce sauce = new Sauce();
        sauce.setId(rs.getInt("sauce_id"));
        sauce.setName(rs.getString("name"));
        sauce.setAvailable(rs.getBoolean("available"));
        sauce.setPrice(rs.getBigDecimal("price"));
        return sauce;
    }
}
