package comp74.sakila.model.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import comp74.sakila.model.entities.Actor;

@CrossOrigin
public interface ActorRepo extends PagingAndSortingRepository<Actor, Long>{
    Actor findByActorId(Long actorId);
}
    