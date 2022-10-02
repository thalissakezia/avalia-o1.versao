package alfabetizarApp;
import java.util.Scanner;
import alfabetizarDao.AlfabetizarDao;
import model_Alfabetizar.Estudante;

public class AlfabetizarMain {
	static int id_usuario = 1;
	static int menu = 0;
	static Scanner entrarRegistro = new Scanner(System.in);
	static Scanner entrarUpdate = new Scanner(System.in);
	static Scanner entrarMenu = new Scanner(System.in);
	static Scanner entrarDelete = new Scanner(System.in);
	
	//Registro de Estudante
	static void registro() throws Exception {
		AlfabetizarDao estudanteDao = new AlfabetizarDao();
		Estudante estudante1 = new Estudante();	
		entrarRegistro = new Scanner(System.in);
		System.out.println("Informe o seu Nome e Sobrenome: ");
		String nome = entrarRegistro.nextLine();		
		estudante1.setNome_sobrenome(nome);
		entrarRegistro = new Scanner(System.in);
		System.out.println("Informe um apelido:");
		String id_login = entrarRegistro.nextLine();
		estudante1.setLogin(id_login);
		entrarRegistro = new Scanner(System.in);
		System.out.println("Insira sua senha: ");
		String senha = entrarRegistro.nextLine();
		estudante1.setSenha(senha);;
		estudanteDao.salvar(estudante1);
		System.out.println("Quer cadastrar outro? 1 - Para sim e 2 - Para voltar ao menu");
		entrarRegistro = new Scanner(System.in);
		int menu = entrarRegistro.nextInt();
		switch (menu) {
		case 1:
			registro();
			break;
		case 2:
			menu();
			break;
		}

	}
	
	//Listagem de estudante
	static void ranks() throws Exception {
		AlfabetizarDao estudanteDao = new AlfabetizarDao();		
		
		
		for (Estudante listaEstudante : estudanteDao.getEstudante()) {
			System.out.println("________________________________________");
			System.out.println("Id do Usuario: " + listaEstudante.getId_usuario());
			System.out.println("Nome do(a) Estudante: " + listaEstudante.getNome_sobrenome());
			System.out.println("Login (apelido): " + listaEstudante.getLogin());
			//System.out.println("Senha: " + listaEstudante.getSenha());
			System.out.println("Nivel do Jogo Atual: " + listaEstudante.getId_jogo());
			System.out.println("Palavras: " + listaEstudante.getPalavras());
			System.out.println("________________________________________");	
			
			}
		menu();
		}
	static void update() throws Exception {
		Estudante estudanteUpdate = new Estudante();
		AlfabetizarDao atualizacao = new AlfabetizarDao();
		System.out.println("Informe o seu ID: ");
		entrarUpdate = new Scanner(System.in);
		estudanteUpdate.setId_usuario(entrarUpdate.nextInt());
		System.out.println("Informe o seu Nome: ");
		entrarUpdate = new Scanner(System.in);
		estudanteUpdate.setNome_sobrenome(entrarUpdate.nextLine());
		System.out.println("Informe o novo Login: ");
		entrarUpdate = new Scanner(System.in);
		estudanteUpdate.setLogin(entrarUpdate.nextLine());
		System.out.println("Informe a senha nova: )");
		entrarUpdate = new Scanner(System.in);
		estudanteUpdate.setSenha(entrarUpdate.nextLine());
		entrarUpdate = new Scanner(System.in);
		atualizacao.update(estudanteUpdate);
		System.out.println("Atualizado com Sucesso");
		menu();
	}
	
	//Deletar Estudante
	static void delete() throws Exception {
		AlfabetizarDao delete = new AlfabetizarDao();
		System.out.println("Qual usuario você quer deleta? Selecione o Id do Viajante");
		int id_usuario_id = entrarDelete.nextInt();
		delete.delete(id_usuario_id);
		System.out.println("Usuario "+ id_usuario_id + " deletado com sucesso");
		menu();
	}
	
	//Menu
	static void menu() throws Exception {
		System.out.println("============= Bem vindo(a) ao Alfabetizar =============");
		System.out.println("Selecione uma das opções:");
		System.out.println("1) Para fazer um Registro");
		System.out.println("2) Atualizar Cadastro");
		System.out.println("3) Para visualisar nossos Cadastros");
		System.out.println("4) Para Deletar um Cadastro");
		int menu = entrarMenu.nextInt();
		switch (menu) {
		case 1:
			System.out.println("Registro Selecionado");
			registro();
			break;
		case 2:
			System.out.println("Atualizar Cadastro Selecionado");
			update();
			break;
		case 3:
			System.out.println("Visualizar cadastros Selecionado");
			ranks();
			break;
		case 4:
			System.out.println("Deletar Cadastro Selecionado");
			delete();
			break;
		default:
			System.out.println("Insira um numero valido");
			menu();
			break;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		menu();

	}
}
