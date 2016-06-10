package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import processing.data.JSONArray;
import processing.data.JSONObject;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class VisitedPlace extends PApplet {
	
	UnfoldingMap map;
	List<Marker> placeMarkers;
	JSONArray values;
	
	public void setup(){
		size(800,600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 750, 550, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		values = loadJSONArray("visited-places.json");
		List<PointFeature> features = new ArrayList<PointFeature>();
		List<Marker> placeMarkers = new ArrayList<Marker>();
		HashMap<Integer, Location> places = new HashMap<Integer, Location>();
		
		for(int i=0; i<values.size(); i++){
			JSONObject p = values.getJSONObject(i);
			JSONArray coordinates = p.getJSONArray("coordinates");
			
			Location loc = new Location(coordinates.getFloat(0), coordinates.getFloat(1));
			PointFeature point = new PointFeature(loc); 
			
			point.setId(p.getString("id"));
			point.addProperty("district", p.getString("district"));
			point.putProperty("place", p.getString("place"));
			features.add(point);
		}
		
		for(PointFeature feature : features){
			PlaceMarker m = new PlaceMarker(feature);
			m.setRadius(5);
			placeMarkers.add(m);
			
			places.put(Integer.parseInt(feature.getId()), feature.getLocation());
		}
		
		map.addMarkers(placeMarkers);
	}
	
	public void draw(){
		map.draw();
	}

}
