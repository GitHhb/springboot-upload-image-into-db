package sb.bestpractice.model;

import javax.persistence.Entity;
import javax.persistence.Lob;

import java.awt.image.BufferedImage;
import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Location {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
	@Lob
	private byte[] image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
