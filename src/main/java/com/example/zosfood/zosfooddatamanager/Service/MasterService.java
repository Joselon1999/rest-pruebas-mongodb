package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.AddNewMasterRequest;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.UpdateMasterRequest;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Response.MasterResponse;
import io.reactivex.Completable;
import io.reactivex.Single;

import java.util.List;

public interface MasterService {
    Single<String> addNewMaster(AddNewMasterRequest addNewMasterRequest);

    Completable updateMaster(UpdateMasterRequest updateMasterRequest);

    Single<List<MasterResponse>> getAllMasters(int limit, int page);

    Single<MasterResponse> getMasterDetail(String id);

    Completable deleteMaster(String id);
}
