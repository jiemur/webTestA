package com.wzn.dao;

import com.wzn.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getlists();
    public int add (Product product);
    public int delete(int id);
    public Product getOne(int id);
    public int update(Product product);

}
