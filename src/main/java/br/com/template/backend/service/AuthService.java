package br.com.template.backend.service;

import br.com.template.backend.dto.AcessDTO;
import br.com.template.backend.dto.AuthDTO;
import br.com.template.backend.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthDTO authDTO) {

        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

            //Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            //Busca usuário logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;

        } catch (BadCredentialsException e) {
            //TODO login ou senha inválidos
        }
        return new AcessDTO("Acesso negado");
    }
}
