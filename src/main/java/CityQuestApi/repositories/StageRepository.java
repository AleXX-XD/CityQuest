package CityQuestApi.repositories;

import CityQuestApi.models.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends CrudRepository<Stage, Integer> {
}
