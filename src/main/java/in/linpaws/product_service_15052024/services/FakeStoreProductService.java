package in.linpaws.product_service_15052024.services;

import in.linpaws.product_service_15052024.dtos.ProductRequestDto;
import in.linpaws.product_service_15052024.dtos.ProductResponseDto;
import in.linpaws.product_service_15052024.dtos.fakeStoreDTO;
import in.linpaws.product_service_15052024.models.Category;
import in.linpaws.product_service_15052024.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductResponseDto getSingleProduct(int productId) {
        fakeStoreDTO FakeStoreDTO = restTemplate.getForObject(
                "http://fakestoreapi.com/products/" + productId,
                fakeStoreDTO.class

        );
        return FakeStoreDTO.toproductResponseDto();
    }

    public ProductResponseDto getAllProducts(int productId) {

            fakeStoreDTO FakeStoreDTO = restTemplate.getForObject(
                    "http://fakestoreapi.com/products/" + productId,
                    fakeStoreDTO.class

            );
            return FakeStoreDTO.toproductResponseDto();
        }

    @Override
    public List<String> getAllCategories() {
         return restTemplate.getForObject("http://fakestoreapi.com/products/categories/",List.class);

    }

    @Override
    public List<ProductResponseDto> getCategoryDetail(String category) {
        fakeStoreDTO[] fakeStoreDTOS=restTemplate.getForObject("http://fakestoreapi.com/products/category/"+category, fakeStoreDTO[].class);
        List<ProductResponseDto> list=new ArrayList<>();
        for(fakeStoreDTO fakeStoreDTO:fakeStoreDTOS)
        {
            list.add(fakeStoreDTO.toproductResponseDto());
        }
        return list;
    }

    @Override
    public ProductResponseDto addProduct(String title,String description,int id,double price,String imageUrl,String category)
    {
        fakeStoreDTO FakestoreDto=new fakeStoreDTO();
        FakestoreDto.setId(id);
        FakestoreDto.setCategory(category);
        FakestoreDto.setDescription(description);
        FakestoreDto.setPrice(price);
        FakestoreDto.setTitle(title);
        FakestoreDto.setImage(imageUrl);
        fakeStoreDTO response=restTemplate.postForObject("http://fakestoreapi.com/products/",FakestoreDto,fakeStoreDTO.class);

        return response.toproductResponseDto();
    }

    @Override
    public ProductResponseDto modifyProduct(int productId,String title,String description,int id,double price,String imageUrl,String category)
    {

        fakeStoreDTO FakeStoreDTO=restTemplate.getForObject(
                "http://fakestoreapi.com/products/" + productId,fakeStoreDTO.class

        );
        FakeStoreDTO.setId(productId);
        FakeStoreDTO.setPrice(price);
        FakeStoreDTO.setCategory(category);
        FakeStoreDTO.setDescription(description);
        FakeStoreDTO.setImage(imageUrl);
        FakeStoreDTO.setTitle(title);

        //fakeStoreDTO response=restTemplate.patchForObject("http://fakestoreapi.com/products/"+productId,FakeStoreDTO,fakeStoreDTO.class);
        return FakeStoreDTO.toproductResponseDto();
    }
}

