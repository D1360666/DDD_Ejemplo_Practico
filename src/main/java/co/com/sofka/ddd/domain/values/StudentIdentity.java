package co.com.sofka.ddd.domain.values;

import co.com.sofka.domain.generic.Identity;

public class StudentIdentity extends Identity {

    public StudentIdentity(String id){
        super(id);
    }

    public StudentIdentity(){}

    public static StudentIdentity of(String id){
        return new StudentIdentity(id);
    }

}
