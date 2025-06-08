package com.myoffice.companyidentity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCompanyIdentitiesList implements Serializable {

    @Serial
    private static final long serialVersionUID = -3997006367202826784L;

    private String companyId;

    private String companyName;

}
