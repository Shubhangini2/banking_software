package banking_software.banking_software.service;

import banking_software.banking_software.model.User;
import banking_software.banking_software.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(User user) {

        userRepository.save(user);
        return "User saved successfully";
    }

    public String userCredit(int userId, int amount) {

        User user = userRepository.findById(userId).get();
        int currAmount = user.getTotalAmount();
        user.setTotalAmount(currAmount+amount);
        userRepository.save(user);
        return "Amount credited successfully";
    }

    public String userDebit(int userId, int amount) {
        User user = userRepository.findById(userId).get();
        int currentAmount= user.getTotalAmount();
        if(currentAmount >= amount){
            user.setTotalAmount(currentAmount - amount);
            userRepository.save(user);
            return "Amount debited successfully";
        }
        else{
            return "Insufficient Amount";
        }
    }

    public String userUpdate(int userId, String newPassword) {
        User user = userRepository.findById(userId).get();
        user.setPassword(newPassword);
        userRepository.save(user);
        return "Password change successfully";
    }

    public String userDelete(int userId) {
        User user = userRepository.findById(userId).get();
         userRepository.delete(user);
         return "User Deleted successfully";
    }
}
