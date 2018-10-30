package cn.icedsoul.productsservice.Service.Service;

import cn.icedsoul.productsservice.Utils.Response;

public interface ProductsService {
    Response addProduct(String name, String description, String keyWord, Double price, Integer counts, Integer type, Integer seller);
    Response updateProduct(Integer id, String name, String description, String keyWord, Double price, Integer counts, Integer type, Integer seller);
    Response deleteProduct(Integer id);
    Response getAllProducts();
    Response getProductsByType(Integer type);
    Response getProductsBySeller(Integer seller);
    Response changeCount(Integer id, Integer change);
}
