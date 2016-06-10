package assignment;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;


public class PlaceMarker extends CommonMarker {
	public PlaceMarker(Feature place) {
		super(((PointFeature)place).getLocation(), place.getProperties());
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(255,0,0);
		pg.ellipse(x, y, 5, 5);
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		
		// show routes
		
		
	}
	
}
