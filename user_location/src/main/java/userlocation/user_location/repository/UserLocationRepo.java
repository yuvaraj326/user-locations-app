package userlocation.user_location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import userlocation.user_location.dto.UserLocation;

public interface UserLocationRepo extends JpaRepository<UserLocation, Integer>{

}
