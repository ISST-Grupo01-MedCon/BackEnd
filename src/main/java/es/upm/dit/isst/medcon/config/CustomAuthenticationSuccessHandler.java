package es.upm.dit.isst.medcon.config;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler
    implements AuthenticationSuccessHandler {
 
        private ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {
                    response.setStatus(HttpStatus.OK.value());
                    Map<String, Object> data = new HashMap<>();
                    data.put(
                      "timestamp", 
                      Calendar.getInstance().getTime());
            
                    response.getOutputStream()
                      .println(objectMapper.writeValueAsString(data));
        
        }
}
