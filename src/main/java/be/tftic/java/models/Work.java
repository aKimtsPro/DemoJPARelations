package be.tftic.java.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Work {

    @EmbeddedId
    private WorkId id;

    @MapsId("employeId")
    @ManyToOne
    private Employe employe;

    @MapsId("hotelId")
    @ManyToOne
    private Hotel hotel;

    private int hours;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", hours=" + hours +
                '}';
    }
}
