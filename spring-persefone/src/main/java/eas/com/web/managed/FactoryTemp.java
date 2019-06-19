package eas.com.web.managed;

public class FactoryTemp {
    private static KSecurityContextRepository kSecurityContextRepository = new KSecurityContextRepository();

    public static KSecurityContextRepository buildObject() {
        return kSecurityContextRepository;
    }
}
