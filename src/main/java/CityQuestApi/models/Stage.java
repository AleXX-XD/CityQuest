package CityQuestApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "mediumtext")
    private String message;
    @Column(columnDefinition = "text")
    private String answer;
    @Column(columnDefinition = "mediumtext")
    private String help;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @OneToMany(mappedBy = "stage")
    private List<Player> playerList = new ArrayList<>();

}
