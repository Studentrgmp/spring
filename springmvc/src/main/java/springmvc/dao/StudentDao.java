package springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import springmvc.dto.StudentDto;

@Component
public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(StudentDto p) {
		entityTransaction.begin();
		entityManager.persist(p);
		entityTransaction.commit();

	}

	public Object fetchbyid(String email) {
		StudentDto st = entityManager.find(StudentDto.class, email);
		if (st != null) {
			return st;
		} else {
			return "no data found";
		}
	}

	public String deleteById(String email) {
		StudentDto st = entityManager.find(StudentDto.class, email);

		if (st != null) {
			entityTransaction.begin();
			entityManager.remove(st);
			entityTransaction.commit();
			return "data deleted";
		} else {
			return "no data found";
		}
	}

	public String deleteAll() {
		Query q = entityManager.createQuery("select a from StudentDto a");
		List<StudentDto> dtos = q.getResultList();
		if (dtos.isEmpty()) {
			return "no data found";
		} else {
			for (StudentDto studentDto : dtos) {
				entityTransaction.begin();
				entityManager.remove(studentDto);
				entityTransaction.commit();
			}

			return "data deleted";
		}
	}

	public Object findAll() {
		Query q = entityManager.createQuery("select a from StudentDto a");
		List<StudentDto> dtos = q.getResultList();
		if (dtos.isEmpty()) {
			return null;
		} else
			return dtos;
	}

	public void update(StudentDto st) {
		entityTransaction.begin();
		entityManager.merge(st);
		entityTransaction.commit();
	}
}
