package eas.com.module1.dao;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by eduardo on 10/26/2016.
 */
public class CityDao {

    @Value("#{data}")
    private Map<String, String> cities;
    
    public String stree(){
        return "stree";
    }
    
    public Map<String, String> cities(){
        return this.cities;
    }
}
