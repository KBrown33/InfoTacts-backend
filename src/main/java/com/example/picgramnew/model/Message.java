package com.example.picgramnew.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column
    private Long id;
    @Column
    private String user_name;
    @Column
    private String user_message;
}

