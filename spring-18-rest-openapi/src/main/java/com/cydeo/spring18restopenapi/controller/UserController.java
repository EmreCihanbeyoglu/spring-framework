package com.cydeo.spring18restopenapi.controller;

import com.cydeo.spring18restopenapi.entity.UserAccount;
import com.cydeo.spring18restopenapi.repository.UserAccountRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "user", description = "User CRUD operations")
public class UserController {

    private final UserAccountRepository userAccountRepository;

    public UserController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/users")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "successfully retrieved users",
                    content = {
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(
                                        implementation = UserAccount.class
                                )
                        )
            }),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "not found", content = @Content),
    })
    public List<UserAccount> readAllUsers() {
        return userAccountRepository.findAll();
    }

}
