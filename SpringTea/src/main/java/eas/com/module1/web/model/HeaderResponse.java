/*
 * Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package eas.com.module1.web.model;

/**
 *
 * @author eduardo
 */
public class HeaderResponse {

    private int cod;
    private String codInfo;
    private String message;

    public HeaderResponse(int cod, String codInfo, String message) {
        this.cod = cod;
        this.codInfo = codInfo;
        this.message = message;
    }
    
    public HeaderResponse() {
        this.cod = 200;
        this.codInfo = "OK";
        this.message = "";
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodInfo() {
        return codInfo;
    }

    public void setCodInfo(String codInfo) {
        this.codInfo = codInfo;
    }

}
