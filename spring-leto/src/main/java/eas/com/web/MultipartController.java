package eas.com.web;

import eas.com.vo.DummyResponseVO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
}
