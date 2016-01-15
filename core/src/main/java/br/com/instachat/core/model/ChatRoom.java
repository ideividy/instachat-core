package br.com.instachat.core.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * POJO Class that represents a chat room in the canvas
 */
@Entity
public class ChatRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "chatroom_user", joinColumns = {
			@JoinColumn(name = "chatroom_id") }, inverseJoinColumns = @JoinColumn(name = "user_id") )
	private Set<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
