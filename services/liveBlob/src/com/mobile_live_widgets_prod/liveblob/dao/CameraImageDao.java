/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_live_widgets_prod.liveblob.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.mobile_live_widgets_prod.liveblob.CameraImage;

/**
 * Specifies methods used to obtain and modify CameraImage related information
 * which is stored in the database.
 */
@Repository("liveBlob.CameraImageDao")
public class CameraImageDao extends WMGenericDaoImpl<CameraImage, Integer> {

    @Autowired
    @Qualifier("liveBlobTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}
