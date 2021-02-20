package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,
  desc VARCHAR(100) NOT NULL, 
  date VARCHAR(30) NOT NULL,
  estimateTime VARCHAR(30) NOT NULL,    
  PRIMARY KEY (id));
 */

@Entity
@Table(name = "MemoData")
public class data {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memoID")
	private Integer id;
	
	@Column(name = "memoName")
	private String memoName;
	
	@Column(name = "memoDesc")
	private String memoDesc;
	
	@Column(name = "memoDate")
	private String memoDate;
	
	@Column(name = "memoTime")
	private String memoTime;
	
	public data() {
		
	}
	
	public data(int id, String name, String desc, String date, String time) {
		this.id = id;
		this.memoName = name;
		this.memoDesc = desc;
		this.memoDate = date;
		this.memoTime = time;
	}
	public data(String name, String desc, String date, String time) {
		this.memoName = name;
		this.memoDesc = desc;
		this.memoDate = date;
		this.memoTime = time;
	}
	
	public int getId() {
		return id;
	}

	public String getMemoName() {
		return memoName;
	}

	public void setMemoName(String memoName) {
		this.memoName = memoName;
	}

	public String getMemoDesc() {
		return memoDesc;
	}

	public void setMemoDesc(String memoDesc) {
		this.memoDesc = memoDesc;
	}

	public String getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(String memoDate) {
		this.memoDate = memoDate;
	}

	public String getMemoTime() {
		return memoTime;
	}

	public void setMemoTime(String memoTime) {
		this.memoTime = memoTime;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s \nDescription: %s\nEstimate Data of Completion: %s\n Estimated Time Consumption: %s\n", id,memoName,memoDesc,memoDate,memoTime);
	}
	
}
