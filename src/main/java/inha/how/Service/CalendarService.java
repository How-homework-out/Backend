package inha.how.Service;

import inha.how.Domain.dto.calendar.CalendarAddRes;
import inha.how.Domain.dto.calendar.CalendarInfoMapping;
import inha.how.Domain.entity.Calendar;
import inha.how.Domain.entity.Routine;
import inha.how.Domain.entity.User;
import inha.how.Repository.CalendarRepository;
import inha.how.Repository.Routine.RoutineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;
    private final RoutineRepository routineRepository;

    public List<CalendarInfoMapping> findCalendar(User user){
        List<CalendarInfoMapping> calendarInfoMappingList = calendarRepository.findCalendarByUser(user);

        return calendarInfoMappingList;
    }

    public void CalendarAdd(User user, CalendarAddRes calendarAddRes){
        Long routId= calendarAddRes.getRoutId();
        LocalDate localDate=calendarAddRes.getLocalDate();
        Boolean check = calendarAddRes.getCheck();

        Routine routine = routineRepository.findRoutineById(routId);

        Calendar calendar=new Calendar();
        calendar.setUser(user);
        calendar.setDate(localDate);
        calendar.setCheck(check);
        calendar.setRoutine(routine);

        calendarRepository.save(calendar);
    }

    //modifyCalendar: 달력 체크 수정

}
