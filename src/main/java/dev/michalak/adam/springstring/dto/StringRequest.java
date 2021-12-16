package dev.michalak.adam.springstring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = StringRequest.Builder.class)
public class StringRequest implements Serializable {
    // Required to verify that loaded class and the serialized object are compatible.
    private static final long serialVersionUID = 1234567L;

    @JsonProperty("data")
    @Size(min = 0, message = "Lists of Strings not provided")
    private final List<@NotNull List<String>> listsOfStrings;

    private StringRequest(List<List<String>> listsOfStrings) {
        this.listsOfStrings = listsOfStrings;
    }

    public static Builder toBuilder(StringRequest copy) {
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
        StringRequest that = (StringRequest) o;
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

        public Builder listsOfStrings(List<List<String>> listsOfStrings) {
            this.listsOfStrings = listsOfStrings;
            return this;
        }

        public StringRequest build() {
            return new StringRequest(this.listsOfStrings);
        }
    }
}
