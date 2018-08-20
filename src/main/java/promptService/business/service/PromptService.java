package promptService.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import promptService.api.exception.DateFormatException;
import promptService.api.exception.IdMismatchException;
import promptService.business.entity.Prompt;
import promptService.business.repository.PromptRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");

        try {
            Date dateAfter = dateFormat.parse(after + " 00:00:00");
            Date dateBefore = dateFormat.parse(before + " 23:59:59");
            return promptRepository.findByTimeAfterAndTimeBeforeOrderByTimeDesc(dateAfter, dateBefore);
        } catch (ParseException e) {
            throw new DateFormatException();
        }
    }

}
