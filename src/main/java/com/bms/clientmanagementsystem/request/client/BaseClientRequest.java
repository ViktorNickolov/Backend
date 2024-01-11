package com.bms.clientmanagementsystem.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseClientRequest {
    private String firstName;
    private String lastName;
}
