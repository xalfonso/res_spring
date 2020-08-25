package eas.com;

import eas.com.vo.DummyResponseVO;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestClientTest {

    @Test
    public void uploadFilesAndDataDivide() {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource("/home/eduardo/Desktop/clusters.csv"));
        body.add("file", new FileSystemResource("/home/eduardo/Desktop/Foto_Migracion.png"));
        body.add("data", "{\"codigoFactura\":\"5783852\",\"usuarioSession\":\"FRM2698\"}");


        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serverUrl = "http://localhost:8080/multipart/divide";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DummyResponseVO> response = restTemplate.postForEntity(serverUrl, requestEntity, DummyResponseVO.class);
        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().toString());


    }

    @Test
    public void uploadFilesAndDataJoined() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource("/home/eduardo/Desktop/clusters.csv"));
        body.add("file", new FileSystemResource("/home/eduardo/Desktop/Foto_Migracion.png"));
        body.add("data", "{\"codigoFactura\":\"5783852\",\"usuarioSession\":\"FRM2698\"}");


        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serverUrl = "http://localhost:8080/multipart/joined";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DummyResponseVO> response = restTemplate.postForEntity(serverUrl, requestEntity, DummyResponseVO.class);
        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().toString());
    }
}
