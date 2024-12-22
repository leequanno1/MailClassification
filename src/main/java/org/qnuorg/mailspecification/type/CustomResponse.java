package org.qnuorg.mailspecification.type;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class CustomResponse<T> extends ResponseEntity<Response<T>> {
    public CustomResponse(T body, HttpStatusCode status) {
        super(new Response<>(body, status.value()), status);
    }
}

class Response<T> {
    T data;
    int status;

    Response(T data, int status) {
        this.data = data;
        this.status = status;
    }
}
