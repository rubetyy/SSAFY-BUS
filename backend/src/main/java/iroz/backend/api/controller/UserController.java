package iroz.backend.api.controller;

import iroz.backend.api.request.UserRegisterPostReq;
import iroz.backend.api.service.UserService;
import iroz.backend.common.model.response.BaseResponseBody;
import iroz.backend.db.entity.User;
import iroz.backend.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@RestController
@RequestMapping("/api-boot/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody UserRegisterPostReq registerInfo) {

        if (userRepository.findByUserId(registerInfo.getUserId()).isPresent()) {
            // 같은 id의 회원이 이미 존재하는 경우
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "already exist"));
        }

        if (registerInfo.getUserId().equals("") || registerInfo.getPassword().equals("") || registerInfo.getNickname().equals("")) {
            // 데이터 유효성검사 (수정해야함함)
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "invalidate data"));
        }

        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        User user = userService.createUser(registerInfo);

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "true"));
    }
}