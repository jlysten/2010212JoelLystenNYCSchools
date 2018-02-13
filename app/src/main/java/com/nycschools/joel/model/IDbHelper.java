package com.nycschools.joel.model;


import com.nycschools.joel.data.SchoolSatScore;

/**
 * Created by joel on 2/13/2018.
 */

public interface IDbHelper {

    public void insertSchoolSatScore(SchoolSatScore schoolSatScore);
    public SchoolSatScore getSchoolSatScore(String dbn);
    public void populateDb(String jsonString);
}
