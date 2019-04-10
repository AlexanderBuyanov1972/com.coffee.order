package coffee.orders.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDTO {
    public String coffee;
    public String emailAddress;
    public String size;
    public String flavor;
    public String strength;


}
