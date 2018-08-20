package promptService.business.repository;

import org.springframework.data.repository.CrudRepository;
import promptService.business.entity.Prompt;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PromptRepository extends CrudRepository<Prompt, Long> {

    Optional<Prompt> findById(Long id);

    List<Prompt> findAllByOrderByTimeDesc();

    List<Prompt> findByTimeAfterAndTimeBeforeOrderByTimeDesc(Date after, Date before);

}
