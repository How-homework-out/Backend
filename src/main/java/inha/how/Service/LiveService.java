package inha.how.Service;

import inha.how.Domain.dto.live.liveAddRes;
import inha.how.Domain.dto.live.liveList;
import inha.how.Domain.dto.live.liveListRes;
import inha.how.Domain.entity.*;
import inha.how.Domain.entity.Identify.ParticipateId;
import inha.how.Repository.Live.LiveRepository;
import inha.how.Repository.Live.LiveRoutine;
import inha.how.Repository.Live.ParticipateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LiveService {

    private final LiveRepository liveRepository;
    private final ParticipateRepository participateRepository;
    private final RoutineService routineService;
    private final LiveRoutine liveRoutine;

    public liveListRes findLive(){
        List<LiveRoom> liveRoomList = liveRepository.findAll();
        List<liveList> liveLists = new ArrayList<>();

        liveRoomList.forEach((live)-> {
            liveLists.add(new liveList(live.getId(), live.getRoomSubject(), live.getCreator().getNick(), live.getRoutine().getId()));
        });

        return new liveListRes(liveLists);
    }

    //addLive: LiveRepository의 save 함수를 이용해 라이브 방을 등록한다.
    public liveAddRes addLive(User user, String subject, Long routId){
        Routine routine= routineService.findRoutineById(routId);
        LiveRoom liveRoom=new LiveRoom();
        liveRoom.setCreator(user);
        liveRoom.setRoomSubject(subject);
        liveRoom.setRoutine(routine);
        liveRepository.save(liveRoom);

        Participate participate=new Participate();
        ParticipateId participateId=new ParticipateId();

        participateId.setParticipate(user);
        participateId.setLiveRoom(liveRoom);
        participate.setParticipateId(participateId);
        participate.setAccess(Access.owner);

        participateRepository.save(participate);
        // live방 운동 루틴 로컬 저장
        liveRoutine.save(liveRoom.getId(), routineService.findRoutineOne(routId));

        return new liveAddRes(liveRoom.getId());
    }
    //findLiveSearch(search):LiveRepository의 findBySubjectContainingOrNickContaining 함수를 이용해 제목이나 생성자 닉네임 중 search 단어가 포함된 라이브 방 정보를 조회하고 반환한다.
    //deleteLive(roomId):라이브 종료 후 운동 루틴 달력에 추가
    public void deleteLive(Long roomId){
        liveRepository.deleteById(roomId);
    }
}
