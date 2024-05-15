package in.linpaws.product_service_15052024.services;

import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.dtos.fakeStoreDTO;
import in.linpaws.product_service_15052024.models.Product;

public interface ProductService {
    public ProductResponseDto getSingleProduct(int productId);
}
