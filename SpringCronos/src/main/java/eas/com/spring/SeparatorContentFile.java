package eas.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class SeparatorContentFile {

    private String value;

    public SeparatorContentFile() {
    }

    public SeparatorContentFile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Autowired
    @Value("#")
    public void setValue(String value) {
        this.value = value;
    }
}
