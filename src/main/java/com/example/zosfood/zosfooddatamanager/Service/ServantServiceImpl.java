package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Entity.Servant;
import com.example.zosfood.zosfooddatamanager.Repository.ServantRepository;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.AddNewServantRequest;
import io.reactivex.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ServantServiceImpl implements ServantService{

    @Autowired
    ServantRepository servantRepository;


    @Override
    public Single<String> addNewServant(AddNewServantRequest addNewServantRequest) {
        return addServantToRepository(addNewServantRequest);
    }

    private Single<String> addServantToRepository(AddNewServantRequest addNewServantRequest) {
        return Single.create(singleSubscriber -> {
            String addedServantId = servantRepository.save(toServant(addNewServantRequest)).getId();
            singleSubscriber.onSuccess(addedServantId);
        });
    }

    private Servant toServant(AddNewServantRequest addNewServantRequest) {
        Servant servant= new Servant();
        BeanUtils.copyProperties(addNewServantRequest,servant);
        servant.setId(UUID.randomUUID().toString());
        return servant;
    }
}
