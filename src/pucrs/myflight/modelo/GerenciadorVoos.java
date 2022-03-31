package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private static GerenciadorVoos instance;

    private ArrayList<Voo> voos;   
    
    private GerenciadorVoos(){
        voos = new ArrayList<>();
    }

    public static GerenciadorVoos getInstance(){
        if(instance == null){instance = new GerenciadorVoos();}
        return instance;
    }

    public void adicionar(Voo r){
        voos.add(r);
    }

    public ArrayList<Voo> listarTodas(){
        return voos;
    }

    public ArrayList<Voo> buscarPorDate(LocalDateTime date){
        ArrayList<Voo> lista = new ArrayList<>();
        for(Voo v : voos){if(v.getDatahora().compareTo(date) == 0){lista.add(v);}}     
        return lista;
    }
}
