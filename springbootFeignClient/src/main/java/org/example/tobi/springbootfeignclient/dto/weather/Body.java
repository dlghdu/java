package org.example.tobi.springbootfeignclient.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Body {
    private String dataType;
    private Items items;
}