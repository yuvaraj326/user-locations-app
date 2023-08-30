package userlocation.user_location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import userlocation.user_location.dao.UserLocationDao;
import userlocation.user_location.dto.UserLocation;

@RestController

public class UserLocationConttroller {
	
	@Autowired
	UserLocationDao dao;
	
	
	
	
	@PostMapping("save")
	public UserLocation save(@RequestBody UserLocation location) {
		return dao.save(location);
	}
	
	@GetMapping("getbyid/{id}")
	public UserLocation getbyid(@PathVariable int id) {
		return dao.getById(id);
	} 

	@DeleteMapping("delete/{id}")
	public UserLocation deletebyid(@PathVariable int id,UserLocation location) {
		return dao.delete(id, location);
	}
	
	@PutMapping("update/{id}")
	public UserLocation updatebyid(@PathVariable int id,@RequestBody UserLocation location ) {
		return dao.update(location, id);
	}
	
	
	@GetMapping("getuser/{count}")
		public List<UserLocation> getuser(@PathVariable Integer count){
		
		List<UserLocation> alluser =dao.getall(count);
		List<UserLocation> nearestUsers = dao.getNearestUsers(alluser, count);
        return nearestUsers;
			
		}
	}
	














