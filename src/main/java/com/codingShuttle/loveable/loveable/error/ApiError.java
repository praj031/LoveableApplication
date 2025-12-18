package com.codingShuttle.loveable.loveable.error;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiError(HttpStatus status,
                       String mesage,
                       Instant timestamp,
                       @JsonInclude(JsonInclude.Include.NON_NULL) List<ApiFieldError> errors) {



    //This class will return the error.


    public ApiError (HttpStatus status,String mesage){

        this(status, mesage, Instant.now(),null);
        //This will return the status and message
    }

    public ApiError (HttpStatus status, String message, List<ApiFieldError> errors){
            this(status,message,Instant.now(),errors);
            //This will return the status message & list of error message
    }


}

record ApiFieldError(String field, String message){

}
