package loja;

import java.util.Scanner;

import loja.veiculo.Carro;
import loja.veiculo.Motocicleta;
import loja.veiculo.types.Chassi;
import loja.veiculo.types.Modelo;
import loja.veiculo.types.Montadora;
import loja.veiculo.types.Tipo;

public class Loja {
	/**
	 * Class Loja Controle de estoque
	 * @author isvaldo,Yan
	 * @param endereco local da loja
	 * @param nome nome da loja
	 * @param carros Array primitiva de carros
	 * @param motocicleta Array primitiva de motocicleta
	 * */
	
	private String endereco;
	private String nome;
	private Carro[] carros;
	private Motocicleta[] motocicletas;
	private static final int CARROESTOQUE = 10;
	private static final int MOTOESTOQUE = 10;
	private Scanner sc = new Scanner(System.in);;

	/**
	 * Construtor de Loja
	 * Inicia os valores default para arrays primitivas
	 * */
	Loja(){
		this.carros = new Carro[CARROESTOQUE];
	}

	/**
	 * adicionaCarro Adiciona objeto carro a lista
	 * primitiva de carros
	 * @param carro, objeto carro
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	private void adicionaCarro(Carro carro, int p) {
		// TODO filtro de erros para p invalida
		this.carros[p] = carro; 
	}
	
	/**
	 * adicionaMoto Adiciona objeto carro a lista
	 * primitiva de Motocicleta
	 * @param moto, objeto Motocicleta
	 * @param p, posição a ser inserida, caso exista é sobrescrito
	 * */
	
	private void adicionaMoto(Motocicleta moto, int p) {
		// TODO filtro de erros para p invalida
		this.motocicletas[p] = moto; 
	}
	
	public void adicionaMotoUsuario(){
		Chassi chassi = getChassi();
		
	}

	/**
	 * getChassi
	 * Mostra uma lista valida de chassi
	 * @return Objeto chassi
	 */
	private Chassi getChassi() {
		//@TODO colocar filtros
		System.out.println("Escolha um chassi disponivel");
		this.mostraOpcao(Chassi.class);
		System.out.println("Informe uma ID(numeral)");
		return Chassi.valueOf(getGenericsEnumByCode(Chassi.class,this.sc.nextInt()));
		
	}
	
	/**
	 * getMontadora
	 * Mostra uma lista valida de Montadora
	 * @return Objeto Montadora
	 */
	private Montadora getMontadora() {
		//@TODO colocar filtros
		System.out.println("Escolha uma Montadora disponivel");
		this.mostraOpcao(Montadora.class);
		System.out.println("Informe uma ID(numeral)");
		return Montadora.valueOf(getGenericsEnumByCode(Montadora.class,this.sc.nextInt()));
		
	}
	
	/**
	 * getModelo
	 * Mostra uma lista valida de Modelo
	 * @return Objeto Modelo
	 */
	private Modelo getModelo() {
		//@TODO colocar filtros
		System.out.println("Escolha uma Montadora disponivel");
		this.mostraOpcao(Modelo.class);
		System.out.println("Informe uma ID(numeral)");
		return Modelo.valueOf(getGenericsEnumByCode(Modelo.class,this.sc.nextInt()));
	}
	
	/**
	 * getTipo
	 * Mostra uma lista valida de Tipo
	 * @return Objeto Tipo
	 */
	private Tipo getTipo() {
		//@TODO colocar filtros
		System.out.println("Escolha uma Montadora disponivel");
		this.mostraOpcao(Tipo.class);
		System.out.println("Informe uma ID(numeral)");
		return Tipo.valueOf(getGenericsEnumByCode(Tipo.class,this.sc.nextInt()));
	}
	
	
	
	public static void main(String[] args) {
		new Loja().adicionaMotoUsuario();
	}

	/**
	 * mostraOpcao mostra opções de um enum de forma generica
	 * @param enumClass classe de um enum
	 */
	private <T extends Enum<T>> void mostraOpcao(Class<T> enumClass) {
	    for (Enum<T> item : enumClass.getEnumConstants()) {
	    	// Mostra valor -> representacao
	        System.out.println(item.ordinal()+"->"+item.toString());
	    }
	}

	
	/**
	 * getGenericsEnumByCode retorna um enum generico pelo codigo
	 * @param enumClass classe de um enum
	 * @param code valor que apontado pelo enum
	 */
	private  <T extends Enum<T>> String getGenericsEnumByCode(Class<T> enumClass,int code) {
	    for (Enum<T> item : enumClass.getEnumConstants()) {
	    	if (item.ordinal() ==code){
	    		return item.toString();
	    	}
	    }
	    //@TODO adicionar filtros
	    return "not found";
	}
	
	// Get e Set
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}

	public Motocicleta[] getMotocicletas() {
		return motocicletas;
	}

	public void setMotocicletas(Motocicleta[] motocicletas) {
		this.motocicletas = motocicletas;
	}

	public static int getCarroestoque() {
		return CARROESTOQUE;
	}

	public static int getMotoestoque() {
		return MOTOESTOQUE;
	}
	// fim get  e set
	
	
}
