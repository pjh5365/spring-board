package pjh5365.springboard.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pjh5365.springboard.entity.UserAccount;
import pjh5365.springboard.repository.UserAccountRepository;

/**
 * @author : parkjihyeok
 * @since : 2024/04/20
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserAccountRepository userAccountRepository;

	public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount userAccount = userAccountRepository.findByUserId(username).orElseThrow(() -> {
			return new UsernameNotFoundException("회원정보를 찾을 수 없습니다.");
		});

		return new CustomUserDetails(userAccount);
	}
}
