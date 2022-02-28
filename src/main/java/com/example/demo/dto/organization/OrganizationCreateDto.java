package com.example.demo.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Saydali Murodullayev, Sat 8:07 PM. 2/26/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrganizationCreateDto {


    @NotNull
    private String name;

    @NotNull
    private String logo;

    @NotNull
    private Long owner;

}
