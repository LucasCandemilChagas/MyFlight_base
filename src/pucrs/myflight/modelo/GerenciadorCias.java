package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private static GerenciadorCias instance;

	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}
	
	public void adicionar(CiaAerea cia){
        empresas.add(cia);
    }
	
	public static GerenciadorCias getInstance(){
        if(instance == null){instance = new GerenciadorCias();}
        return instance;
    }

    public String listarTodas(){
        String c = "Todas as Companhias Aereas:\n\n";

        for (CiaAerea ciaAerea : empresas) {c+= ciaAerea.toString();}

        return c;
    }

    public CiaAerea buscarPorCodigo(String cod){
        for(CiaAerea c : empresas){if(c.getCodigo().equals(cod)){return c;}}     
        return null;
    }

	public CiaAerea buscarPorNome(String nom){
        for(CiaAerea c : empresas){if(c.getNome().equals(nom)){return c;}}     
        return null;
    }
}
