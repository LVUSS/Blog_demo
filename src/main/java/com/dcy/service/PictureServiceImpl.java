package com.dcy.service;

import com.dcy.dao.PictureDao;
import com.dcy.po.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl  implements PictureService{

    @Autowired
    private PictureDao pictureDao;



    @Override
    public List<Picture> listPicture() {
        return pictureDao.listPicture();
    }

    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    @Override
    public Picture searchPicture(Long id) {
        return pictureDao.searchPicture(id);
    }


    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public void deletePicture(Long id) {

        pictureDao.deletePicture(id);

    }
}
