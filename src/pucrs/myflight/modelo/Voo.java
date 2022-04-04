package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

	private LocalDateTime datahora;
	private DateTimeFormatter formatter;
	private String texto;
	private LocalDateTime parseDateTime;
	private Duration duracao;
	
	private Rota rota;
	private Status status;
	
	private static int numProx = 3000;
	private int numeroVoo;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
		numeroVoo = numProx;
		numProx += 1;
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		texto = datahora.format(formatter);
		parseDateTime = LocalDateTime.parse(texto, formatter);
	}

	public Voo(Rota umaRota, Duration umaDuracao){
		this.rota = umaRota;
		this.duracao = umaDuracao;
		this.datahora = LocalDateTime.of(2016, 8, 12, 12, 00);
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		texto = datahora.format(formatter);
		parseDateTime = LocalDateTime.parse(texto, formatter);
		numeroVoo = numProx;
		numProx += 1;
	}
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}

	public String getDuracaoStr(){
		return duracao.toString().substring(2).replaceAll("HMS", "$1").toLowerCase();
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public String mostrarVoo(){
		return String.format("Voo %d:\n\n %s\n Horario: %s\n Duracao: %s\n Status do Voo: %s\n", 
								numeroVoo, 
								getRota(), 
								parseDateTime.format(formatter), 
								getDuracaoStr(), 
								status);
	}
}
