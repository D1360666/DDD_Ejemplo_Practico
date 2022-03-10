package co.com.sofka.ddd.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Score implements ValueObject<Integer> {

    private final int score;

    public Score(int score) {
        try{
            if(score<0){
                throw new IllegalArgumentException("Invalid score");
            }else{
                this.score = score;
            }

        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    public Integer value() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        Score numero = (Score) o ;
        return Objects.equals(score, numero.score);
    }

    @Override
    public int hashCode(){
        return Objects.hash(score);
    }

}
