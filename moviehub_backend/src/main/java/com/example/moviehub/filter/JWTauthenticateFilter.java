package com.example.moviehub.filter;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.moviehub.collection.JWTSubject;
import com.example.moviehub.service.Impl.UserServiceImpl;
import com.example.moviehub.util.JWTtokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTauthenticateFilter extends OncePerRequestFilter {

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        System.out.println(request.getServletPath());
//        if (request.getServletPath().contains("/auth")){
//            System.out.println("pass");
//            filterChain.doFilter(request, response);
//            return;
//        }


        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String jwtToken = authorizationHeader.substring(7);
            System.out.println(jwtToken);
            try{
                JWTtokenUtil.validateToken(jwtToken);

                JWTSubject subject = JWTtokenUtil.decode(jwtToken);
                String userEmail = subject.getEmail();

                if (subject.isRefresh()){
                    if (!request.getServletPath().equals("/user/refresh")){
                        String error_message = "Token Invalid";
                        logger.warn(error_message);
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        response.setHeader("error", error_message);
                        Map<String, String> error = new HashMap<>();
                        error.put("error_message", error_message);
                        response.setContentType("application/json");
                        new ObjectMapper().writeValue(response.getOutputStream(),error);
                        return;
                    }
                }

                if (SecurityContextHolder.getContext().getAuthentication() == null){
                    //load userDetail with the email
                    UserDetails userDetails = this.userService.loadUserByUsername(userEmail);
                    logger.info( "token_info\n"+ "email: " + userDetails.getUsername() + "\n" + "pwd: " + userDetails.getPassword());


                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                    filterChain.doFilter(request, response);
                }

            }catch (Exception e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setHeader("error", e.getMessage());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
//            catch (IllegalArgumentException e) {
//                System.out.println("Unable to get JWT Token");
//            } catch (Exception e) {
//                logger.warn(e.getMessage());
//            }
        } else {
            logger.warn("JWT Token not exist or does not begin with Bearer String");
            filterChain.doFilter(request, response);
        }


    }
}
