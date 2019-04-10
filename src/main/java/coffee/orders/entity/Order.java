package coffee.orders.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Order {
    public String coffee;
    @Id
    public String emailAddress;
    public String size;
    public String flavor;
    public String strength;

}