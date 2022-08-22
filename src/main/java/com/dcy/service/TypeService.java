package com.dcy.service;

import com.dcy.po.Type;

import java.util.List;

//
//import com.dcy.po.Type;
//
//import java.util.List;
//
//
//public interface TypeService {
//
//    int saveType(Type type);
//
//    Type getType(Long id);
//
//    List<Type>getAllType();
//
//    List<Type>getAllTypeAndBlog();
//
//    Type getTypeByName(String name);
//
//    int updateType(Type type);
//
//    void deleteType(Long id);
//
//
//
//
//
//}
public interface TypeService{
    int saveType(Type type);

    Type getType(Long id);

    List<Type>getAllType();

    List<Type>getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);




}
