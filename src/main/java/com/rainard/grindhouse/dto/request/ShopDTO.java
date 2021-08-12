package com.rainard.grindhouse.dto.request;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO implements Serializable {
    @NotBlank(message = "Shop name can not be null or blank")
    private String name;
}
