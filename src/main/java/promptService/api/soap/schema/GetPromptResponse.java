package promptService.api.soap.schema;

import promptService.api.soap.WebServiceConfig;
import promptService.business.entity.Prompt;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = WebServiceConfig.NAMESPACE, name = "", propOrder = {"prompts"})
@XmlRootElement(namespace = WebServiceConfig.NAMESPACE, name = "getPromptResponse")
public class GetPromptResponse {

    @XmlElement(namespace = WebServiceConfig.NAMESPACE, name = "prompt", required = true)
    private List<Prompt> prompts = new ArrayList<>();

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }

    public void addPrompt(Prompt value) {
        this.prompts.add(value);
    }

    public void removePrompt(Prompt value) {
        this.prompts.remove(value);
    }

}
