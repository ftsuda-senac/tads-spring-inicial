package br.senac.tads.dsw.exemplosspring;

import br.senac.tads.dsw.exemplosspring.produto.Categoria;
import br.senac.tads.dsw.exemplosspring.produto.CategoriaRepository;
import br.senac.tads.dsw.exemplosspring.produto.Produto;
import br.senac.tads.dsw.exemplosspring.produto.ProdutoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ModelAndView listar(
            @RequestParam(name = "pagina", defaultValue = "0") int pagina,
            @RequestParam(name = "qtd", defaultValue = "500") int qtd,
            @RequestParam(name = "idsCat", required = false) List<Integer> idsCat) {
        return new ModelAndView("produtos/lista").addObject("produtos", service.findAll(idsCat, pagina, qtd));
    }

    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {
        return new ModelAndView("produtos/form").addObject("produto", new Produto());
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") Long id, RedirectAttributes redirAttr) {
        Optional<Produto> optProd = service.findById(id);
        if (!optProd.isPresent()) {
            redirAttr.addFlashAttribute("msgErro", "Produto com ID " + id + " não encontrado");
            return new ModelAndView("redirect:/produtos");
        }
        Produto prod = optProd.get();
        return new ModelAndView("produtos/form").addObject("produto", prod);
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute @Valid Produto produto, BindingResult bindingResult,
            RedirectAttributes redirAttr) {
        service.salvar(produto);
        redirAttr.addFlashAttribute("msgSucesso",
                "Produto " + produto.getNome() + " salvo com sucesso");
        return new ModelAndView("redirect:/produtos");
    }

    @PostMapping("/{id}/remover")
    public ModelAndView remover(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        service.remover(id);
        redirectAttributes.addFlashAttribute("msgSucesso",
                "Produto ID " + id + " removido com sucesso");
        return new ModelAndView("redirect:/produtos");
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

}
