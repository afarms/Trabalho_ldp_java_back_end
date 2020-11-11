package com.atividade02.apihoroscopo.resources;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade02.apihoroscopo.models.Cliente;
import com.atividade02.apihoroscopo.models.Mensagem;
import com.atividade02.apihoroscopo.models.Plano;
import com.atividade02.apihoroscopo.repository.ClienteRepository;
import com.atividade02.apihoroscopo.repository.MensagemRepository;
import com.atividade02.apihoroscopo.repository.PlanoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="Horoscopo API REST")
@CrossOrigin(origins="*") // liberar todos os dominios acessar a API
public class PlanoResource { 
	
	private static final Logger LOGGER = Logger.getLogger(PlanoResource.class.getName());
	
	//criando um ponto de injeção para utilizar o metodos para se conectar com o banco
	@Autowired
	PlanoRepository planoRepository;
	
	@Autowired
	ClienteRepository clienterepository;
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	@GetMapping("/teste")
	@ApiOperation(value="Testa a API")
	public long teste(){
		
		return 32*40;
	}
	
	@GetMapping("/planos")
	@ApiOperation(value="Retorna uma lista de planos")
	public List<Plano> listaPlanos(){
		return planoRepository.findAll();
	}
	
	@GetMapping("/plano/{id}")
	@ApiOperation(value="Retorna um plano em especifico")
	public Plano listaPlanoUnico(@PathVariable(value="id") long id){
		return planoRepository.findById(id);
	}
	
	@GetMapping("/plano2/{id}")
	@ApiOperation(value="Retorna um plano em especifico")
	public Plano listaPlanoUnico2(@PathVariable(value="id") long id){
		return planoRepository.teste(id);
	}
	
	@GetMapping("/mensagens/{id}")
	@ApiOperation(value = "Retorna uma lista de Mensagens de acordo com o plano")
	public List<Mensagem> listaMensagens(@PathVariable(value="id") long id){
		return  mensagemRepository.listarMensagens(id);
	}
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value="Retorna um cliente")
	public Cliente listaClienteUnico(@PathVariable(value="id") long id){
		return clienterepository.findById(id);
	}
	@GetMapping("/login/{nome}/{senha}")
	@ApiOperation(value="Validação do login")
	public Cliente validaCliente(@PathVariable(value="nome") String nome,@PathVariable(value="senha") String senha ) {
		return clienterepository.findByNomeSenha(nome, senha);
	}
	
	@PostMapping("/plano")
	@ApiOperation(value="Salva um plano")
	public Plano salvaPlano(@RequestBody Plano plano) {
		return planoRepository.save(plano);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Salva um cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		try {
			
			return clienterepository.save(cliente);
			
		}catch(Exception e ) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			return null;
		}

	}
	
	
	@DeleteMapping("/plano")
	@ApiOperation(value="Deleta um plano")
	public void deletaPlano(@RequestBody Plano plano) {
		planoRepository.delete(plano);
	}
	
	@PutMapping("/plano")
	@ApiOperation(value="Atualiza um plano")
	public Plano atualizaPlano(@RequestBody Plano plano) {
		return planoRepository.save(plano);
	}
}
