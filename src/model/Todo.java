package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="Todos")
@Table(name="Todos")
public class Todo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_todo")
	private Integer id_todo;
		
	@Column(name="description")
	private String description;
	
	public Todo () {
		
	}

	public Integer getId_todo() {
		return id_todo;
	}

	public void setId_todo(Integer id_todo) {
		this.id_todo = id_todo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
	
	
	