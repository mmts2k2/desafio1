package main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import entidades.Aluno;
import entidades.AlunoStatus;
import entidades.Email;
import utils.CSV;

public class Executa {

	public static void main(String[] args) {

		List<Aluno> listaAlunos = null;
		File arquivoCSV = new File("src//csv//alunos.csv");
		try {
			listaAlunos = CSV.leArquivoCSV(arquivoCSV);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("O arquivo " + arquivoCSV.getName() + " não foi encontrado!");
			System.exit(1); // Aborta o programa quando não acha o arquivo "alunos.csv"
		}

		System.out.println("Digite sua matrícula: ");
		Scanner sc = new Scanner(System.in);
		String mat = sc.nextLine();
		
		
		Aluno aluno = null;
		
		// Busca por um aluno através da sua matrícula digitada
		for (int i=0; i < listaAlunos.size(); i++) {
			if ( listaAlunos.get(i).getMatricula().equals(mat) ) {
				aluno = listaAlunos.get(i);
			}
		}
		
		if ( aluno != null) {
			if ( aluno.getStatus().equals(AlunoStatus.Inativo) ) {
				System.out.println("Você é um aluno inativo. Apenas aluno ativo pode criar um UFFMail!");
			} else {
				if ( aluno.getUffMail().geteMail().equals("") ) {
			
					System.out.println("\n" + aluno.getNome().split(" ")[0] + ", por favor escolha uma das opções abaixo para o seu UFFMail");
			
					List<Email> listaDePossiveisEmails = aluno.opcoesDeEmail();
			
					int cont=0;
					for (Email e : listaDePossiveisEmails) {
						System.out.println(++cont + " - " + e.geteMail());	
					}
					System.out.println("");
		
					int opcao = sc.nextInt();
					
					while ( opcao < 1 || opcao > (listaDePossiveisEmails.size()) ) {
						System.out.println("Opção inválida, por favor digite uma opção entre os valores (1 e " + (listaDePossiveisEmails.size()) + "): " );
						opcao = sc.nextInt();
					}
					
					// Fecha o Scanner
					sc.close();
					
					System.out.println("A criação de seu e-mail (" + listaDePossiveisEmails.get(opcao-1) + ") será feita nos próximos minutos. Um SMS foi enviado para " + aluno.getTelefone().getTelefone() + " com a sua senha de acesso.");
			
					//Atualiza o objeto aluno com a opção de e-mail escolhida por ele
					aluno.setUffMail(listaDePossiveisEmails.get(opcao-1));
			
				} else {
					System.out.println("Você só pode ter um UFFMail!");
				}
			}
			
		} else {
			System.out.println("Matrícula não encontrada!");
		}
		
	}
}
