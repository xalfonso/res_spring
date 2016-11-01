package eas.com.hr.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/30/2016.
 */
@Service
public class HumanResourceService {
    private final static Logger LOGGER = Logger.getLogger(HumanResourceService.class.getName());

    public void bookHoliday(Date startDate, Date endDate, String name) {
       LOGGER.log(Level.INFO, "bookHoliday. StarDate: " + startDate.toString() + " EndDate: " + endDate.toString() + " Name: " + name);
    }
}
