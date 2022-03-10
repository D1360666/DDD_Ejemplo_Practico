package co.com.sofka.ddd.domain.events;

import co.com.sofka.ddd.domain.entities.Student;
import co.com.sofka.ddd.domain.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Team extends AggregateEvent<TeamIdentity> {
    protected Set<Student> students;

    public Team(TeamIdentity identity, Name name){
        this(identity);
        appendChange(new CreateTeam(name)).apply();
    }

    private Team(TeamIdentity identity){
        super(identity);
        subscribe(new TeamBehavior(this));
    }

    public static Team from(TeamIdentity aggregateId, List<DomainEvent> list){
        Team team = new Team(aggregateId);
        list.forEach(team::applyEvent);
        return team;
    }


    public void addNewStudent(Name name, Gender gender, DateOfBirth dateOfBirth){
        StudentIdentity studentIdentity = new StudentIdentity();
        appendChange(new AddedStudent(studentIdentity, name, gender, dateOfBirth)).apply();
    }

    public void removeStudent(StudentIdentity studentIdentity){
        appendChange(new RemoveStudent(studentIdentity)).apply();
    }

    public void updateName(Name newName){
        appendChange(new UpdatedName(newName)).apply();
    }

    public void updateStudentName(StudentIdentity studentIdentity, Name name){
        appendChange(new UpdateStudent(studentIdentity, name)).apply();
    }

    public void applyScoreToStudent(StudentIdentity studentIdentity, Score score){
        appendChange(new UpdateScoreOfStudent(studentIdentity, score)).apply();
    }

    public Set<Student> students(){
        return students;
    }

    public String name(){
        return name.value();
    }

}
