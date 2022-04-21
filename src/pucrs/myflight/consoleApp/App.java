package pucrs.myflight.consoleApp;

import java.time.LocalDateTime;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;

import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;

import pucrs.myflight.modelo.Rota;

import pucrs.myflight.modelo.VooDireto;
import pucrs.myflight.modelo.VooEscalas;
import pucrs.myflight.modelo.Voo.Status;

public class App {
	public static void main(String[] args) {

		System.out.println("\nMyFlight project...\n");

		Aeronave a1 = new Aeronave("73G", "Boeing 737-700");
		Aeronave a2 = new Aeronave("733", "Boeing 737-300");
		Aeronave a3 = new Aeronave("777", "Boeing 777");

		Geo g1 = new Geo(21.4563, 43.5519);
		Geo g2 = new Geo(23.4306, 46.4730);
		Geo g3 = new Geo(25.7933, 80.2906);
		Geo g4 = new Geo(40.3823, 73.4644);

		Aeroporto aeroporto1 = new Aeroporto("SDU", "Santos-Dummont", g1);
		Aeroporto aeroporto2 = new Aeroporto("GRU", "Guarulhos", g2);
		Aeroporto aeroporto3 = new Aeroporto("MIA", "Miami International Airport", g3);
		Aeroporto aeroporto4 = new Aeroporto("JFK", "Aeroporto Internacional John F. Kennedy", g4);

		CiaAerea cia1 = new CiaAerea("G3", "Gol");
		CiaAerea cia2 = new CiaAerea("JJ", "LATAM Linhas Aereas");

		Rota rota1 = new Rota(cia2, aeroporto1, aeroporto2, a1);
		Rota rota2 = new Rota(cia1, aeroporto3, aeroporto1, a3);
		Rota rota3 = new Rota(cia2, aeroporto2, aeroporto3, a2);
		Rota rota4 = new Rota(cia1, aeroporto3, aeroporto2, a3);
		Rota rota5 = new Rota(cia2, aeroporto3, aeroporto4, a3);

		VooDireto voo1 = new VooDireto(rota1, LocalDateTime.of(2022, 12, 20, 15, 30));
		VooDireto voo2 = new VooDireto(rota3, LocalDateTime.of(2022, 05, 10, 13, 00));
		VooDireto voo3 = new VooDireto(rota2, LocalDateTime.of(2022, 01, 01, 00, 00));
		VooEscalas voo4 = new VooEscalas(LocalDateTime.of(2022, 12, 31, 19, 00));
		voo4.adicionaRota(rota1);
		voo4.adicionaRota(rota3);
		VooEscalas voo5 = new VooEscalas(LocalDateTime.of(2020, 12, 31, 18, 00));
		voo5.adicionaRota(rota1);
		voo5.adicionaRota(rota2);
		voo5.adicionaRota(rota5);

		GerenciadorAeronaves gerAeronaves = GerenciadorAeronaves.getInstance();
		gerAeronaves.adicionar(a1);
		gerAeronaves.adicionar(a2);
		gerAeronaves.adicionar(a3);

		GerenciadorAeroportos gerAeroportos = GerenciadorAeroportos.getInstance();
		gerAeroportos.adicionar(aeroporto1);
		gerAeroportos.adicionar(aeroporto2);
		gerAeroportos.adicionar(aeroporto3);
		gerAeroportos.adicionar(aeroporto4);	

		GerenciadorCias gerCias = GerenciadorCias.getInstance();
		gerCias.adicionar(cia1);
		gerCias.adicionar(cia2);

		GerenciadorRotas gerRotas = GerenciadorRotas.getInstance();
		gerRotas.adicionar(rota1);
		gerRotas.adicionar(rota2);
		gerRotas.adicionar(rota3);
		gerRotas.adicionar(rota4);
		gerRotas.adicionar(rota5);

		GerenciadorVoos gerVoos = GerenciadorVoos.getInstance();
		gerVoos.adicionar(voo1);
		gerVoos.adicionar(voo2);
		gerVoos.adicionar(voo3);
		gerVoos.adicionar(voo4);
		gerVoos.adicionar(voo5);

		voo5.setStatus(Status.ATRASADO);
		voo1.setStatus(Status.CANCELADO);

		System.out.println(gerVoos.listarTodas());
		System.out.println("Voos pesquisados pela data:\n\n"+gerVoos.buscarPorDate(LocalDateTime.of(2022, 12, 20, 15, 30)));
		System.out.println(gerCias.listarTodas());
		System.out.println("Total de Companhias Aereas: "+CiaAerea.getTotalCias());
		System.out.println("Companhia pesquisada por nome: "+gerCias.buscarPorNome("Gol"));
		System.out.println("Companhia pesquisada por codigo: "+gerCias.buscarPorCodigo("JJ"));
		System.out.println(gerAeronaves.listarTodas());
		System.out.println("Aeronave pesquisada pelo codigo: "+gerAeronaves.buscarPorCodigo("777"));
		System.out.println(gerAeroportos.listarTodas());
		System.out.println("Aeroporto pesquisado pelo codigo: "+gerAeroportos.buscarPorCodigo("GRU"));
		System.out.println(gerRotas.listarTodas());
		System.out.println("Rotas pesquisadas pelo aeroporto de origem:\n\n"+gerRotas.buscarPorOrigem(aeroporto2)+"\n");
		
		System.out.println("Distanca do ponto g1 ate o g3:");
		System.out.printf("%.4fkm\n", Geo.distancia(g1, g3));
		System.out.println("Distanca do ponto g4 ate o aeroporto do panama:");
		System.out.printf("%.4fkm\n", g2.distancia(g4));

	}
}
