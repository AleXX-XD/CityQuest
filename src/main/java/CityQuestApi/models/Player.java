package CityQuestApi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="chat_id")
    private String chatId;
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Stage stage;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
}
