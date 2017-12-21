package pl.mwojcik.domain.model.pin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRepository extends CrudRepository<Pin, Long> {

}
