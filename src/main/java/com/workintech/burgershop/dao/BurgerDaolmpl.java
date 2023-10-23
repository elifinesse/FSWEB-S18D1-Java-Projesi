package com.workintech.burgershop.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.workintech.burgershop.entity.BreadType;
import com.workintech.burgershop.entity.Burger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class BurgerDaolmpl implements BurgerDoa{

    private EntityManager entityManager;

    @Autowired
    public BurgerDaolmpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(@RequestBody Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
       return entityManager.find(Burger.class, id);
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e WHERE e.price > :price ORDER BY e.price desc", Burger.class);
        query.setParameter("price", price);
        return query.getResultList().stream().toList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e WHERE e.breadType = :breadType ORDER BY e.name asc", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList().stream().toList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e WHERE e.contents LIKE CONCAT('%', :content, '%') ORDER BY name", Burger.class);
        query.setParameter("content", content);
        return query.getResultList().stream().toList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(long id) {
        Burger burger = entityManager.find(Burger.class, id);
        if(burger != null){
            entityManager.remove(burger);
        }
        return burger;
    }
}
