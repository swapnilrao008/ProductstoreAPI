package in.linpaws.product_service_15052024.controllers;

import in.linpaws.product_service_15052024.dtos.ProductRequestDto;
import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.dtos.fakeStoreDTO;
import in.linpaws.product_service_15052024.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //get maping
    @GetMapping("/products/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }

    @GetMapping("/products/category/{category}")
    public List<ProductResponseDto> getCategoryDetail(@PathVariable("category") String category){

        return productService.getCategoryDetail(category);
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

    //post maping
@PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto=productService.addProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getId(),
                productRequestDto.getPrice(),
                productRequestDto.getImage(),
                productRequestDto.getCategory()

        );

        return productResponseDto;

}

@PatchMapping("/products/{id}")
public ProductResponseDto updateProduct(@PathVariable ("id") int productId,@RequestBody ProductRequestDto productRequestDto)
{
    ProductResponseDto productResponseDto=productService.modifyProduct(
            productId,
            productRequestDto.getTitle(),
            productRequestDto.getDescription(),
            productRequestDto.getId(),
            productRequestDto.getPrice(),
            productRequestDto.getImage(),
            productRequestDto.getCategory()

    );

    return productResponseDto;

   //return productService.modifyProduct(productId,productRequestDto);
}


}
