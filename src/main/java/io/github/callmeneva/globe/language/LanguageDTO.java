package io.github.callmeneva.globe.language;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LanguageDTO {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "country")
    private String countryName;

    @JsonProperty(value = "official")
    private boolean official;

    @JsonProperty(value = "percentage")
    private float percentage;
}
