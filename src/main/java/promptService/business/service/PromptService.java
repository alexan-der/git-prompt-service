package promptService.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import promptService.api.exception.DateFormatException;
import promptService.api.exception.IdMismatchException;
import promptService.business.entity.Prompt;
import promptService.business.repository.PromptRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PromptService {
    private final PromptRepository promptRepository;

    @Autowired
    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public Prompt getPromptById(String id) throws IdMismatchException {
        try {
            Long ID = Long.parseLong(id);
            return promptRepository.findById(ID).orElseThrow(IdMismatchException::new);
        } catch (NumberFormatException e) {
            throw new IdMismatchException();
        }
    }

    public Prompt getPromptById(Long id) throws IdMismatchException {
        return promptRepository.findById(id).orElseThrow(IdMismatchException::new);
    }

    public List<Prompt> getAllPrompts() {
        return promptRepository.findAllByOrderByTimeDesc();
    }

    public List<Prompt> getPromptsByDateRange(String after, String before) throws DateFormatException {
        try {
            LocalDateTime dateTimeAfter = LocalDate.parse(after).atTime(0,0, 0);
            LocalDateTime dateTimeBefore = LocalDate.parse(before).atTime(23, 59, 59);
            return promptRepository.findByTimeAfterAndTimeBeforeOrderByTimeDesc(dateTimeAfter, dateTimeBefore);
        } catch (Exception e) {
            throw new DateFormatException();
        }
    }

}
