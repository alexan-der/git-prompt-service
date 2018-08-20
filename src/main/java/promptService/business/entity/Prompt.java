package promptService.business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prompt", propOrder = {"id", "text", "time"})
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlElement(required = true)
    private String text;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    private Date time;

    public Prompt() {}

    public Prompt(String text, Date time) {
        this.text = text;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
