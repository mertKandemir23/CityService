package com.mertKandemir.cityservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private String id;

    private String name;

    private Date createdTime = new Date();

}

