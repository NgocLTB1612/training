package com.bookpack.controller;

import com.bookpack.entity.AuthRequest;
import com.bookpack.entity.LoginResponse;
import com.bookpack.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";
    }
    @PostMapping("/login")
    public Object generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("invalid");
        }
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return new LoginResponse(token);
    }
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}
