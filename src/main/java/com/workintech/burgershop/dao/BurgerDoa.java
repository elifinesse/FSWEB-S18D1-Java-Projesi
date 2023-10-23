package com.workintech.burgershop.dao;

import java.util.List;

import com.workintech.burgershop.entity.BreadType;
import com.workintech.burgershop.entity.Burger;

public interface BurgerDoa {
    Burger save(Burger burger);
    Burger findById(Long id);
    List<Burger> findAll();
    List<Burger>findByPrice(double price); 
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(long id);
}
