package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmailVerificationCode;

public interface EmailVerificationDao extends JpaRepository<EmailVerificationCode, Integer> {
	
	List<EmailVerificationCode> findByUserId(Integer userId);
}
