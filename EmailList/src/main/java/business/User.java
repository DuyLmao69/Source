package business;

import java.util.Date;

public class User {

	private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String date;
    private String heardFrom;
    private String wantsUpdates;
    private String contactVia;
	
	public User() {
		// TODO Auto-generated constructor stub
		firstName = "";
		lastName = "";
		email = "";
		date="";
		heardFrom="";
		wantsUpdates="";
		contactVia="";
	}
	public User(String firstName,String lastName,String email,String date,String heardFrom,String wantsUpdates,String contactVia) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.date=date;
		this.heardFrom=heardFrom;
		this.contactVia=contactVia;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
    public String getHeardFrom() {
        return heardFrom;
    }

    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }
    public String getDate() {
        return date;
    }

    public void getDate(String date) {
        this.date = date;
    }
    

    public String getWantsUpdates() {
        return wantsUpdates;
    }

    public void setWantsUpdates(String wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }

    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    } 
}
