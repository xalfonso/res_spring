package eas.com.web;

import eas.com.vo.DummyRequestVO;
import eas.com.vo.DummyResponseVO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping("/multipart")
@RestController
public class MultipartController {


    @PostMapping(value = "/simpleFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DummyResponseVO> simpleFile(@RequestParam("myFile") MultipartFile myFile) {
        System.out.println("Call eas.com.web.MultipartController.simpleFile");
        return ResponseEntity.ok(new DummyResponseVO("Work Well!!!"));
    }

    @PostMapping(value = "/fileWithData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DummyResponseVO> fileWithData(@RequestParam("myFile") MultipartFile myFile, @RequestParam("data") String someData) {
        System.out.println("Call eas.com.web.MultipartController.simpleFile");
        return ResponseEntity.ok(new DummyResponseVO("Work Well!!!"));
    }


    /**
     * Example of cliente request in: res_spring\spring-leto\src\main\resources\client-fileWithDataJson.txt
     *
     * @param myFile
     * @param someData
     * @return
     */
    @PostMapping(value = "/fileWithDataJson", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DummyResponseVO> fileWithDataJson(@RequestPart("myFile") MultipartFile myFile, @RequestPart("someJson") DummyRequestVO someData) throws IOException {
        System.out.println("Call eas.com.web.MultipartController.simpleFile");
        System.out.println("File Content Type: " + myFile.getContentType());
        System.out.println("File Name: " + myFile.getName());
        System.out.println("File Size: " + myFile.getSize());
        System.out.println("File Bytes: " + myFile.getBytes());
        return ResponseEntity.ok(new DummyResponseVO("Work Well!!!"));
    }
}
