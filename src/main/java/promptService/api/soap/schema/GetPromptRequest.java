package promptService.api.soap.schema;

import promptService.api.soap.WebServiceConfig;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = WebServiceConfig.NAMESPACE, name = "", propOrder = {"id"})
@XmlRootElement(namespace = WebServiceConfig.NAMESPACE, name = "getPromptRequest")
public class GetPromptRequest {

    @XmlElement(namespace = WebServiceConfig.NAMESPACE, name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
