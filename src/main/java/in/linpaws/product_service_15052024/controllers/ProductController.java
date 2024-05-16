package in.linpaws.product_service_15052024.controllers;

import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductDetail(@PathVariable("id") int productId){
        return productService.getSingleProduct(productId);

    }
    @GetMapping("/products")
    public List<ProductResponseDto> getAllProductDetail(){
        List<ProductResponseDto> list=new ArrayList<>();
        for(int i=1;i<=20;i++) {
            list.add(productService.getAllProducts(i));
        }
return list;
    }

}
