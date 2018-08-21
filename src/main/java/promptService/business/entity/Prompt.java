package promptService.business.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prompt", propOrder = {"id", "text", "time"})
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @XmlElement(required = true)
    @Getter @Setter
    private String text;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    @Getter @Setter
    private LocalDateTime time;

    public Prompt() {}

    public Prompt(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

}
