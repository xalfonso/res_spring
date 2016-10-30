package eas.com.util;

import eas.com.AnnotationTest;

/**
 * Created by eduardo on 10/29/2016.
 */
@AnnotationTest
public class Data {
    private String value;

    public Data(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
