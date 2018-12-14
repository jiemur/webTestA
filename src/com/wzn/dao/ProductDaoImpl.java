package com.wzn.dao;

import com.wzn.pojo.Product;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> getlists() {
        return JdbcUtil.executQuete("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setDes(rs.getString("product_des"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return p;
            }
        }, null);
    }

    @Override
    public int add(Product product) {
        return JdbcUtil.executUpdate("insert into product(product_name,product_price,product_des) values(?,?,?) ",product.getProductName(),product.getProductPrice(),product.getDes());
    }

    @Override
    public int delete(int id) {
        return JdbcUtil.executUpdate("delete from product where product_id=?",id);
    }

    @Override
    public Product getOne(int id) {
        return JdbcUtil.queteOne("select * from product where product_id=?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setProductName(rs.getString("product_name"));
                    p.setDes(rs.getString("product_des"));
                   p.setProductPrice(rs.getDouble("product_price"));
                   p.setProductId(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return p;
            }
        }, id);
    }

    @Override
    public int update(Product product) {
        return JdbcUtil.executUpdate("update product set product_name=?,product_price=?,product_des=? where product_id=?",product.getProductName(),product.getProductPrice(),product.getDes(),product.getProductId());
    }
}
