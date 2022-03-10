package co.com.sofka.ddd.domain.events;

import co.com.sofka.ddd.domain.entities.Student;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.generic.Identity;

import java.util.HashSet;

public class TeamBehavior extends EventChange {

    protected TeamBehavior(Team entity){
        apply((CreatedTeam event) -> {
            entity.students = new HashSet<>();
            entity.name = event.getName();
        });

        apply((AddedStudent event) -> {
            var student = new Student(
                    event.getStudentIdentity(),
                    event.getName(),
                    event.getGender(),
                    event.getDateOfBirth()
            );
            entity.students.add(student);
        });

        apply((RemoveStudent event) -> entity.students
                .removeIf(e -> e.identity().equals(event.getIdentity())));

        apply((UpdatedName event) -> entity.name = event.getNewName());

        apply((UpdatedStudent event) -> {
            var studentUpdate = getStudentByIdentity(entity, event.getStudentIdentity());
            studentUpdate.updateName(event.getName());
        });

        apply((UpdateScoreOfStudent event) -> {
            var studentUpdate = getStudentByIdentity(entity, event.getStudentIdentity());
            studentUpdate.updateName(event.getName());
        });
    }

    private Student getStudentByIdentity(Team entity, Identity identity){
        return entity.students.stream()
                .filter(e -> e.identity().equals(identity))
                .findFirst()
                .orElseThrow();
    }
}
