package eas.com.security;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Custom Principal.
 *
 * @author Eduardo Alfonso
 */
@Getter
public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private CustomPrincipalToken customPrincipalToken;


    /**
     * Create an {@link CustomAuthenticationToken}
     *
     * @param customPrincipalToken
     */
    public CustomAuthenticationToken(CustomPrincipalToken customPrincipalToken) {
        super(null);
        this.customPrincipalToken = customPrincipalToken;
    }

    /**
     * Create an {@link CustomAuthenticationToken} set true the authenticated flag.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public CustomAuthenticationToken(CustomPrincipalToken customPrincipalToken, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.customPrincipalToken = customPrincipalToken;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public CustomPrincipalToken getPrincipal() {
        return this.customPrincipalToken;
    }
}
