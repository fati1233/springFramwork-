package bgn.springframwork.spring5webapp.repositories;

import bgn.springframwork.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
