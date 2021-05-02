package com.example.tacocloud.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class Taco {

    private Long id;
    private Date createdDate;

    @NotNull
    @Size(min = 5, message = "Name should be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients = new ArrayList<>();
}
