package be.tftic.java.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkId implements Serializable {
    private Long employeId;
    private Long hotelId;
}
