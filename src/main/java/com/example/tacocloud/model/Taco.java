package com.example.tacocloud.model;

import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class Taco {

    @NotNull
    @Size(min = 5, message = "Name should be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}
