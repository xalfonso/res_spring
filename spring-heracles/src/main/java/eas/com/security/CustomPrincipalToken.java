package eas.com.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

/**
 * Custom Principal.
 *
 * @author Eduardo Alfonso
 */
@EqualsAndHashCode(of = "token", callSuper = false)
@Getter
public class CustomPrincipalToken extends User {

    private final String token;

    public CustomPrincipalToken(String token) {
        super(token + "_user", token + "_password", Collections.emptyList());
        this.token = token;
    }

    public CustomPrincipalToken(String token, Collection<? extends GrantedAuthority> authorities) {
        super(token + "_user", token + "_password", authorities);
        this.token = token;
    }

    public CustomPrincipalToken(String token, Collection<? extends GrantedAuthority> authorities, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked) {
        super(token + "_user", token + "_password", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.token = token;
    }
}
