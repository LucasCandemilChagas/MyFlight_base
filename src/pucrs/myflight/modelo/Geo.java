package pucrs.myflight.modelo;

public class Geo {
	private double latitude;
	private double longitude;

	private static double d;
	private static int r = 6371;


	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static double distancia(Geo p1, Geo p2) {
		d = haversine(p1, p2);
		return d;
	}

	public static double haversine(Geo p1, Geo p2)
    {
		double l1 = p1.getLatitude();
		double l2 = p2.getLatitude();

		double lo1 = p1.getLongitude();
		double lo2 = p2.getLongitude();
        
		double dLat = (l2 - l1) *
                      Math.PI / 180.0;
        double dLon = (lo2 - lo1) *
                      Math.PI / 180.0;
 
        l1 = Math.toRadians(l1);
        l2 = Math.toRadians(l2);
 
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(l1) * Math.cos(l2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return r * c;
    }

	public double distancia(Geo p) {
		d = haversine(p, new Geo(9.0417, 79.2301));
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
