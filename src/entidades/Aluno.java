package entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	// Atributos
	private String nome;
	private String matricula;
	private Telefone telefone;
	private Email eMail;
	private Email uffMail;
	private AlunoStatus status;
	
	
	// M�todos GETs e SETTERs
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public Email geteMail() {
		return eMail;
	}
	
	public void seteMail(Email eMail) {
		this.eMail = eMail;
	}
	
	public Email getUffMail() {
		return uffMail;
	}
	
	public void setUffMail(Email uffMail) {
		this.uffMail = uffMail;
	}
	
	public AlunoStatus getStatus() {
		return status;
	}
	
	public void setStatus(AlunoStatus status) {
		this.status = status;
	}

	
	public List<Email> opcoesDeEmail() {
		
		List<Email> eMailsPossiveis = new ArrayList<Email>();
		
		// Pegar o nome da pessoa e converter para min�sculo
		String nomeCaixaBaixa = nome.toLowerCase();
		
		// Faz a separa��o dos nomes utilizando o caracter em branco como divisor dos nomes
		String[] arrayNomes = nomeCaixaBaixa.split(" ");
        
		// Gera��o do primeiro e-mail poss�vel
		String s = new String();
		s = arrayNomes[0] + "_" + arrayNomes[1] + "@id.uff.br";
		
		Email e = new Email();
		e.seteMail(s);
		
		eMailsPossiveis.add(e);
		
		
		// Gera��o do segundo e-mail poss�vel
		s = arrayNomes[0] + arrayNomes[1].charAt(0) + arrayNomes[2].charAt(0) + "@id.uff.br";
		
		e = new Email();
		e.seteMail(s);
				
		eMailsPossiveis.add(e);
		
		
		// Gera��o do terceiro e-mail poss�vel
		s = arrayNomes[0] + arrayNomes[arrayNomes.length-1] + "@id.uff.br";
				
		e = new Email();
		e.seteMail(s);
						
		eMailsPossiveis.add(e);
		
		
		// Gera��o do quarto e-mail poss�vel
		s = arrayNomes[0].charAt(0) + arrayNomes[arrayNomes.length-1] + "@id.uff.br";
		
		e = new Email();
		e.seteMail(s);
								
		eMailsPossiveis.add(e);
		
		
		// Gera��o do quinto e-mail poss�vel
		s = arrayNomes[0].charAt(0) + arrayNomes[1]  + arrayNomes[2] + "@id.uff.br";
						
		e = new Email();
		e.seteMail(s);
										
		eMailsPossiveis.add(e);
		
		return eMailsPossiveis;
	}
	
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", telefone=" + telefone + ", eMail=" + eMail
				+ ", uffMail=" + uffMail + ", status=" + status + "]";
	}
	
	
}
