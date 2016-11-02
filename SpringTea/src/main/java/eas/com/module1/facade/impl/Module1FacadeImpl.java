package eas.com.module1.facade.impl;

import eas.com.module1.facade.Module1Facade;
import eas.com.module1.service.CityService;
import eas.com.module1.web.model.ModelData;
import eas.com.module1.web.model.ResponseData;
import java.util.Map;

/**
 * Created by eduardo on 10/27/2016.
 */
public class Module1FacadeImpl implements Module1Facade {

    private CityService cityService;

    public Module1FacadeImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public Map<String, String> cities() {
        return this.cityService.cities();
    }

    public ResponseData getDataMeto(ModelData modelData) throws Exception{
        return this.cityService.getDataMeto(modelData);
    }
    
    
}
