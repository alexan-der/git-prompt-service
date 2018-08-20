package promptService.api.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import promptService.api.exception.IdMismatchException;
import promptService.api.soap.schema.GetPromptRequest;
import promptService.api.soap.schema.GetPromptResponse;
import promptService.business.service.PromptService;

@Endpoint
public class PromptEndpoint {

    @Autowired
    private PromptService promptService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE, localPart = "getPromptRequest")
    @ResponsePayload
    public GetPromptResponse getPrompts(@RequestPayload GetPromptRequest request) throws IdMismatchException {
        GetPromptResponse response = new GetPromptResponse();
        if (request.getId().equals("all") || request.getId().equals(""))
            response.setPrompts(promptService.getAllPrompts());
        else
            response.addPrompt(promptService.getPromptById(request.getId()));

        return response;
    }
}
