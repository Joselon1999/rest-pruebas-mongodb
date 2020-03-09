package com.example.zosfood.zosfooddatamanager.ServiceDto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewServantRequest {

    private String name;
    private String servantClass;
}
