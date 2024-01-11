package com.bms.clientmanagementsystem.request.clientcase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseClientCaseRequest {
    private Double amountPaid;
    private String clientId;
}
