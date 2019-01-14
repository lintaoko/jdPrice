package controller;


import exception.UserNotFoundException;
import model.Error;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.UserService;

import java.net.URI;
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
    userById(@PathVariable int id) {
        User user = userService.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody User user,
                                         UriComponentsBuilder ucb
    ) {

        // 拿到User 对象
        User gotUser = userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
//        URI locationURI = URI.create(
//                "http://localhost:8080/jdProduct_war/user/"
//                        + gotUser.getUserId()
//        );
//        headers.setLocation(locationURI);
        URI locationURI = ucb.path("/user/").path(String.valueOf(gotUser.getUserId())).build()
                .toUri();
        headers.setLocation(locationURI);
        ResponseEntity<User> responseEntity =
                new ResponseEntity<User>(
                        gotUser, headers, HttpStatus.CREATED
                );

        return responseEntity;
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
