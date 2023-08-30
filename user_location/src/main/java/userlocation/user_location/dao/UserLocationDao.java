package userlocation.user_location.dao;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import userlocation.user_location.dto.UserLocation;
import userlocation.user_location.repository.UserLocationRepo;

@Repository
public class UserLocationDao {

	@Autowired
	UserLocationRepo repo;
	
	//save
	public UserLocation save(UserLocation location) {
		return repo.save(location);
	}
	
	
	//getbyid
	public UserLocation getById(int id){
		return repo.findById(id).get();
	}
	
	//update
	public UserLocation update(UserLocation location,int id) {
		UserLocation a=repo.findById(id).get();
		if (a!=null) {
			
			location.setId(id);
			return repo.save(location);
		}else {
			return null;
		}	
	}
	
	//deletebyid
	public UserLocation delete(int id,UserLocation location) {
		repo.deleteById(id);
		return location;
	}
	
	//getall
	public List<UserLocation> getall(int id){
		return repo.findAll();
	}


	public List<UserLocation> getNearestUsers(List<UserLocation> allUsers, int count) {
        List<UserLocation> nearestUsers = new ArrayList<>(allUsers);

        // Calculate distances using Haversine formula
        nearestUsers.forEach(user -> {
            double distance = calculateDistance(user.getLatitude(), user.getLongitude());
            user.setDistance(distance);
        });


        // Sort by distance
        nearestUsers.sort(Comparator.comparingDouble(UserLocation::getDistance));

        // Limit to the first 'count' users
        return nearestUsers.subList(0, Math.min(count, nearestUsers.size()));
    }


	private double calculateDistance(double latitude, double longitude) {
	    final double EARTH_RADIUS = 6371; // Earth's radius in kilometers

	    double lat1 = Math.toRadians(latitude);
	    double lon1 = Math.toRadians(longitude);

	    double lat2 = Math.toRadians(0); // Latitude of point (0, 0)
	    double lon2 = Math.toRadians(0); // Longitude of point (0, 0)

	    double dlat = lat2 - lat1;
	    double dlon = lon2 - lon1;

	    double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return EARTH_RADIUS * c; // Distance in kilometers
	}

}














