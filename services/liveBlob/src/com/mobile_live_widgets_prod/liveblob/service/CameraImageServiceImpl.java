/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_live_widgets_prod.liveblob.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.mobile_live_widgets_prod.liveblob.CameraImage;


/**
 * ServiceImpl object for domain model class CameraImage.
 *
 * @see CameraImage
 */
@Service("liveBlob.CameraImageService")
@Validated
public class CameraImageServiceImpl implements CameraImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CameraImageServiceImpl.class);


    @Autowired
    @Qualifier("liveBlob.CameraImageDao")
    private WMGenericDao<CameraImage, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CameraImage, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "liveBlobTransactionManager")
    @Override
	public CameraImage create(CameraImage cameraImage) {
        LOGGER.debug("Creating a new CameraImage with information: {}", cameraImage);
        CameraImage cameraImageCreated = this.wmGenericDao.create(cameraImage);
        return cameraImageCreated;
    }

	@Transactional(readOnly = true, value = "liveBlobTransactionManager")
	@Override
	public CameraImage getById(Integer cameraimageId) throws EntityNotFoundException {
        LOGGER.debug("Finding CameraImage by id: {}", cameraimageId);
        CameraImage cameraImage = this.wmGenericDao.findById(cameraimageId);
        if (cameraImage == null){
            LOGGER.debug("No CameraImage found with id: {}", cameraimageId);
            throw new EntityNotFoundException(String.valueOf(cameraimageId));
        }
        return cameraImage;
    }

    @Transactional(readOnly = true, value = "liveBlobTransactionManager")
	@Override
	public CameraImage findById(Integer cameraimageId) {
        LOGGER.debug("Finding CameraImage by id: {}", cameraimageId);
        return this.wmGenericDao.findById(cameraimageId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "liveBlobTransactionManager")
	@Override
	public CameraImage update(CameraImage cameraImage) throws EntityNotFoundException {
        LOGGER.debug("Updating CameraImage with information: {}", cameraImage);
        this.wmGenericDao.update(cameraImage);

        Integer cameraimageId = cameraImage.getId();

        return this.wmGenericDao.findById(cameraimageId);
    }

    @Transactional(value = "liveBlobTransactionManager")
	@Override
	public CameraImage delete(Integer cameraimageId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CameraImage with id: {}", cameraimageId);
        CameraImage deleted = this.wmGenericDao.findById(cameraimageId);
        if (deleted == null) {
            LOGGER.debug("No CameraImage found with id: {}", cameraimageId);
            throw new EntityNotFoundException(String.valueOf(cameraimageId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "liveBlobTransactionManager")
	@Override
	public Page<CameraImage> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CameraImages");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "liveBlobTransactionManager")
    @Override
    public Page<CameraImage> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CameraImages");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "liveBlobTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service liveBlob for table CameraImage to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "liveBlobTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "liveBlobTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

