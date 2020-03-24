package com.danishcaptain.gameengine.server.war.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {
    /*
    @GetMapping("/getUserDetails")
    public String getDetails(@RequestBody TicTacToeGame name) {
        return "Requesting Details of User "+name.getName();
    }
    @PostMapping("/createUser")
    public String createNew(@RequestBody TicTacToeGame game) {
        return "Created new User "+game.getName();
    }
    @PutMapping("/updateUser")
    public String update(@RequestBody TicTacToeGame game) {
        return "Updated user "+game.getName();
    }
    @DeleteMapping("/deleteUser")
    public String delete(@RequestBody TicTacToeGame game) {
        return "Deleted User "+game.getName();
    }
    */
}
