package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Entity.Servant;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.AddNewServantRequest;
import io.reactivex.Single;


public interface ServantService{
    Single<String> addNewServant(AddNewServantRequest addNewServantRequest);
}
