package co.com.sofka.ddd.domain.entities;

import co.com.sofka.ddd.domain.values.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Student extends Entity<StudentIdentity> {

    protected Name name;
    protected Gender gender;
    protected DateOfBirth dateOfBirth;
    protected Score score;

    protected Student(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        super(studentIdentity);
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.score = new Score(0);
    }


    public Student(StudentIdentity entityId) {
        super(entityId);
    }

    public static Student from(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        var student = new Student(studentIdentity);
        student.name = name;
        student.gender = gender;
        student.dateOfBirth = dateOfBirth;
        return student;
    }

    public String name(){
        return name.value();
    }

    public String gender(){
        return gender.value();
    }

    public String dateOfBirth(){
        return dateOfBirth.value();
    }

//TODO Revisar por qué no funciona el VALUES
    /* public Score.Values score(){
        return score.value();
    }*/

    public void updateScore(Score score){
        this.score = score;
    }

    public void updateName(Name name){
        this.name = name;
    }

    public void updateDateOfBirth(DateOfBirth dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void updateGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
}
