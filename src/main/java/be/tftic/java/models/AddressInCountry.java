package be.tftic.java.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressInCountry {
    private String street;
    private int number;
    private String city;
    private int zipcode;
}
