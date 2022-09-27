package CityQuestApi.service;

import CityQuestApi.models.Position;
import CityQuestApi.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPositions() {
        Iterable<Position> positions = positionRepository.findAll();
        List<Position> positionList = new ArrayList<>();
        positions.forEach(positionList::add);
        return positionList;
    }
}
