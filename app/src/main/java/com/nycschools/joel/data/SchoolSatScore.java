package com.nycschools.joel.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SchoolSatScore implements Parcelable{
   private String dbn;
   private String noSatTakers;
   private String criticalReadingAvgScore;
   private String mathAvgScore;
   private  String writingAvgScore;
   private String schoolName;

    public SchoolSatScore() {
    }

    public SchoolSatScore(String dbn, String noSatTakers, String criticalReadingAvgScore, String mathAvgScore, String writingAvgScore, String schoolName) {
        this.dbn = dbn;
        this.noSatTakers = noSatTakers;
        this.criticalReadingAvgScore = criticalReadingAvgScore;
        this.mathAvgScore = mathAvgScore;
        this.writingAvgScore = writingAvgScore;
        this.schoolName = schoolName;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getNoSatTakers() {
        return noSatTakers;
    }

    public void setNoSatTakers(String noSatTakers) {
        this.noSatTakers = noSatTakers;
    }

    public String getCriticalReadingAvgScore() {
        return criticalReadingAvgScore;
    }

    public void setCriticalReadingAvgScore(String criticalReadingAvgScore) {
        this.criticalReadingAvgScore = criticalReadingAvgScore;
    }

    public String getMathAvgScore() {
        return mathAvgScore;
    }

    public void setMathAvgScore(String mathAvgScore) {
        this.mathAvgScore = mathAvgScore;
    }

    public String getWritingAvgScore() {
        return writingAvgScore;
    }

    public void setWritingAvgScore(String writingAvgScore) {
        this.writingAvgScore = writingAvgScore;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dbn);
        parcel.writeString(schoolName);
        parcel.writeString(noSatTakers);
        parcel.writeString(criticalReadingAvgScore);
        parcel.writeString(mathAvgScore);
        parcel.writeString(writingAvgScore);
    }
    public static final Parcelable.Creator<SchoolSatScore> CREATOR = new Creator<SchoolSatScore>() {
        public SchoolSatScore createFromParcel(Parcel in) {
            return new SchoolSatScore(in);
        }
        public SchoolSatScore[] newArray(int size) {
            return new SchoolSatScore[size];
        }
    };

    private SchoolSatScore(Parcel in) {
        dbn = in.readString();
        noSatTakers = in.readString();
        criticalReadingAvgScore = in.readString();
        mathAvgScore = in.readString();
        writingAvgScore = in.readString();
        schoolName = in.readString();
    }
}
