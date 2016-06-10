package assignment;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;


public class PlaceMarker extends CommonMarker {
	public PlaceMarker(Feature place) {
		super(((PointFeature)place).getLocation(), place.getProperties());
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(255,0,0);
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		String placeName = getPlaceName();
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(placeName) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(placeName, x + 3 , y +18);
		
		
		pg.popStyle();
		
		
	}
	
	public String getPlaceName(){
		return (String) getProperty("place");
	}
	
}
