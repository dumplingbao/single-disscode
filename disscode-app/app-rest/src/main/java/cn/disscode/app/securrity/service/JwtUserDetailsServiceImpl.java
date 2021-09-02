package cn.disscode.app.securrity.service;

import cn.disscode.app.dto.UserDto;
import cn.disscode.app.securrity.model.JwtUser;
import cn.disscode.app.service.IUserService;
import cn.disscode.app.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户认证
 *
 * @Author: dumplingbao
 * @Date: 2021/9/1
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        UserDto userDto = userService.fetchOne(userVo);
        if (userDto == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(authority);
        return new JwtUser(userDto.getUsername(), userDto.getPassword(), userDto.getEnabled(), authorities);
    }
}
