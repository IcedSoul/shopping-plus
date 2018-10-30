package cn.icedsoul.productsservice.Controller;

import cn.icedsoul.productsservice.Service.Service.ProductsService;
import cn.icedsoul.productsservice.Utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "商品控制类",description = "提供商品相关的增删改查功能")
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    ProductsService productsService;

    @ApiOperation(value = "添加商品",notes = "用来新增一个商品",response = Response.class)
    @PostMapping(value = "/addProduct")
    public Response addProduct(@RequestParam("name")String name, @RequestParam("description")String description,
                               @RequestParam("keyWord")String keyWord, @RequestParam("price")Double price,
                               @RequestParam("counts")Integer counts, @RequestParam("type")Integer type,
                               @RequestParam("seller")Integer seller){
        return productsService.addProduct(name,description,keyWord,price,counts,type,seller);
    }

    @ApiOperation(value = "更新商品信息",notes = "用来更新商品的信息",response = Response.class)
    @PostMapping(value = "updateProduct")
    public Response updateProduct(@RequestParam("name")Integer id, @RequestParam("name")String name, @RequestParam("description")String description,
                               @RequestParam("keyWord")String keyWord, @RequestParam("price")Double price,
                               @RequestParam("counts")Integer counts, @RequestParam("type")Integer type,
                               @RequestParam("seller")Integer seller){
        return productsService.updateProduct(id,name,description,keyWord,price,counts,type,seller);
    }

    @ApiOperation(value = "删除商品",notes = "用来删除商品记录",response = Response.class)
    @PostMapping(value = "deleteProduct")
    public Response deleteProduct(@RequestParam("name")Integer id){
        return productsService.deleteProduct(id);
    }

    @ApiOperation(value = "获取所有商品",notes = "获取所有商品",response = Response.class)
    @PostMapping(value = "getAllProducts")
    public Response getAllProducts(){
        return productsService.getAllProducts();
    }

    @ApiOperation(value = "根据类型获取该类型商品",notes = "根据类型获取所有商品",response = Response.class)
    @PostMapping(value = "getProductsByType")
    public Response getProductsByType(@RequestParam("type")Integer type){
        return productsService.getProductsByType(type);
    }

    @ApiOperation(value = "根据商家获取商家所有商品",notes = "根据商家获取所有商品",response = Response.class)
    @PostMapping(value = "getProductsBySeller")
    public Response getProductsBySeller(@RequestParam("type")Integer seller){
        return productsService.getProductsBySeller(seller);
    }

    @ApiOperation(value = "改变库存数量",notes = "改变库存数量",response = Response.class)
    @PostMapping(value = "changeCount")
    public Response changeCount(@RequestParam("id")Integer id,@RequestParam("change")Integer change){
        return productsService.changeCount(id,change);
    }


}
