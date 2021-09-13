package com.springboot.app.dao;

import com.springboot.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query q = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employeesList = q.getResultList();

        return employeesList;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee e) {
        Employee newEmp = entityManager.merge(e);
        e.setId(newEmp.getId());
    }

    @Override
    public void deleteById(int id) {
        Query q = entityManager.createQuery("delete from Employee where id=:employeeId");
        q.setParameter("employeeId", id);
        q.executeUpdate();
    }
}
