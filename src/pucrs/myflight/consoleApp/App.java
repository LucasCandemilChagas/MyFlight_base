package pucrs.myflight.consoleApp;

import java.time.Duration;
import java.time.LocalDateTime;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.Voo.Status;

public class App {
	public static void main(String[] args) {

		System.out.println("\nMyFlight project...");

		Aeronave a1 = new Aeronave("73G", "Boeing 737-700");
		Aeronave a2 = new Aeronave("733", "Boeing 737-300");
		Aeronave a3 = new Aeronave("777", "Boeing 777");

		Geo g1 = new Geo(21.4563, 43.5519);
		Geo g2 = new Geo(23.4306, 46.4730);
		Geo g3 = new Geo(25.7933, 80.2906);

		Aeroporto aeroporto1 = new Aeroporto("SDU", "Santos-Dummont", g1);
		Aeroporto aeroporto2 = new Aeroporto("GRU", "Guarulhos", g2);
		Aeroporto aeroporto3 = new Aeroporto("MIA", "Miami International Airport", g3);

		CiaAerea cia1 = new CiaAerea("G3", "Gol");

		Rota rota1 = new Rota(cia1, aeroporto1, aeroporto2, a1);
		Rota rota2 = new Rota(cia1, aeroporto3, aeroporto1, a3);
		Rota rota3 = new Rota(cia1, aeroporto2, aeroporto3, a2);
		Rota rota4 = new Rota(cia1, aeroporto3, aeroporto2, a3);

		Voo voo1 = new Voo(rota1, LocalDateTime.of(2022, 12, 20, 15, 30), Duration.ofMinutes(120));
		Voo voo2 = new Voo(rota3, LocalDateTime.of(2022, 05, 10, 13, 00), Duration.ofMinutes(280));
		Voo voo3 = new Voo(rota2, LocalDateTime.of(2022, 01, 01, 00, 00), Duration.ofMinutes(200));
		Voo voo4 = new Voo(rota4, Duration.ofMinutes(200));

		voo1.setStatus(Status.CANCELADO);
		voo3.setStatus(Status.ATRASADO);

		System.out.println(voo1.mostrarVoo());
		System.out.println("-------------------------------------------------\n");
		System.out.println(voo2.mostrarVoo());
		System.out.println("-------------------------------------------------\n");
		System.out.println(voo3.mostrarVoo());
		System.out.println("-------------------------------------------------\n");
		System.out.println(voo4.mostrarVoo());
		System.out.println("-------------------------------------------------\n");

		System.out.printf("%.4fkm\n", Geo.distancia(g1, g3));
		System.out.printf("%.4fkm\n", g1.distancia(g2));

	}
}
