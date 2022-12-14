package com.dcy.service;

import com.dcy.dao.TypeDao;
import com.dcy.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import com.dcy.dao.TypeDao;
//import com.dcy.po.Type;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class TypeServiceImpl implements TypeService {
//    @Autowired
//    private TypeDao typeDao;
//
//    @Transactional
//    @Override
//    public int saveType(Type type) {
//        return typeDao.saveType(type);
//    }
//
//    @Transactional
//    @Override
//    public Type getType(Long id) {
//        return typeDao.getType(id);
//    }
//
//    @Transactional
//    @Override
//    public List<Type> getAllType() {
//        return typeDao.getAllType();
//    }
//
//    @Override
//    public List<Type> getAllTypeAndBlog() {
//        return typeDao.getAllTypeAndBlog();
//    }
//
//    @Override
//    public Type getTypeByName(String name) {
//        return typeDao.getTypeByName(name);
//    }
//
//    @Transactional
//    @Override
//    public int updateType(Type type) {
//        return typeDao.updateType(type);
//    }
//
//    @Transactional
//    @Override
//    public void deleteType(Long id) {
//        typeDao.deleteType(id);
//    }
//
//}
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }


}
