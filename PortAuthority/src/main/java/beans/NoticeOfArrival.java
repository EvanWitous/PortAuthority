package beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

// For JPA persistency
// @Entity
// @Table(name="NoticeOfArrival")
public class NoticeOfArrival implements Serializable {

	private static final long serialVersionUID = 1L;

	// Uncomment if you want to use this bean as a transport object for JPA (from PortAuthority component)
	// The extra annotations allow for using an auto-increment key in MySQL (see description of NoticeOfArrival table)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String name;

	private int nmsi;

	private int client;

	public NoticeOfArrival(int nmsi, int client, String name) {
		this.nmsi = nmsi;
		this.client = client;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public int getNmsi() {
		return nmsi;
	}

	public int getClient() {
		return client;
	}
}
