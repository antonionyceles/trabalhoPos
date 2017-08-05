package com.pos.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoniony.lima
 */
public abstract class DaoGenerico {

    public void adiciona(Object obj) {
    }

    public Object find(Object obj) {
        return new Object();
    }

    public Object findOneBy(List<Object> obj) {
        return new Object();
    }

    public List<Object> findBy(List<Object> obj) {
        return new ArrayList<Object>();
    }

    public void deletar(Object id) {
    }

    public List<Object> findAll() {
        return new ArrayList<Object>();
    }

}
