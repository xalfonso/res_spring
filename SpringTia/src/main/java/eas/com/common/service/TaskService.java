package eas.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Future;

public class TaskService {

    private final static Logger LOGGER = Logger.getLogger(TaskService.class.getName());

    @Scheduled(fixedDelay = 5000)
    public void taskScheduled1() {
        LOGGER.debug("Call taskScheduled1");
    }

    @Async
    public Future<String> taskAsync1() {
        LOGGER.debug("Call taskAsync1 - " + Thread.currentThread().getName());
        try {
            LOGGER.debug("Begin to Sleep. Call taskAsync1 - " + Thread.currentThread().getName());
            Thread.sleep(5000);
            LOGGER.debug("End to Sleep. Call taskAsync1 - " + Thread.currentThread().getName());
            return new AsyncResult<String>("taskAsync1 return message !!!!");
        } catch (InterruptedException e) {
            LOGGER.debug("Call taskAsync1 - " + Thread.currentThread().getName() + "Error : " + e.getMessage());
        }

        return null;
    }
}
