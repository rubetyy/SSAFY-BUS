package iroz.backend.db.Mapping;

import java.time.LocalDateTime;

public interface HelpAllMapping {
    String getTitle();
    UserInfoMapping getUser();
    String getContent();
    LocalDateTime getCreatedAt();
}
