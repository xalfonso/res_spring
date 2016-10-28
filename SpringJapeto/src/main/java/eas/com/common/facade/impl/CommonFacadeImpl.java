package eas.com.common.facade.impl;

import eas.com.common.facade.CommonFacade;
import eas.com.common.service.HomeService;
/**
 * Created by eduardo on 10/27/2016.
 */
public class CommonFacadeImpl implements CommonFacade {

    private HomeService homeService;


    public CommonFacadeImpl(HomeService homeService) {
        this.homeService = homeService;
    }

    @Override
    public String home() {
        return this.homeService.home();
    }
}
