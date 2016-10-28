package eas.com.module1.facade.impl;

import eas.com.module1.facade.Module1Facade;
import eas.com.module1.service.StreeService;

/**
 * Created by eduardo on 10/27/2016.
 */
public class Module1FacadeImpl implements Module1Facade {

    private StreeService streeService;

    public Module1FacadeImpl(StreeService streeService) {
        this.streeService = streeService;
    }

    @Override
    public String stree() {
        return this.streeService.stree();
    }
}
