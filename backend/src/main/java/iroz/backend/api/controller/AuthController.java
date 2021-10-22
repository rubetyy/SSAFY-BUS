package iroz.backend.api.controller;

import iroz.backend.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iroz.backend.api.request.UserLoginPostReq;
import iroz.backend.api.response.UserLoginPostRes;
import iroz.backend.common.model.response.BaseResponseBody;
import iroz.backend.common.util.JwtTokenUtil;
import iroz.backend.db.entity.User;
import iroz.backend.db.repository.UserRepositorySupport;

import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * 인증 관련 API 요청 처리를 위한 컨트롤러 정의.
 */

@RestController
@RequestMapping("/api-boot/users")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //로그인 관련 부분
    @PostMapping("/login")
    public ResponseEntity<UserLoginPostRes> login(@RequestBody UserLoginPostReq loginInfo) {
        String id = loginInfo.getId();
        String password = loginInfo.getPassword();

        Optional<User> user = userService.getUserByUserId(id);
        if (user.isEmpty()) {
            return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "invalid Id", null));
        }
//        try{
//            User user = userService.getUserByUserId(id);
//        }
//        catch (NoSuchElementException ex){
//            return ResponseEntity.status(403).body(UserLoginPostRes.of(401, "invalid data",null));
//        }
//        User user = userService.getUserByUserId(id);
        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        // matches - 암호화되지 않은 비밀번호(raw-)와 암호화된 비밀번호(encoded-)가 일치하는지 비교
        if(passwordEncoder.matches(password, user.get().getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
            return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(id)));
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
    }

}
