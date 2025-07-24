package sora.com.lash.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pets")
public class Pets {

    @Id
    private String id;

    private String petName;

    private String petType;

    private String petImage;
}
