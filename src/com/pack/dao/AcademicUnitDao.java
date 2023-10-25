package com.pack.dao;

import java.sql.SQLException;
import java.util.List;

import com.pack.model.AcademicUnit;
import com.pack.model.AcademicUnit.UnityType;

public interface AcademicUnitDao {
	
	void insertAcademicUnit(AcademicUnit academic) throws SQLException;

	AcademicUnit selectAcademicUnit(int academicUnitId);

	List<AcademicUnit> selectAllAcademicUnit();

	boolean deleteAcademicUnit(int id) throws SQLException;

	void updateAcademicUnit(AcademicUnit academic) throws SQLException;
	
	List<AcademicUnit> selectAcademicUnitsByType(UnityType unityType);


}
