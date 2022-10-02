package model_Alfabetizar;

public class Estudante {
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_sobrenome() {
		return nome_sobrenome;
	}
	public void setNome_sobrenome(String nome_sobrenome) {
		this.nome_sobrenome = nome_sobrenome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getId_jogo() {
		return id_jogo;
	}
	public void setId_jogo(int id_jogo) {
		this.id_jogo = id_jogo;
	}
	public String getPalavras() {
		return palavras;
	}
	public void setPalavras(String palavras) {
		this.palavras = palavras;
	}
	
	private int id_usuario;
	private String nome_sobrenome;
	private String senha;
	private String login;
	private int id_jogo;
	private String palavras;


}
