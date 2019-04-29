package br.com.youthquake.exampleTxt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_goal")
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_goal")
	private int idGoal;
	
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dt_start")
	private String dtStart;
	
	@Column(name = "dt_end")
	private String dtEnd;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "value_accumulated")
	private int valueAccumulated;
	
	@Column(name = "percentage")
	private int percentage;
	
	//Constructors
	public Goal() {
		
	}
	
	

	public Goal(int idGoal, String name, String description, String dtStart, String dtEnd, int value,
			int valueAccumulated, int percentage) {
		super();
		this.idGoal = idGoal;
		this.name = name;
		this.description = description;
		this.dtStart = dtStart;
		this.dtEnd = dtEnd;
		this.value = value;
		this.valueAccumulated = valueAccumulated;
		this.percentage = percentage;
	}



	//Getters and Setters
	public int getIdGoal() {
		return idGoal;
	}

	public void setIdGoal(int idGoal) {
		this.idGoal = idGoal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtStart() {
		return dtStart;
	}

	public void setDtStart(String dtStart) {
		this.dtStart = dtStart;
	}

	public String getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValueAccumulated() {
		return valueAccumulated;
	}

	public void setValueAccumulated(int valueAccumulated) {
		this.valueAccumulated = valueAccumulated;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	
}