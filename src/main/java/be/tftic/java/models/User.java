package be.tftic.java.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "user_role" /*, discriminatorType = DiscriminatorType.STRING (default) */)
@AttributeOverrides({ // override de BaseEntity
        @AttributeOverride(name = "createdAt", column = @Column(name = "user_created_at", nullable = false)),
        @AttributeOverride(name = "lastUpdateAt", column = @Column(name = "user_last_update_at"))
})
public abstract class User extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "user_password", nullable = false)
    private String password;

}
