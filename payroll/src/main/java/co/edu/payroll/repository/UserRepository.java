package co.edu.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.payroll.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	

}
