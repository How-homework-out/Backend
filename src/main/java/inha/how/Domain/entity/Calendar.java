package inha.how.Domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class Calendar extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "rout_id", referencedColumnName = "id")
    private Routine routine;
    private LocalDate date;
    @Column(name="chk")
    private Boolean check;


    public void setUser(User user){
        this.user=user;
    }
    public void setRoutine(Routine routine){
        this.routine=routine;
    }
    public void setDate(LocalDate localDate){
        this.date=localDate;
    }
    public void setCheck(boolean check){
        this.check=check;
    }
}
