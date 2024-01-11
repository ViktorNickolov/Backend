package com.bms.clientmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 64)
    private String firstName;

    @Column(length = 64)
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<ClientCase> clientCases;

    @OneToMany(mappedBy = "client")
    private List<Document> documents;
}
