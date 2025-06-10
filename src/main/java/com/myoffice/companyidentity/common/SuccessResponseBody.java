package com.myoffice.companyidentity.common;

import java.io.Serial;
import java.io.Serializable;

public record SuccessResponseBody (

        String message,
        Object data

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 3751877685642552972L;

}
