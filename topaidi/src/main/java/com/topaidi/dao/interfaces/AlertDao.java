package com.topaidi.dao.interfaces;

import java.util.List;

import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;

public interface AlertDao extends GenericDao<Alert,Integer> {
	List<Alert> findAllByCreateAt();
	List<Alert> findAllByCreateAtAndByType(AlertType type);
}
