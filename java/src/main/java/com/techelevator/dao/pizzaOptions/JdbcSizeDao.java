package com.techelevator.dao.pizzaOptions;


import com.techelevator.model.pizzaOptions.Size;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSizeDao implements SizeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSizeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Size getSizeById(int id) {
        String sql = "SELECT * FROM sizes WHERE size_id = ?;";
        Size size = new Size();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                size = mapRowToSize(row);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return size;
    }

    public List<Size> getAllSizes(){
        String sql = "SELECT * FROM sizes;";
        List<Size> sizeList = new ArrayList<>();
        try {
            Size size = new Size();
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
            while(row.next()){
                size = mapRowToSize(row);
                sizeList.add(size);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return sizeList;
    }

    public Size addSizeToTable(Size size){
        String sql = "INSERT INTO sizes (name, available, price) VALUES (?, ?, ?) RETURNING size_id;";
        int newId = -1;
        Size newSize = new Size();
        try{
            newId = jdbcTemplate.queryForObject(sql, Integer.class, size.getName(), size.isAvailable(), size.getPrice());
            newSize = getSizeById(newId);
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return newSize;
    }

    private Size mapRowToSize(SqlRowSet rs) {
        Size size = new Size();
        size.setId(rs.getInt("size_id"));
        size.setName(rs.getString("name"));
        size.setAvailable(rs.getBoolean("available"));
        size.setPrice(rs.getBigDecimal("price"));
        return size;
    }
}
