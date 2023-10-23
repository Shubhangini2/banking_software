package banking_software.banking_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import banking_software.banking_software.model.User;
import banking_software.banking_software.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //add user
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user ){

        String userResponse = userService.addUser(user);
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
    }

    //credit
    @PostMapping("/credit")
    public ResponseEntity userCredit(@RequestParam int userId, @RequestBody int amount){

       String response = userService.userCredit(userId,amount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //debit
    @PostMapping("/debit")
    public ResponseEntity userDebit(@RequestParam int userId, @RequestBody int amount){

        String response = userService.userDebit(userId,amount);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //update the password
    @PutMapping("/update/{userId}")
    public ResponseEntity userUpdate(@PathVariable("userId") int userId, String newPassword){

        String response = userService.userUpdate(userId,newPassword);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/delete")
    public ResponseEntity userDelete(@RequestParam int userId){

        String response = userService.userDelete(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
