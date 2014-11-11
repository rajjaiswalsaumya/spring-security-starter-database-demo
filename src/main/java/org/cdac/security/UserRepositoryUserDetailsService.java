//package org.cdac.security;
//
//import java.util.Collection;
//
//import org.cdac.models.User;
//import org.cdac.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserRepositoryUserDetailsService implements UserDetailsService {
//	private final UserRepository userRepository;
//
//	@Autowired
//	public UserRepositoryUserDetailsService(final UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(final String username)
//			throws UsernameNotFoundException {
//		final User user = this.userRepository.findByEmail(username);
//		if (user == null)
//			throw new UsernameNotFoundException("Could not find user "
//					+ username);
//		return new UserRepositoryUserDetails(user);
//	}
//
//	private final static class UserRepositoryUserDetails extends User implements
//			UserDetails {
//
//		private UserRepositoryUserDetails(final User user) {
//			super(user);
//		}
//
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			return AuthorityUtils
//					.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
//		}
//
//		@Override
//		public String getUsername() {
//			return this.getEmail();
//		}
//
//		@Override
//		public boolean isAccountNonExpired() {
//			return true;
//		}
//
//		@Override
//		public boolean isAccountNonLocked() {
//			return true;
//		}
//
//		@Override
//		public boolean isCredentialsNonExpired() {
//			return true;
//		}
//
//		@Override
//		public boolean isEnabled() {
//			return true;
//		}
//
//		private static final long serialVersionUID = 5639683223516504866L;
//	}
// }
