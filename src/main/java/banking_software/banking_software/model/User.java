package banking_software.banking_software.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @Column(unique = true)
    private String userName;

    private String password;

    private String roles;

    @Column(name="is_deleted")
    private boolean deleted;

    private int totalAmount; //Amount in the bank/balance

}
