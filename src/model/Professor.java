package model;

public class Professor {
	private Long id;
	private String nome;
	private int idade;

	public Professor(Long id, String nome, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Professor(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}

}
