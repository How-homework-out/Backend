package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "live_room")
@Getter
@Setter
@Entity
public class LiveRoom extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;
    @ManyToOne
    @JoinColumn(name = "rout_id", referencedColumnName = "id")
    private Routine routine;
    private String roomSubject;

    //@OneToMany(mappedBy = "liveRoom", cascade = CascadeType.ALL)
    //private List<Participate> participateList=new ArrayList<>();
}
