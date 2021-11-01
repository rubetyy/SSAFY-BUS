package iroz.backend.api.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import iroz.backend.api.request.ShareRegisterPostReq;
import iroz.backend.db.entity.Share;
import iroz.backend.db.entity.User;
import iroz.backend.db.entity.UserShare;
import iroz.backend.db.entity.UserStudyRoom;
import iroz.backend.db.repository.ShareRepository;
import iroz.backend.db.repository.UserRepository;
import iroz.backend.db.repository.UserShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class ShareService {
    private final UploadService s3Service;
    @Autowired
    ShareRepository shareRepository;

    @Autowired
    UserShareRepository userShareRepository;

    @Autowired
    UserRepository userRepository;

    public String uploadImage(MultipartFile file, ShareRegisterPostReq shareRegisterPostReq, User user) {
        String fileName = createFileName(file.getOriginalFilename());
        System.out.println(fileName);
        //aws input
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        try (InputStream inputStream = file.getInputStream()) {
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
            //db 넣기
            Share share = Share.builder().title(shareRegisterPostReq.getTitle()).user(user).path(s3Service.getFileUrl(fileName)).build();
            shareRepository.save(share);
            List list = shareRegisterPostReq.getUserid();

            for (int i = 0; i < list.size(); i++) {
                Optional<User> byUserId = userRepository.findByUserId(list.get(i).toString());
                UserShare userShare = UserShare.builder().user(byUserId.get()).share(share).build();
                userShareRepository.save(userShare);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다 (%s)", file.getOriginalFilename()));
        }
        return "success";
    }

    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String filename) {
        try {
            return filename.substring(filename.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다.", filename));
        }
    }
}
