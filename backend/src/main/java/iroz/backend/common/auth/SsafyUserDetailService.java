package iroz.backend.common.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import iroz.backend.api.service.UserService;
import iroz.backend.db.entity.User;
import iroz.backend.db.repository.UserRepository;


/**
 * 현재 액세스 토큰으로 부터 인증된 유저의 상세정보(활성화 여부, 만료, 롤 등) 관련 서비스 정의.
 */
@Component
public class SsafyUserDetailService implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.getUserByUserId(username);
        if(user != null) {
            SsafyUserDetails userDetails = new SsafyUserDetails(user.get());
            return userDetails;
        }
        return null;
    }
}