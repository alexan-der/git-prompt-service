package promptService.api.soap.schema;

import lombok.Getter;
import lombok.Setter;
import promptService.api.soap.WebServiceConfig;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = WebServiceConfig.NAMESPACE, name = "", propOrder = {"id"})
@XmlRootElement(namespace = WebServiceConfig.NAMESPACE, name = "getPromptRequest")
public class GetPromptRequest {

    @XmlElement(namespace = WebServiceConfig.NAMESPACE, name = "id")
    @Getter @Setter
    private String id;

}
