package com.wzn.service;

import com.wzn.dao.IProductDao;
import com.wzn.dao.ProductDaoImpl;
import com.wzn.pojo.Product;

import java.util.List;

public class ProductServiceImlp implements IProductService {
    private IProductDao dao=new ProductDaoImpl();
    @Override
    public List<Product> getLists() {
        return dao.getlists();
    }

    @Override
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }
}
