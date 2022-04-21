package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
public abstract class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };



	public Voo(LocalDateTime datahora){}
	
	public abstract Rota getRota();
	
	public abstract LocalDateTime getDatahora();

	public abstract Duration getDuration();



}
