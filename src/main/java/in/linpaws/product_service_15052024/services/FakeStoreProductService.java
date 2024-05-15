package in.linpaws.product_service_15052024.services;

import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.dtos.fakeStoreDTO;
import in.linpaws.product_service_15052024.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponseDto getSingleProduct(int productId) {
        fakeStoreDTO FakeStoreDTO=restTemplate.getForObject(
                "http://fakestoreapi.com/products/"+productId,
                fakeStoreDTO.class

        );
        return FakeStoreDTO.toproductResponseDto();
    }
}
