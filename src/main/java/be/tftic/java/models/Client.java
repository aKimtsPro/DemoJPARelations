package be.tftic.java.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
//@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "client_id")
//@DiscriminatorValue("CLIENT")
public class Client extends User {

    @Column(name = "client_visits")
    private long visits;

}
