package co.com.sofka.ddd.domain.events;

import co.com.sofka.ddd.domain.values.DateOfBirth;
import co.com.sofka.ddd.domain.values.Gender;
import co.com.sofka.ddd.domain.values.Name;
import co.com.sofka.ddd.domain.values.StudentIdentity;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedStudent extends DomainEvent {

    private final StudentIdentity studentIdentity;
    private final Name name;
    private final Gender gender;
    private final DateOfBirth dateOfBirth;

    public AddedStudent(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        super("training.team.addstudent");
        this.studentIdentity=studentIdentity;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Name getName(){
        return  name;
    }

    public Gender getGender(){
        return gender;
    }

    public DateOfBirth getDateOfBirth(){
        return dateOfBirth;
    }
}

