package cn.disscode.app.controller;

import cn.disscode.app.securrity.service.JwtUserDetailsServiceImpl;
import cn.disscode.app.securrity.utils.JwtTokenUtil;
import cn.disscode.app.service.IUserService;
import cn.disscode.app.vo.UserVo;
import cn.disscode.common.core.Result;
import cn.disscode.common.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: dumplingBao
 * @Date: 2021/9/13
 */
@CrossOrigin
@RestController
//@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody UserVo userVo) {

        try {
            UsernamePasswordAuthenticationToken upaToken = new UsernamePasswordAuthenticationToken(userVo.getUsername(),userVo.getPassword());
            // Perform the security
            final Authentication authentication = authenticationManager.authenticate(upaToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Reload password post-security so we can generate token
            final UserDetails userDetails = userDetailsService.loadUserByUsername(userVo.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return Result.success(token);
        }catch (BadCredentialsException e) {
            log.error("用户名或密码不正确...",e);
            return Result.fail(ResultEnum.LOGIN_FAIL);
        }catch (RuntimeException e) {
            log.error("用户名被停用...",e);
            return Result.fail(ResultEnum.LOGIN_FAIL);
        }
        catch (Exception e) {
            log.error("系统异常...",e);
            return Result.fail(ResultEnum.LOGIN_FAIL);
        }
    }

    /**
     * 简单注册
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/register")
    public Result register(@RequestBody UserVo userVo){
        if(StringUtils.isBlank(userVo.getUsername())){
            return Result.fail("用户名不能为空！");
        }
        if(StringUtils.isBlank(userVo.getPassword())){
            return Result.fail("密码不能为空！");
        }
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));

        userService.save(userVo);
        return Result.success(userVo.getUsername());
    }
}
