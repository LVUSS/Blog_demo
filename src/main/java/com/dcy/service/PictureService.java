package com.dcy.service;

import com.dcy.po.Picture;

import java.util.List;

public interface PictureService {

    //查询所有图片
    List<Picture> listPicture();

    //新增图片
    int savePicture(Picture picture);

    //根据id查询图片
    Picture searchPicture(Long id);

    //编辑修改图片
    int updatePicture(Picture picture);

    //删除图片
    void deletePicture(Long id);




}
