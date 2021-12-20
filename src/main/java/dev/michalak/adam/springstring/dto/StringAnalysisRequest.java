package dev.michalak.adam.springstring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
  * Jackson + verbose Builder pattern for practice purposes.
  * Lombok is used in {@link StringAnalysisResponse} in case you are wondering.
  */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = StringAnalysisRequest.Builder.class)
public class StringAnalysisRequest {

    @JsonProperty("data")
    @Size(min = 0, message = "Lists of Strings not provided")
    private final List<@NotNull List<String>> listsOfStrings;

    private StringAnalysisRequest(List<List<String>> listsOfStrings) {
        this.listsOfStrings = listsOfStrings;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder toBuilder(StringAnalysisRequest copy) {
        Builder builder = new Builder();
        builder.listsOfStrings = copy.getListsOfStrings();
        return builder;
    }

    public List<List<String>> getListsOfStrings() {
        return listsOfStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAnalysisRequest that = (StringAnalysisRequest) o;
        return Objects.equals(listsOfStrings, that.listsOfStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listsOfStrings);
    }

    @Override
    public String toString() {
        return "StringRequest{listsOfStrings=" + listsOfStrings + "}";
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private List<List<String>> listsOfStrings;

        public Builder() {}

        @JsonProperty("data")
        public Builder listsOfStrings(List<List<String>> listsOfStrings) {
            this.listsOfStrings = listsOfStrings;
            return this;
        }

        public StringAnalysisRequest build() {
            return new StringAnalysisRequest(this.listsOfStrings);
        }
    }
}
