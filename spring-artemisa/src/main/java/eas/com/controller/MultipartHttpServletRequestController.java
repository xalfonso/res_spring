package eas.com.controller;

import eas.com.vo.DummyResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * MultipartHttpServletRequestController.
 *
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("multipart")
@RestController
public class MultipartHttpServletRequestController {

    @PostMapping(value = "divide", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DummyResponseVO> divide(@RequestParam("file") List<MultipartFile> files, @RequestParam("data") String someData) {
        System.out.println("Call eas.com.controller.MultipartHttpServletRequestController.divide");
        System.out.println("File size: " + files.size());
        files.stream().forEach(multipartFile -> {
            System.out.println("File name: " + multipartFile.getName());
            System.out.println("File type: " + multipartFile.getContentType());
            System.out.println("File Size: " + multipartFile.getSize());
        });

        System.out.println("Data: " + someData);

        return ResponseEntity.ok(new DummyResponseVO("Work well"));
    }

    @PostMapping(value = "joined", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DummyResponseVO> joined(MultipartHttpServletRequest input) throws IOException {
        System.out.println("Call eas.com.controller.MultipartHttpServletRequestController.joined");

        Collection<List<MultipartFile>> listaFiles = input.getMultiFileMap().values();
        for (List<MultipartFile> lista : listaFiles) {
            for (MultipartFile file : lista) {
                System.out.println("File name: " + file.getName());
                System.out.println("File type: " + file.getContentType());
                System.out.println("File Size: " + file.getSize());
                System.out.println("File Byte: " + Arrays.toString(file.getBytes()));
            }
        }


        String[] data = input.getParameterMap().get("data");
        System.out.println("Data: " + data[0]);

        return ResponseEntity.ok(new DummyResponseVO("Work well"));
    }
}
