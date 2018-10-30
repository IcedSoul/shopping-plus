package cn.icedsoul.productsservice.Service.ServiceImpl;

import cn.icedsoul.productsservice.Domain.Products;
import cn.icedsoul.productsservice.Repository.ProductsRepository;
import cn.icedsoul.productsservice.Service.Service.ProductsService;
import cn.icedsoul.productsservice.Utils.Common;
import cn.icedsoul.productsservice.Utils.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Response addProduct(String name, String description, String keyWord, Double price, Integer counts, Integer type, Integer seller) {
        Products products = productsRepository.findByName(name);
        if(Common.isNull(products))
            return new Response(-1,"本商品已经存在，请选择更新商品信息",null);
        Products newProducts = new Products(name,description,keyWord,price,counts,type,seller);
        Products addResult = productsRepository.save(newProducts);
        return new Response(1,"添加商品成功", JSON.toJSONString(addResult));
    }

    @Override
    public Response updateProduct(Integer id, String name, String description, String keyWord, Double price, Integer counts, Integer type, Integer seller) {
        Optional<Products> oProducts =  productsRepository.findById(id);
        if(oProducts.isPresent()){
            Products newProducts = new Products(id,name,description,keyWord,price,counts,type,seller);
            Products updateResult = productsRepository.save(newProducts);
            return new Response(1,"添加商品成功", JSON.toJSONString(updateResult));
        }
        else
            return new Response(-1,"本商品已经存在，请选择添加商品信息",null);
    }

    @Override
    public Response deleteProduct(Integer id) {
        Optional<Products> oProducts = productsRepository.findById(id);
        if(oProducts.isPresent()){
            productsRepository.deleteById(id);
            return new Response(1,"删除商品成功",null);
        }
        return new Response(-1,"商品不存在",null);
    }

    @Override
    public Response getAllProducts() {
        List<Products> allProducts = productsRepository.findAll();
        return new Response(1,"所有商品", JSONArray.toJSONString(allProducts));
    }

    @Override
    public Response getProductsByType(Integer type) {
        List<Products> typeProducts = productsRepository.findAllByType(type);
        return new Response(1,"某类型所有商品", JSONArray.toJSONString(typeProducts));
    }

    @Override
    public Response getProductsBySeller(Integer seller) {
        List<Products> sellerProducts = productsRepository.findAllBySeller(seller);
        return new Response(1,"某商家所有商品", JSONArray.toJSONString(sellerProducts));
    }

    @Override
    public Response changeCount(Integer id, Integer change) {
        Optional<Products> oProducts =  productsRepository.findById(id);
        if(oProducts.isPresent()){
            Products newProducts = oProducts.get();
            if(newProducts.getCounts() + change < 0)
                return new Response(0,"库存不足",null);
            else {
                newProducts.setCounts(newProducts.getCounts() + change);
                return new Response(1, "更新商品库存成功", JSON.toJSONString(newProducts));
            }
        }
        else
            return new Response(-1,"本商品不存在",null);
    }
}
