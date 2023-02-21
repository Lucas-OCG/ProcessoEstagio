package br.com.ProcessoEstagio.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ProcessoEstagio.dao.VendedorDao;
import br.com.ProcessoEstagio.models.Vendedor;

@Controller
public class VendedorController {

	@Autowired
	private VendedorDao vendedorDao;
	
	@RequestMapping("/vendedores")
	public ModelAndView listaVendedores() {
		ModelAndView model = new ModelAndView("vendedor/listaVendedor");
		Iterable<Vendedor> vendedores = vendedorDao.findAll();
		model.addObject("vendedores", vendedores);
		return model;
	}

	@RequestMapping(value = "/cadastrarVendedor", method = RequestMethod.GET)
	public String form() {
		return "vendedor/cadastroVendedor";
	}

	@RequestMapping(value = "/cadastrarVendedor", method = RequestMethod.POST)
	public String form(@Valid Vendedor vendedor, BindingResult request, RedirectAttributes response) {

		if (request.hasErrors()) {
			response.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarVendedor";
		}
		
		vendedorDao.save(vendedor);
		response.addFlashAttribute("mensagem", "Vendedor cadastrado com sucesso!");
		
		return "redirect:/cadastrarVendedor";
	}

	@RequestMapping("/deletarVendedor")
	public String deletarVendedor(String cpfCnpj) {
		Vendedor vendedor = vendedorDao.findByCpfCnpj(cpfCnpj);
		vendedorDao.delete(vendedor);
		return "redirect:/vendedores";
	}

	@RequestMapping(value = "/editarVendedor", method = RequestMethod.GET)
	public ModelAndView editarVendedor(String cpfCnpj) {
		Vendedor vendedor = vendedorDao.findByCpfCnpj(cpfCnpj);
		ModelAndView model = new ModelAndView("vendedor/editarVendedor");
		model.addObject("vendedor", vendedor);
		return model;
	}

	@RequestMapping(value = "/editarVendedor", method = RequestMethod.POST)
	public String updateVendedor(@Valid Vendedor vendedor) {
		vendedorDao.save(vendedor);
		return "redirect:/vendedores";
	}
}