package com.duyhien.springDataJPA24d6m.Dto.Request;

import com.duyhien.springDataJPA24d6m.Model.Gender;
import com.duyhien.springDataJPA24d6m.Model.UserStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
public class UserRequestDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String email;

    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;

    private Gender gender;

    private String username;

    private String password;

    private String type;

    private UserStatus status;

    private Set<AddressDTO> addresses;

    public UserRequestDTO(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
