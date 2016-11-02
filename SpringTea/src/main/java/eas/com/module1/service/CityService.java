package eas.com.module1.service;

import com.google.gson.Gson;
import eas.com.module1.dao.CityDao;
import eas.com.module1.web.model.HeaderResponse;
import eas.com.module1.web.model.ModelData;
import eas.com.module1.web.model.ResponseData;
import java.util.Map;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 10/26/2016.
 */
public class CityService {

    private final static Logger LOGGER = Logger.getLogger(CityService.class.getName());

    private final String WEB_REST = "http://api.openweathermap.org/data/2.5/weather?q=";

    private CityDao cityDao;

    public final static Gson gson = new Gson();

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public Map<String, String> cities() {
        return this.cityDao.cities();
    }

    public ResponseData getDataMeto(ModelData modelData) throws Exception {
        return this.send(modelData.getCity());
    }

    private ResponseData send(String city) {
        Client client = ClientBuilder.newClient();
        String urlRequest = new StringBuilder(WEB_REST).append(city).append(",uk&appid=").append("742bb217049a84c9d6655718dba84607").toString();
        WebTarget query = client.target(urlRequest);
        Response response = query.request().get();
        String json = response.readEntity(String.class);
        
        ResponseData responseData = null;
        if (!response.getStatusInfo().equals(Response.Status.OK)) {           
            HeaderResponse headerResponse = gson.fromJson(json, HeaderResponse.class);
            headerResponse.setCodInfo(response.getStatusInfo().toString());
            responseData = new ResponseData(headerResponse, "", urlRequest);
            
        } else {
            responseData = new ResponseData(json, urlRequest);
        }

        return responseData;
    }
}
