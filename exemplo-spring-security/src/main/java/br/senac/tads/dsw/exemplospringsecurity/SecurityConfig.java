package br.senac.tads.dsw.exemplospringsecurity;

// Configuração do Spring Security pós versão 5.7/Boot 2.7
// Ver https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
// @Configuration
public class SecurityConfig {

//    public static PasswordEncoder plainPasswordEncoder() {
//        return new PasswordEncoder() {
//
//            @Override
//            public String encode(CharSequence cs) {
//                return cs.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence cs, String hashSenha) {
//                return hashSenha
//                        != null && hashSenha.equals(cs.toString());
//            }
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return plainPasswordEncoder();
//        // return new BCryptPasswordEncoder();
//    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        return http.build();
//    }

}
