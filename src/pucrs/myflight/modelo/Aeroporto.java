package pucrs.myflight.modelo;

public class Aeroporto {
	private String codigo;
	private String nome;
	private Geo loc;
	
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Geo getLocal() {
		return loc;
	}
	public String toString(){
		return String.format("Aeroporto: %s, %s, %s\n", getNome(), getCodigo(), getLocal());
	}

    public int compareTo(Aeroporto orig) {
        return 0;
    }
}
