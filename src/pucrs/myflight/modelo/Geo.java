package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;

	private static double i;
	private static double d;
	private static int r = 6371;

	private static double latDistancia;
	private static double longDistancia;

	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static double distancia(Geo p1, Geo p2) {
		latDistancia = Math.toRadians(p1.getLatitude() - p2.getLatitude());
		longDistancia = Math.toRadians(p1.getLongitude() - p2.getLongitude());

		i = Math.pow(Math.sin(latDistancia / 2), 2) + Math.cos(p1.getLatitude()) + Math.cos(p2.getLatitude())
				+ Math.pow(Math.sin(longDistancia / 2), 2);
		d = 2 * r * Math.asin(Math.sqrt(i));

		return d;
	}

	public double distancia(Geo p) {
		Geo g = new Geo(-48.5124, -2.2103);

		latDistancia = Math.toRadians(p.getLatitude() - g.getLatitude());
		longDistancia = Math.toRadians(p.getLongitude() - g.getLongitude());

		i = Math.pow(Math.sin(latDistancia / 2), 2) + Math.cos(p.getLatitude()) + Math.cos(g.getLatitude())
				+ Math.pow(Math.sin(longDistancia / 2), 2);
		d = 2 * r * Math.asin(Math.sqrt(i));

		return d;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String toString() {
		return String.format("Coordenadas: Lat - %.4f, Long - %.4f\n", getLatitude(), getLongitude());
	}
}
