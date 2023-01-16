package com.apps.fir.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[a-zA-Z]{3,12}", message = "Name should be alphabets only")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]{3,12}", message = "Name should be alphabets only")
    private String lastName;

    @Pattern(regexp = "[789][0-9]{9}", message = "Mobile Number should be 10 digits")
    private String mobileNumber;

    @Pattern(regexp = "[a-zA-Z]{3,12}", message = "Address should be alphabets only")
    private String address;

    @Max(value = 99, message = "Age should be less than 99")
    @Min(value = 8, message = "Age should be greater than 8")
    private Integer age;

    @Pattern(regexp = "Male|Female|Other")
    private String gender;

    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters and at least one special character, should not be at last and first.")
    private String password;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userModel")
    private List<FirModel> firModelList;

}
