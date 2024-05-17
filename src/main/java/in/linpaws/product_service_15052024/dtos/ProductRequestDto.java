package in.linpaws.product_service_15052024.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

        private String title;
        private String description;
        private int id;
        private double price;
        private String image;
        private String category;
}
