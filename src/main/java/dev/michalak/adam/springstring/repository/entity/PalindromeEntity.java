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
public class PalindromeEntity {

    @Id
    private Long id;
    private String palindrome;

    public PalindromeEntity(String palindrome) {
        this.id = (long) palindrome.hashCode();
        this.palindrome = palindrome;
    }

    @Override
    public String toString() {
        return id + ": " + palindrome;
    }
}
