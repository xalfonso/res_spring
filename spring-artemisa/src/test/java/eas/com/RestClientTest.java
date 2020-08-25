package eas.com;

import eas.com.vo.DummyResponseVO;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

    @Test
    public void uploadFilesAndDataJoinedWithFileAsBytes() throws IOException {

        //FILE 1
        byte[] bytesFile1 = Files.readAllBytes(new File("/home/eduardo/Desktop/clusters.csv").toPath());

        ContentDisposition contentDisposition1 = ContentDisposition
                .builder("form-data")
                .name("file")
                .filename("filename1")
                .build();
        MultiValueMap<String, String> fileMap1 = new LinkedMultiValueMap<>();
        fileMap1.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition1.toString());
        HttpEntity<byte[]> fileEntity1 = new HttpEntity<>(bytesFile1, fileMap1);

        //FILE 2
        byte[] bytesFile2 = Files.readAllBytes(new File("/home/eduardo/Desktop/Foto_Migracion.png").toPath());
        ContentDisposition contentDisposition2 = ContentDisposition
                .builder("form-data")
                .name("file")
                .filename("filename2")
                .build();
        MultiValueMap<String, String> fileMap2 = new LinkedMultiValueMap<>();
        fileMap2.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition2.toString());
        HttpEntity<byte[]> fileEntity2 = new HttpEntity<>(bytesFile2, fileMap2);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("file", fileEntity1);
        body.add("file", fileEntity2);


        //DATA
        body.add("data", "{\"codigoFactura\":\"5783852\",\"usuarioSession\":\"FRM2698\"}");


        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serverUrl = "http://localhost:8080/multipart/joined";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DummyResponseVO> response = restTemplate.postForEntity(serverUrl, requestEntity, DummyResponseVO.class);
        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().toString());


    }
}
