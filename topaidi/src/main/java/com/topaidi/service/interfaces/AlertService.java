package com.topaidi.service.interfaces;

import java.util.List;

import com.topaidi.dao.interfaces.GenericDao;
import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;

public interface AlertService extends GenericDao<Alert,Integer>{

	List<Alert> findAllByCreateAt();
	List<Alert> findAllByCreateAtAndByType(AlertType type);
}
