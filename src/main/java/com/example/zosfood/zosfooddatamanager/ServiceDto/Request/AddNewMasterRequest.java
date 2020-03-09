package com.example.zosfood.zosfooddatamanager.ServiceDto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddNewMasterRequest {
    private String name;
    private String idServant;
}
