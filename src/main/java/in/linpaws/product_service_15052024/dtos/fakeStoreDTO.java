package in.linpaws.product_service_15052024.dtos;

import in.linpaws.product_service_15052024.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreDTO {
    private String title;
    private String description;
    private int id;
    private double price;
    private String image;
    private String category;

    public ProductResponseDto toproductResponseDto()
    {
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setId(id);
        productResponseDto.setCategory(category);
        productResponseDto.setDescription(description);
        productResponseDto.setPrice(price);
        productResponseDto.setTitle(title);
        productResponseDto.setImage(image);

        return productResponseDto;
    }
}
