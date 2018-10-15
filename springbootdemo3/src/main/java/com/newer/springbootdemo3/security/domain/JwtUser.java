package com.newer.springbootdemo3.security.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newer.springbootdemo3.domain.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
/*
* security框架管理的用户类
* 必须实现UserDetails接口
* */
public class JwtUser implements UserDetails{

    private final Integer userid;//必须
    private final String username;//必须
    private final String password;//必须
    private final boolean enabled;//必须
    private final Integer state;
    private final String email;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private final Date loginTime;
    private final Integer doid;
    private final String by1;
    private final Date lastpasswordresetdate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Integer userid, String username, String password, boolean enabled, Integer state, String email, Date loginTime, Integer doid, String by1, Date lastpasswordresetdate, Collection<? extends GrantedAuthority> authorities) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.state = state;
        this.email = email;
        this.loginTime = loginTime;
        this.doid = doid;
        this.by1 = by1;
        this.lastpasswordresetdate = lastpasswordresetdate;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Integer getUserid() {
        return userid;
    }

    public Integer getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Integer getDoid() {
        return doid;
    }

    public String getBy1() {
        return by1;
    }

    @JsonIgnore
    public Date getLastpasswordresetdate() {
        return lastpasswordresetdate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
