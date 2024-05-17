package in.linpaws.product_service_15052024.services;

import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.dtos.fakeStoreDTO;
import in.linpaws.product_service_15052024.models.Product;

import java.util.List;

public interface ProductService {
    public ProductResponseDto getSingleProduct(int productId);
    public ProductResponseDto getAllProducts(int productId);

    public List<String> getAllCategories();

   public List<ProductResponseDto> getCategoryDetail(String category);
    public ProductResponseDto addProduct(String title,String description,int id,double price,String imageUrl,String category);

}

