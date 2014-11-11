/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cdac.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	/************************* Data Members *************************/

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "userid")
	private Long id;

	@NotEmpty(message = "First name is required.")
	@Column(name = "firstname")
	private String firstName;

	@NotEmpty(message = "Last name is required.")
	@Column(name = "lastname")
	private String lastName;

	@Email(message = "Please provide a valid email address.")
	@NotEmpty(message = "Email is required.")
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@NotEmpty(message = "Username is required.")
	@Column(name = "username")
	private String username;

	@NotEmpty(message = "Password is required.")
	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private Boolean isActive;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Role.class)
	@JoinColumn(name = "roleid")
	private List<Role> role;

	/************************** Constructors ************************/
	public User() {
		super();
	}

	public User(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

	public User(final User user) {
		this(user.id, user.firstName, user.lastName, user.email, user.username,
				user.password, user.role);
	}

	public User(final Long id, final String firstName, final String lastName,
			final String email, final String username, final String password,
			final List<Role> role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/********************** Getters and Setters **********************/
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(final Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Role> getRole() {
		return this.role;
	}

	public void setRole(final List<Role> role) {
		this.role = role;
	}

	/********************* Equals and HashCode **********************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.email == null ? 0 : this.email.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (this.email == null) {
			if (other.email != null)
				return false;
		} else if (!this.email.equals(other.email))
			return false;
		return true;
	}

	/*************************** ToString ***************************/
	@Override
	public String toString() {
		return "User [id=" + this.id + ", firstName=" + this.firstName
				+ ", lastName=" + this.lastName + ", email=" + this.email
				+ ", username=" + this.username + ", password=" + this.password
				+ ", role=" + this.role + "]";
	}

}