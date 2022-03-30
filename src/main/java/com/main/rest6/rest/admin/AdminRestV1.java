package com.main.rest6.rest.admin;

import com.main.rest6.dto.AdminUserDto;
import com.main.rest6.model.XUser;
import com.main.rest6.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestV1 {

    private final UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public AdminRestV1(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @GetMapping(value = "users/{email}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "email") String email) {
        XUser  user = userRepositoryJPA.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
