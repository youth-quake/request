package br.com.youthquake.repository;

import java.util.Collection;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.youthquake.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("from User where login = ?1 and password = ?2")
	User findFirstByLoginAndPassword(String login, String password);
	
	@Query("from User where idUser = ?1")
	List<User> GetInformationUserById(long idUser);
	
}
