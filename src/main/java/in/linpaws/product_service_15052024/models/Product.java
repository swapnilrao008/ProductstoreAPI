package in.linpaws.product_service_15052024.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String title;
    private String description;
    private int id;
    private double price;
    private int imageUrl;
    private Category category;

}
