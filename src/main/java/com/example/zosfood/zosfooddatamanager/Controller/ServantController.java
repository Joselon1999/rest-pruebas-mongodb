package com.example.zosfood.zosfooddatamanager.Controller;


import com.example.zosfood.zosfooddatamanager.ControllerDto.BaseWebResponse;
import com.example.zosfood.zosfooddatamanager.Entity.Servant;
import com.example.zosfood.zosfooddatamanager.Service.ServantService;
import com.example.zosfood.zosfooddatamanager.ServiceDto.Request.AddNewServantRequest;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;

@RestController
@RequestMapping(value = "/api/servants")
public class ServantController {

@Autowired
    private ServantService servantService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseWebResponse>> addAuthor(@RequestBody AddNewServantRequest addNewServantRequest) {
        return servantService.addNewServant(toAddServantRequest(addNewServantRequest))
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .created(URI.create("/api/authors/" + s))
                        .body(BaseWebResponse.successNoData()));
    }

    private AddNewServantRequest toAddServantRequest(AddNewServantRequest addNewServantRequest) {
        Servant servant = new Servant();
        BeanUtils.copyProperties(addNewServantRequest, servant);
        return addNewServantRequest;
    }

}
