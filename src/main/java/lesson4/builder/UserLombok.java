package lesson4.builder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class UserLombok {

    private String name;
    private String address;
    private int age;
    private String email;

}
