package eas.com.spring;

/**
 * Created by eduardo on 10/24/2016.
 */
abstract public class ComponentStep {

    protected String name;


    public ComponentStep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
