package main;

import java.sql.SQLException;

import dao.CursoDAO;
import dao.ProfessorDAO;
import model.Curso;
import model.Professor;
import util.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws SQLException {
		 
		Professor professor = new Professor("Professor02", 38);
		ProfessorDAO professorDAO = new ProfessorDAO(ConnectionFactory.getInstance().getConnection());
		
		Curso curso = new Curso("Java", 1L);
		CursoDAO cursoDAO = new CursoDAO(ConnectionFactory.getInstance().getConnection());
		
		professorDAO.insert(professor);
		cursoDAO.insert(curso);
		
	}
}
