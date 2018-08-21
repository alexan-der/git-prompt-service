package promptService.business.repository;

import org.springframework.data.repository.CrudRepository;
import promptService.business.entity.Prompt;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromptRepository extends CrudRepository<Prompt, Long> {

    Optional<Prompt> findById(Long id);

    List<Prompt> findAllByOrderByTimeDesc();

    List<Prompt> findByTimeAfterAndTimeBeforeOrderByTimeDesc(LocalDateTime after, LocalDateTime before);

}
