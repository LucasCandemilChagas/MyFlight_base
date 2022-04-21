package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
    private static GerenciadorRotas instance;

    private ArrayList<Rota> rotas;   
    
    private GerenciadorRotas(){
        rotas = new ArrayList<>();
    }

    public static GerenciadorRotas getInstance(){
        if(instance == null){instance = new GerenciadorRotas();}
        return instance;
    }

    public void adicionar(Rota r){
        rotas.add(r);
    }

    public String listarTodas(){
        String rot = "Todas as Rotas:\n\n";
        int n = 1;

        for (Rota rota : rotas) {rot+= n++ +")"+rota.toString();}

        rot+= "\n";
        
        return rot;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto orig){
        ArrayList<Rota> lista = new ArrayList<>();
        for(Rota r : rotas){if(r.getOrigem().compareTo(orig) == 0){lista.add(r);}}     
        return lista;
    }

}
