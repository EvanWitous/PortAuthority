package beans;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.persistence.*;
import java.io.Serializable;
import java.io.StringWriter;

// For JPA persistence
@Entity
@Table(name = "NoticeOfArrival")
public class NoticeOfArrival implements Serializable {

    private static final long serialVersionUID = 1L;

    // Uncomment if you want to use this bean as a transport object for JPA (from PortAuthority component)
    // The extra annotations allow for using an auto-increment key in MySQL (see description of NoticeOfArrival table)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private int mmsi;
    private int client;

    public NoticeOfArrival() {
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toJsonString() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(this.toJsonObject());
        jsonWriter.close();
        return stringWriter.toString();
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder().add("name", this.name).add("mmsi", this.mmsi).add("client", this.client).build();
    }

}
