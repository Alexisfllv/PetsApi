package sora.com.lash.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("owners")
public class Owner {
    @Id
    private String  ownerId;

    private String  ownerName;

    private String ownerPhone;
}
