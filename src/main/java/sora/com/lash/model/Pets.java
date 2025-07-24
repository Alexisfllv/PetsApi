package sora.com.lash.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "pets")
public class Pets {

    @Id
    private String petId;

    private String petName;

    private String petType;

    private String petImage;

    //

    private String ownerId;

    private String breedId;

    private LocalDate birthDate;


}
