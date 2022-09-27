package CityQuestApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="position_name")
    private String name;
    private double latitude;
    private double longitude;
    private double radius;
    @OneToMany(mappedBy = "position")
    private List<Stage> stageList = new ArrayList<>();


}
