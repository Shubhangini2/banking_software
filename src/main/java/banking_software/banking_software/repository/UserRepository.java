package banking_software.banking_software.repository;

import banking_software.banking_software.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
