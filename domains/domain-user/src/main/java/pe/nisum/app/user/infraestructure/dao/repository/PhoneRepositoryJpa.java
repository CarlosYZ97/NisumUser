package pe.nisum.app.user.infraestructure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.nisum.app.user.infraestructure.dao.entity.PhoneEntity;

public interface PhoneRepositoryJpa extends JpaRepository<PhoneEntity, Integer> {
}
