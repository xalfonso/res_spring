package eas.com.module1.facade;

import eas.com.module1.web.model.ModelData;
import eas.com.module1.web.model.ResponseData;
import java.util.Map;

/**
 * Created by eduardo on 10/26/2016.
 *
 * The facade of the module. This serves all functions of this module
 */
public interface Module1Facade {
    public Map<String, String> cities();
    
    public ResponseData getDataMeto(ModelData modelData) throws Exception;
}
