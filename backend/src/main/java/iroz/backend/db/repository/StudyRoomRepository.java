package iroz.backend.db.repository;

import iroz.backend.db.entity.StudyRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long> {
    @Query(value = "SELECT *,HOUR(reservation) as hour ,COUNT(*) as count ,room FROM study_room WHERE YEAR(reservation)=:year AND MONTH(reservation)=:month AND DAY(reservation)=:day AND HOUR(reservation)=:hour AND room=:room group by hour(reservation)",nativeQuery = true)
    List<StudyRoom> getListGroupBy(@Param("year") int year , @Param("month") int month, @Param("day") int day, @Param("hour") int hour ,@Param("room") int room);
}

