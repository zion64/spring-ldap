package org.springframework.ldap.samples.useradmin.domain.impl;

import java.util.List;

import javax.naming.Name;

import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.samples.useradmin.domain.User;
import org.springframework.ldap.samples.useradmin.domain.UserRepo;

public class UserRepoImpl implements UserRepo {

	@Override
	public User findOne(LdapQuery ldapQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll(LdapQuery ldapQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Name id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Name id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll(Iterable<Name> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Name id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByEmployeeNumber(int employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByFullNameContains(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
