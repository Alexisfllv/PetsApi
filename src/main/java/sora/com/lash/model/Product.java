package sora.com.lash.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "productos")
public class Product {
    @Id
    private String id;

    private String nombre;
    private double precio;
    private int stock;
}
