package com.digitalinnovationone.saladereunioes.saladereunioes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "tb_meetingroom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "date",nullable = false)
    private String date;

    @Column(name = "starthour",nullable = false)
    private String starthour;

    @Column(name = "endhour",nullable = false)
    private String endthour;
}
