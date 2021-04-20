package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorDAO implements GenericDAO<Professor>{

	private final Connection conexao;

	public ProfessorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Professor professor) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("INSERT INTO Professor (nome, idade) VALUES (?, ?)");
			stmt.setString(1, professor.getNome());
			stmt.setInt(2, professor.getIdade());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Professor selectById(Long id) {
		Professor professor = null;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Professor WHERE id = ?");
			stmt.setLong(1, id);
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long idProfessor = rsts.getLong("id");
				String nome = rsts.getString("nome");
				int idade = rsts.getInt("idade");
				professor = new Professor(idProfessor, nome, idade);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return professor;
	}
	
	public Professor selectByName(String nome) {
		Professor professor = null;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Professor WHERE nome = ?");
			stmt.setString(1, nome);
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long id = rsts.getLong("id");
				String nomeProfessor = rsts.getString("nome");
				int idade = rsts.getInt("idade");
				professor = new Professor(id, nomeProfessor, idade);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return professor;
	}

	public List<Professor> selectAll() {

		List<Professor> professores = new ArrayList<>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Professor");
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long id = rsts.getLong("id");
				String nome = rsts.getString("nome");
				int idade = rsts.getInt("idade");
				professores.add(new Professor(id, nome, idade));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return professores;
	}

	public void update(Professor professor, Long id) {
		try {
			PreparedStatement stmt = this.conexao
					.prepareStatement("UPDATE Professor SET nome = ?, idade = ? WHERE id = ?");
			stmt.setString(1, professor.getNome());
			stmt.setInt(2, professor.getIdade());
			stmt.setLong(3, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM Professor WHERE id = ?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
