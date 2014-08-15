package controllers;

import java.util.List;

import models.Carro;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;

public class CarrosController extends Controller{
	private static Form<Carro> carroForm = Form.form(Carro.class);
	
	public static Result home(){
		return ok(views.html.home.render());
	}
	
	public static Result cadastrarCarro(){
		return ok(views.html.cadastrarcarro.render(""));
	}
	
	public static Result salvar(){
		Form<Carro> formFromRequest = carroForm.bindFromRequest();
		Carro c = formFromRequest.get();
		Ebean.save(c);
		
		return ok(views.html.cadastrarcarro.render("Carro salvo com sucesso!"));
	}
	
	public static Result listar(){
		List<Carro> carros = Ebean.find(Carro.class).findList();
		return ok(views.html.carros.render(carros));
	}
	
	public static Result detalhar(Long id){
		Carro carroselecionado = Ebean.find(Carro.class, id);
		return ok(views.html.detalhacarro.render(carroselecionado));
	}
	
	public static Result editar(Long id){
		Carro carroselecionado = Ebean.find(Carro.class, id);
		return ok(views.html.editarcarro.render("", carroselecionado));
	}
	
	public static Result atualizar(Long id){
		Carro carroselecionado = Ebean.find(Carro.class, id);
		Form<Carro> atualizarForm = carroForm.bindFromRequest();
		atualizarForm.get().update(id);
		Carro carroatualizado = Ebean.find(Carro.class, id);
		return ok(views.html.detalhacarro.render(carroatualizado));
	}
	
	public static Result excluir(Long id) {
		Carro carroselecionado = Ebean.find(Carro.class, id);
		carroselecionado.delete();
		return listar();
	}
}
