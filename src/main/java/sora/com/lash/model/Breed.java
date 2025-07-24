package sora.com.lash.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("breeds")
public class Breed {
    @Id
    private String breedId;

    private String breedName;

    private String breedSpecies;
}
