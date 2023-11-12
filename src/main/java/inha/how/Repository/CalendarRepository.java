package inha.how.Repository;

import inha.how.Domain.dto.calendar.CalendarInfoMapping;
import inha.how.Domain.entity.Calendar;
import inha.how.Domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<CalendarInfoMapping> findCalendarByUser(User user);
}
