package com.workintech.burgershop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.burgershop.dao.BurgerDaolmpl;
import com.workintech.burgershop.entity.BreadType;
import com.workintech.burgershop.entity.Burger;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    
    private BurgerDaolmpl burgerDaolmpl;

    @Autowired
    public BurgerController(BurgerDaolmpl burgerDaolmpl){
        this.burgerDaolmpl = burgerDaolmpl;
    }

    @GetMapping("/")
    public List<Burger> findAll(){
        return burgerDaolmpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable long id){
        return burgerDaolmpl.findById(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDaolmpl.findByPrice(price);
    }

    @GetMapping("/bread/{breadType}")
    public List<Burger> findByBread(@PathVariable String breadType){
        BreadType btEnum = BreadType.valueOf(breadType);
        return burgerDaolmpl.findByBreadType(btEnum);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDaolmpl.findByContent(content);
    }

    @PostMapping("/")
    public Burger saveBurger(@RequestBody Burger burger){
        return burgerDaolmpl.save(burger);
    }

    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        return burgerDaolmpl.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        return burgerDaolmpl.remove(id);
    }
}
