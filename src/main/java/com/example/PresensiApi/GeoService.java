package com.example.PresensiApi;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

@Service
public class GeoService {
    private final GeometryFactory gf = new GeometryFactory();
    private final Polygon polygon;

    public GeoService() {
        // Koordinat poligon (disesuaikan dari PDF)
        Coordinate[] coords = new Coordinate[] {
            new Coordinate(107.147450, -6.348360),
            new Coordinate(107.148073, -6.347481),
            new Coordinate(107.151397, -6.349692),
            new Coordinate(107.150885, -6.350314), // Titik ke-4 untuk menutup bentuk
            new Coordinate(107.147450, -6.348360)  // Titik awal dan akhir harus sama
        };
        this.polygon = gf.createPolygon(coords);
    }

    public boolean isInside(double lat, double lng) {
        Point point = gf.createPoint(new Coordinate(lng, lat)); // Format: Lng, Lat
        return polygon.covers(point); // Mengecek apakah titik berada di dalam poligon
    }
}