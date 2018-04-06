package eas.com.config;

public enum Views {
    INSERT_STUDENT("academy/insertStudent"),
    LIST_STUDENT("academy/listStudent");


    Views(String url) {
        this.url = url;
    }

    public final String url;
}