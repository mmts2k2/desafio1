package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.AlunoStatus;
import entidades.Email;
import entidades.Telefone;


public class CSV {
	
	public static List<Aluno> leArquivoCSV(File arquivoCSV) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
		String linha = "";

		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		
		br.readLine(); // Para pular a primeira linha que está o cabeçalho do arquivo .csv
		while ((linha = br.readLine()) != null) {
		    
		    String[] coluna = linha.split(",");
		    		    
		    Aluno aluno = new Aluno();
			aluno.setNome(coluna[0]);
			aluno.setMatricula(coluna[1]);
			
			Telefone tel = new Telefone();
			tel.setTelefone(coluna[2]);
			
			aluno.setTelefone(tel);
			
			Email e1 = new Email();
			e1.seteMail(coluna[3]);
			
			aluno.seteMail(e1);
			
			Email e2 = new Email();
			e2.seteMail(coluna[4]);
			
			aluno.setUffMail(e2);
			
			if ( coluna[5].equals("Ativo") )
				aluno.setStatus(AlunoStatus.Ativo);
			else 
				aluno.setStatus(AlunoStatus.Inativo);
			
						
			listaDeAlunos.add(aluno);
		}
		
		br.close();
		return listaDeAlunos;
	}
	
}
