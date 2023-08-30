package userlocation.user_location.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
    private Double latitude;
    private Double longitude;
    private Boolean excluded;
    private Double distance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Boolean getExcluded() {
		return excluded;
	}
	public void setExcluded(Boolean excluded) {
		this.excluded = excluded;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
    
    
	

}
