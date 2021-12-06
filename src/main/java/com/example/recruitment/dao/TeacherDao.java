package com.example.recruitment.dao;

import com.example.recruitment.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    public void update(Teacher teacher) {
        entityManager.merge(teacher);
    }

    public void delete(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher) ?
                teacher : entityManager.merge(teacher));
    }

    public Teacher findById(long id) {
        return entityManager.find(Teacher.class, id);
    }
    public List findAll(){
        Query query = entityManager.createQuery("SELECT t from Teacher t");
        return query.getResultList();
    }
}
