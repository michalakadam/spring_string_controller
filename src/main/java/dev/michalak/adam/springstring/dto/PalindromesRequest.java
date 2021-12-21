package dev.michalak.adam.springstring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.michalak.adam.springstring.dto.validation.PalindromesConstraint;

import javax.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PalindromesRequest.Builder.class)
public class PalindromesRequest {
    @JsonProperty
    @NotEmpty
    @PalindromesConstraint
    private final List<String> palindromes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalindromesRequest that = (PalindromesRequest) o;
        return Objects.equals(palindromes, that.palindromes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palindromes);
    }

    private PalindromesRequest(Builder builder) {
        palindromes = builder.palindromes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PalindromesRequest copy) {
        Builder builder = new Builder();
        builder.palindromes = copy.getPalindromes();
        return builder;
    }

    public List<String> getPalindromes() {
        return palindromes;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private List<String> palindromes;

        private Builder() {
        }

        public Builder palindromes(List<String> palindromes) {
            this.palindromes = palindromes;
            return this;
        }

        public PalindromesRequest build() {
            return new PalindromesRequest(this);
        }
    }
}
