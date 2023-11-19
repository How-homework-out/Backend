package inha.how.Service;

import inha.how.Domain.dto.calendar.CalendarInfoMapping;
import inha.how.Domain.entity.User;
import inha.how.Repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public List<CalendarInfoMapping> findCalendar(User user){
        List<CalendarInfoMapping> calendarInfoMappingList = calendarRepository.findCalendarByUser(user);

        return calendarInfoMappingList;
    }

    public void CalendarAdd(){

    }

    //modifyCalendar: 달력 체크 수정

}
