package br.senac.tads.dsw.exemplospringsecurity.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import br.senac.tads.dsw.exemplospringsecurity.dominio.Papel;
import br.senac.tads.dsw.exemplospringsecurity.dominio.UsuarioSistema;

@Service
public class UsuarioSistemaService {

    private final Map<String, UsuarioSistema> usuariosCadastrados = new LinkedHashMap<>();

//    // DESCOMENTAR NA CLASSE SecurityConfig O BLOCO DO PasswordEncoder
//
//    private PasswordEncoder passwordEncoder;
//
//    public UsuarioSistemaService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    private String gerarHashSenha(String senhaAberta) {
        // return passwordEncoder.encode(senhaAberta);
        return senhaAberta; // TROCAR PELO CODIGO ACIMA DEPOIS DE HABILITAR O passwordEncoder
    }

    // SIMULA O "CADASTRO" DE USUARIOS HABILITADOS PARA ACESSAR A APLICAÇÃO
    @PostConstruct
    private void init() {
        String senhaAbertaPadrao = "abcd1234";
        // @formatter:off
        usuariosCadastrados.put("denver",
                new UsuarioSistema("denver", "Ricardo Ramos",
                        gerarHashSenha(senhaAbertaPadrao),
                        Arrays.asList(new Papel("ROLE_PEAO"))));
        usuariosCadastrados.put("tokio",
                new UsuarioSistema("tokio", "Silene Oliveira",
                        gerarHashSenha(senhaAbertaPadrao),
                        Arrays.asList(new Papel("ROLE_PEAO"))));
        usuariosCadastrados.put("berlin",
                new UsuarioSistema("berlin", "Andres de Fonollosa",
                        gerarHashSenha(senhaAbertaPadrao),
                        Arrays.asList(new Papel("ROLE_PEAO"), new Papel("ROLE_FODON"))));
        usuariosCadastrados.put("professor",
                new UsuarioSistema("professor", "Sergio Marquina",
                        gerarHashSenha(senhaAbertaPadrao),
                        Arrays.asList(new Papel("ROLE_PEAO"), new Papel("ROLE_GOD"))));
        // @formatter:on
    }

}
