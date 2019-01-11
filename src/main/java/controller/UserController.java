package controller;


import exception.UserNotFoundException;
import model.Error;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.nio.file.ProviderNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<User>
    userById(@PathVariable int id){
        User user = userService.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFound(
          UserNotFoundException e
    ) {
        int userId = e.getUserId();
        Error error = new Error(4, "User [" + userId + "] not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }


}
