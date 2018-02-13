package com.nycschools.joel.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable{

	private String dbn;
	private String school_name;

    public Data(String school_name, String dbn) {
        this.dbn = dbn;
        this.school_name = school_name ;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return school_name;
    }

    public void setSchoolName(String schoolName) {
        this.school_name = schoolName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dbn);
        parcel.writeString(school_name);
    }

    public static final Parcelable.Creator<Data> CREATOR
            = new Parcelable.Creator<Data>() {
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    private Data(Parcel in) {
        this.dbn = in.readString();
        this.school_name = in.readString();
    }
}



