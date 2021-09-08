package cn.disscode.app.securrity.model;

import cn.disscode.app.dto.UserRoleDto;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 *  JwtUser
 *
 * @Author: dumplingbao
 * @Date: 2021/9/1
 */
@Data
public class JwtUser implements UserDetails {

    private String username;

    private String password;

    private Boolean enabled;

    private Collection<? extends GrantedAuthority> authorities;

    private List<UserRoleDto> userRoles;

    public JwtUser(String username, String password, Boolean enabled, Collection<? extends GrantedAuthority> authorities, List<UserRoleDto> userRoles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}