package eas.com.web;

import eas.com.vo.DummyRequestVO;
import eas.com.vo.DummyResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("dummy")
@RestController
public class DummyController {

    @GetMapping("get")
    public ResponseEntity<DummyResponseVO> dummy() {
        return ResponseEntity.ok(new DummyResponseVO("All OK"));
    }
}
