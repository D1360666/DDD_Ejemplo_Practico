package co.com.sofka.ddd.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String name;

    public Name(String name) {
        try {
            this.name = name;
            if(this.name == null){
                throw new IllegalArgumentException("Invalid name");
            }
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Name n = (Name) o;
        return Objects.equals(name, n.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
