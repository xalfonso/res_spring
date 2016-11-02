/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package eas.com.module1.web.model;

/**
 *
 * @author eduardo
 */
public class ResponseData {

    final private HeaderResponse headerResponse;
    private String urlRequest;
    private String data;

    public ResponseData(HeaderResponse headerResponse, String data, String url) {
        this.headerResponse = headerResponse;
        this.data = data;
        this.urlRequest = url;
    }
    
    public ResponseData(String data, String url) {
        this.headerResponse = new HeaderResponse();
        this.data = data;
        this.urlRequest = url;
    }

    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrlRequest() {
        return urlRequest;
    }

    public void setUrlRequest(String urlRequest) {
        this.urlRequest = urlRequest;
    }
    

}
