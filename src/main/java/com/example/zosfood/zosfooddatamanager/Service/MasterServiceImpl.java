package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Entity.Master;
import com.example.zosfood.zosfooddatamanager.Entity.Servant;
import com.example.zosfood.zosfooddatamanager.Repository.MasterRepository;
import com.example.zosfood.zosfooddatamanager.Repository.ServantRepository;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.AddNewMasterRequest;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.UpdateMasterRequest;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Response.MasterResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MasterServiceImpl implements MasterService{

    @Autowired
    MasterRepository masterRepository;
    @Autowired
    ServantRepository servantRepository;

    /* ESTRUCTURA CREATE: SE REQUIERE REQUEST CON EL CONTENIDO*/
    @Override
    public Single<String> addNewMaster(AddNewMasterRequest addNewMasterRequest) {
        return saveMasterToRepository(addNewMasterRequest);
    }

    private Single<String> saveMasterToRepository(AddNewMasterRequest addNewMasterRequest) {
        return Single.create(singleSubscriber -> {
            Optional<Master> optionalMaster = masterRepository.findById(addNewMasterRequest.getIdServant());
            if (!optionalMaster.isPresent())
                singleSubscriber.onError(new EntityNotFoundException());
            else {
                String addedMasterId = masterRepository.save(toMaster(addNewMasterRequest)).getId();
                singleSubscriber.onSuccess(addedMasterId);
            }
        });
    }

    private Master toMaster(AddNewMasterRequest addNewMasterRequest) {
        Master master = new Master();
        BeanUtils.copyProperties(addNewMasterRequest,master);
        master.setId(UUID.randomUUID().toString());
        master.setServant(Servant.builder().id(addNewMasterRequest.getIdServant()).build());
        return master;
    }

    /* ESTRUCTURA UPDATE: SE REQUIERE REQUEST CON EL ID SIN CONTENIDO*/

    @Override
    public Completable updateMaster(UpdateMasterRequest updateMasterRequest) {
        return updateMasterToRepository(updateMasterRequest);
    }

    private Completable updateMasterToRepository(UpdateMasterRequest updateMasterRequest) {
        return Completable.create(completableSubscriber -> {
            Optional<Master> optionalMaster = masterRepository.findById(updateMasterRequest.getId());
            if (!optionalMaster.isPresent())
                completableSubscriber.onError(new EntityNotFoundException());
            else {
                Master master = optionalMaster.get();
                master.setName(updateMasterRequest.getName());
                masterRepository.save(master);
                completableSubscriber.onComplete();
            }
        });
    }

    /* ESTRUCTURA READ ALL : REQUIERE RESPONSE INDIVIDUAL QUE ES MAPEADO "X" VECES
    *                        3 estructuras: 1) toMasterResponse = consigue info de 1 master
    *                                       2) toMasterResponseList = mapea y colecciona todos los (1)
    *                                       3) findAllMastersRepository = usa (2) y ordena
    *                                          cantidad de master por página*/
    @Override
    public Single<List<MasterResponse>> getAllMasters(int limit, int page) {
        return findAllMastersInRepository(limit,page).map(this::toMasterResponseList);
    }



    private Single<List<Master>> findAllMastersInRepository(int limit, int page) {
        return Single.create(singleSubscriber -> {
            List<Master> masters = masterRepository.findAll(PageRequest.of(page, limit)).getContent();
            singleSubscriber.onSuccess(masters);
        });
    }
    private List<MasterResponse> toMasterResponseList(List<Master> masters) {
        return masters.stream().map(this::toMasterResponse).collect(Collectors.toList());
    }

    private MasterResponse toMasterResponse(Master master) {
        MasterResponse masterResponse = new MasterResponse();
        BeanUtils.copyProperties(master,masterResponse);
        masterResponse.setServantName(master.getServant().getName());
        return masterResponse;
    }

    /* ESTRUCTURA READ ALL : REQUIERE RESPONSE INDIVIDUAL QUE ES MAPEADO 1 VECES
     *                        2 estructuras: 1) toMasterResponse = adquirida de getAllMasters() - Misma funcion
     *                                       2) findMastersDetailInRepository = usa (1) y muestra*/
    @Override
    public Single<MasterResponse> getMasterDetail(String id) {
        return findMastersDetailInRepository(id);
    }

    private Single<MasterResponse> findMastersDetailInRepository(String id) {
        return Single.create(singleSubscriber -> {
            Optional<Master> optionalMaster = masterRepository.findById(id);
            if (!optionalMaster.isPresent())
                singleSubscriber.onError(new EntityNotFoundException());
            else {
                MasterResponse masterResponse= toMasterResponse(optionalMaster.get());
                singleSubscriber.onSuccess(masterResponse);
            }
        });
    }

    @Override
    public Completable deleteMaster(String id) {
        return null;
    }
}
