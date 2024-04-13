package pjh5365.springboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pjh5365.springboard.entity.UserAccount;

/**
 * 회원 Repository
 *
 * @author : parkjihyeok
 * @since : 2024/04/13
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

	Optional<UserAccount> findByUserId(String userId);
}
