package ru.gb.vkr.vkrProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.vkr.vkrProject.service.ServiceImpl;

@RestController
public class Controller {

    private final ServiceImpl service;

    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getMessage() {
        return service.getMessage();
    }
}
