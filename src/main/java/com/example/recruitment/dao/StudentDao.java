package com.example.recruitment.dao;

import com.example.recruitment.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(Student student) {
        entityManager.remove(entityManager.contains(student) ?
                student : entityManager.merge(student));
    }

    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }
    public List findAll(){
        Query query = entityManager.createQuery("SELECT s from Student s");
        return query.getResultList();
    }
}

