package eas.com.controller.impl;

import eas.com.controller.StudentController;
import eas.com.model.Student;
import eas.com.service.StudentService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.AsyncRequestCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.ResponseExtractor;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Controller
public class StudentControllerImpl implements StudentController {

    private static final Logger LOGGER = Logger.getLogger(StudentControllerImpl.class.getName());

    @Resource
    private StudentService studentService;

    @Override
    public ResponseEntity<List<Student>> getAll() {
        LOGGER.info("Call getAll Student");
        return ResponseEntity.ok(this.studentService.getStudentList());
    }

    @Override
    public ResponseEntity<String> get(@PathVariable Long id) {
        LOGGER.info("Call get id: " + id);
        return ResponseEntity.ok("Response #" + id);
    }

    @Override
    public ResponseEntity<String> getResultForExternalService() {
        AsyncRestTemplate asycTemp = new AsyncRestTemplate();

        AsyncRequestCallback requestCallback = arg0 -> {
            LOGGER.info("Execute AsyncRequestCallback");
            LOGGER.info("Execute AsyncRequestCallback. URL of Request: " + arg0.getURI());
        };

        ResponseExtractor<String> responseExtractor = arg0 -> {
            LOGGER.info("Execute ResponseExtractor");
            String text;
            try (Scanner scanner = new Scanner(arg0.getBody(), StandardCharsets.UTF_8.name())) {
                text = scanner.useDelimiter("\\A").next();
            }
            LOGGER.info("Execute ResponseExtractor. Bodey: " + text);
            return text;
        };


        for (int i = 0; i < 10; i++) {
            ListenableFuture<String> future1 = asycTemp.execute("http://localhost:8080/spring-mnemosine-1.0-SNAPSHOT/student/" + i, HttpMethod.GET,
                    requestCallback, responseExtractor);

            future1.addCallback(new ListenableFutureCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    LOGGER.info("Success: " + result);
                }

                @Override
                public void onFailure(Throwable t) {
                    LOGGER.info("Failure: " + t.getMessage());
                }
            });
        }

        /*String result1;
        try {
            //waits for the result
            result1 = future1.get();
            LOGGER.info("Show Result Response 1: " + result1);
        } catch (ExecutionException e) {
            LOGGER.info("ExecutionException " + e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.info("InterruptedException " + e.getMessage());
        }*/


        return ResponseEntity.ok("Revisa los logs");
    }
}
