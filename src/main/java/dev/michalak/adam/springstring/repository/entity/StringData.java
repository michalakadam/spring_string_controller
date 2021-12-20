package dev.michalak.adam.springstring.repository.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class StringData {

    @Id
    private Long id;
    private String concatenatedResult;

    public StringData(String concatenatedResult) {
        this.id = (long) concatenatedResult.hashCode();
        this.concatenatedResult = concatenatedResult;
    }

    @Override
    public String toString() {
        return id + ": " + concatenatedResult;
    }
}
