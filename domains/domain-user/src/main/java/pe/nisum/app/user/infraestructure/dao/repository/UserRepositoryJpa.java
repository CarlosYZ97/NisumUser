package pe.nisum.app.user.infraestructure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.nisum.app.user.infraestructure.dao.entity.UserEntity;

import java.util.UUID;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

	@Query("select case when count(u)>0 then true else false end from UserEntity u where u.email = :email")
	Boolean existEmail(@Param("email") String email);

}
