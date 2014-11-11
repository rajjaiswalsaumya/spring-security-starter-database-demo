package org.cdac.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities")
public class Role {
	/************************* Data Members *************************/
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "roleid")
	private Long id;

	@Column(name = "role")
	private final String role;

	/********************** Getters and Setters **********************/

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	/************************** Constructors ************************/

	public Role() {
		this("ROLE_USER");
	}

	public Role(final String role) {
		this.role = role;
	}

	/********************* Equals and HashCode **********************/

	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		result = prime * result
				+ (this.role == null ? 0 : this.role.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		final Role other = (Role) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		if (this.role == null) {
			if (other.role != null)
				return false;
		} else if (!this.role.equals(other.role))
			return false;
		return true;
	}

	/*************************** ToString ***************************/

	@Override
	public String toString() {
		return "Role [id=" + this.id + ", role=" + this.role + "]";
	}

}
