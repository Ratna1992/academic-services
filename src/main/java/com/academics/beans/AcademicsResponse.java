package com.academics.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademicsResponse {
    private Object data;
    private Error error;
    private String status;
}
