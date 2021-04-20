package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.MesmoNomeException;
import model.Curso;

public class CursoDAO implements GenericDAO<Curso> {
	private final Connection conexao;

	public CursoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Curso curso) {
		try {
			if (verificarNome(curso.getNome()) == false) {
				PreparedStatement stmt = this.conexao
						.prepareStatement("INSERT INTO Curso (nome, idProfessor) VALUES (?, ?)");
				stmt.setString(1, curso.getNome());
				stmt.setLong(2, curso.getIdProfessor());
				stmt.execute();
			}
		} catch (MesmoNomeException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL E" + e.getMessage());
		}
	}

	public Curso selectById(Long id) {
		Curso curso = null;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Curso WHERE id = ?");
			stmt.setLong(1, id);
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long idCurso = rsts.getLong("id");
				String nome = rsts.getString("nome");
				Long idProfessor = rsts.getLong("idProfessor");
				curso = new Curso(idCurso, nome, idProfessor);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public Curso selectByName(String nome) {
		Curso curso = null;

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Curso WHERE nome = ?");
			stmt.setString(1, nome);
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long id = rsts.getLong("id");
				String nomeCurso = rsts.getString("nome");
				Long idProfessor = rsts.getLong("idProfessor");
				curso = new Curso(id, nomeCurso, idProfessor);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public List<Curso> selectAll() {

		List<Curso> cursos = new ArrayList<>();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Curso");
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long id = rsts.getLong("id");
				String nome = rsts.getString("nome");
				Long idProfessor = rsts.getLong("idProfessor");
				cursos.add(new Curso(id, nome, idProfessor));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cursos;
	}

	public void update(Curso curso, Long id) {
		try {
			PreparedStatement stmt = this.conexao
					.prepareStatement("UPDATE Professor SET nome = ?, idProfessor = ? WHERE id = ?");
			stmt.setString(1, curso.getNome());
			stmt.setLong(2, curso.getIdProfessor());
			stmt.setLong(3, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM Curso WHERE id = ?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Boolean verificarNome(String nome) {
		Curso curso = new Curso();

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT nome FROM Curso WHERE nome = ?");
			ResultSet rsts = stmt.executeQuery();
			while (rsts.next()) {
				curso.setNome(rsts.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (curso.getNome() != null) {
			return true;
		} else {
			return false;
		}
	}
}
