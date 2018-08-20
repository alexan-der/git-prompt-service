package promptService.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import promptService.api.exception.DateFormatException;
import promptService.api.exception.IdMismatchException;
import promptService.business.entity.Prompt;
import promptService.business.service.PromptService;

import java.util.List;

@RestController
public class PromptController {

    @Autowired
    private PromptService promptService;

    @RequestMapping("/prompts")
    @ResponseBody
    public List<Prompt> getAllPrompts() {
        return promptService.getAllPrompts();
    }

    @RequestMapping(value = "/prompts", params = {"id"})
    @ResponseBody
    public Prompt getPromptById(@RequestParam("id") String id) throws IdMismatchException {
        return promptService.getPromptById(id);
    }

    @RequestMapping(value = "/prompts", params = {"after", "before"})
    @ResponseBody
    public List<Prompt> getPromptsByDateRange(@RequestParam("after") String after, @RequestParam("before") String before) throws DateFormatException {
        return promptService.getPromptsByDateRange(after, before);
    }

}
