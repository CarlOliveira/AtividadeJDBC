package model;

public class Curso {
	private Long id;
	private String nome;
	private Long idProfessor;
	
	public Curso(Long id, String nome, Long idProfessor) {
		super();
		this.id = id;
		this.nome = nome;
		this.idProfessor = idProfessor;
	}

	public Curso(String nome, Long idProfessor) {
		super();
		this.nome = nome;
		this.idProfessor = idProfessor;
	}

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", idProfessor=" + idProfessor + "]";
	}

}
