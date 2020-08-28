package com.ysvg2tafy.studentdatabase;

import com.orm.SugarRecord;

public class Student extends SugarRecord {

    String Name, Roll;

    // Default constructor is important!
    public Student() {
    }

    public Student(String Name, String Roll) {
        this.Name = Name;
        this.Roll = Roll;

    }

// Getter setters here
}