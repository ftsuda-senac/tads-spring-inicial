package br.senac.tads.dsw.exemplospringsecurity.sessao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("session")
@RequestMapping("/sessao")
public class SessaoController implements Serializable {

    private List<SessaoInfo> itensSessao = new ArrayList<>();

    @GetMapping
    public ModelAndView mostrarTela() {
        return new ModelAndView("sessao");
    }

    @PostMapping
    public ModelAndView adicionarDataHora(RedirectAttributes redirAttr, HttpServletRequest servletReq) {
        itensSessao.add(new SessaoInfo(LocalDateTime.now(), servletReq.getHeader("user-agent"), servletReq.getRemoteAddr()));
        redirAttr.addFlashAttribute("msg", "Item adicionado com sucesso");
        return new ModelAndView("redirect:/sessao");
    }

    @GetMapping("/limpar")
    public ModelAndView limparSessao(RedirectAttributes redirAttr) {
        itensSessao.clear();
        redirAttr.addFlashAttribute("msg", "Itens removidos");
        return new ModelAndView("redirect:/sessao");
    }
    
    public List<SessaoInfo> getItensSessao() {
        return this.itensSessao;
    }

}
