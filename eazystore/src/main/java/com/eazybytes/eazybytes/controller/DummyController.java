package com.eazybytes.eazybytes.controller;


import com.eazybytes.eazybytes.dto.UserDto;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/dummy")
@Validated
public class DummyController {

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return "User created Successfully";
    }

    @PostMapping("/request-entity")
    public String createUserWithEntity(RequestEntity<UserDto> requestEntity) {

        HttpHeaders headers = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryString = requestEntity.getUrl().getQuery();

        System.out.println(headers);
        System.out.println(userDto);
        System.out.println(queryString);


        requestEntity.getHeaders().forEach((key, value) ->
                System.out.println(key + ": " + value));

        return "User created Successfully";
    }

    @GetMapping("/header")
    public String readHeader(@RequestHeader Map<String, String> headers) {
        String agents =  headers.get("User-Agent");
        System.out.println(agents);
        return headers.toString();
    }

    @GetMapping("/search")
    public String searchUser(@Size(min = 5 , max = 30) @RequestParam(required = false , defaultValue = "Guest" , name = "name")
                                 String userName) {

        return "Searching for user " + userName;
    }

    @GetMapping("/multi-search")
    public String multisearch(@RequestParam Map<String, String> params) {

        return "Searching for user " + params.get("firstName") + " " + params.get("lastName");
    }

    @GetMapping({"/user/{userId}/posts/{postId}", "/user/{userId}"})
    public String getUser(@PathVariable(name = "userId") Integer id , @PathVariable(required = false) Integer postId ) {

        return "Searching for user "  + id + " and Post id  = "  + postId ;
    }
}
