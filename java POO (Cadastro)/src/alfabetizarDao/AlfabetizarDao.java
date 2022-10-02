package alfabetizarDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.ClientPreparedStatement;

import model_Alfabetizar.Estudante;
import alfabetizarFactory.ConnectionFactory;

public class AlfabetizarDao {


	public void salvar(Estudante estudante) {
		String sql = "INSERT INTO usuario(id_usuario, nome_sobrenome, senha, login) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		ClientPreparedStatement pstm = null;

		
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, estudante.getId_usuario());
			pstm.setString(2, estudante.getNome_sobrenome());
			pstm.setString(3, estudante.getSenha());
			pstm.setString(4, estudante.getLogin());
			pstm.execute();

			System.out.println("Estudante Cadastrado com Sucesso :)");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null && pstm!=null) {
					pstm.close();

					
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Listagem entre as tabelas usando o Join
	public List<Estudante> getEstudante(){
		String sql = "select * From usuario a "+
	"join jogo b "+
				"on a.id_jogo = b.id_jogo";
		List<Estudante> estudante = new ArrayList<Estudante>();
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		ResultSet resultSet = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			resultSet = pstm.executeQuery();
			
			while (resultSet.next()) {
				Estudante estudanteLista = new Estudante();
				estudanteLista.setId_usuario(resultSet.getInt("id_usuario"));
				estudanteLista.setNome_sobrenome(resultSet.getString("nome_sobrenome"));
				estudanteLista.setLogin(resultSet.getString("login"));
				//estudanteLista.setSenha(resultSet.getString("senha"));
				estudanteLista.setId_jogo(resultSet.getInt("id_jogo"));
				estudanteLista.setPalavras(resultSet.getString("palavras"));
				estudante.add(estudanteLista);
			}
			}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(resultSet!=null) {
							resultSet.close();
						}
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					
					}				
				}		
				return estudante;
				}
	public void update (Estudante estudante) {
		String sql = "UPDATE usuario SET nome_sobrenome = ?, login = ?, senha = ?"+
	"WHERE id_usuario = ?";
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, estudante.getNome_sobrenome());
			pstm.setString(2, estudante.getLogin());
			pstm.setString(3, estudante.getSenha());
			pstm.setInt(4, estudante.getId_usuario());
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//Delete por ID
	public void delete(int id_usuario) {
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id_usuario);
			pstm.execute();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}
