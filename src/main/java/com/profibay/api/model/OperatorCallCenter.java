package com.profibay.api.model;


import com.profibay.api.interfaces.EmployerEntityIntarface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OperatorCallCenter extends BaseModel implements EmployerEntityIntarface {


    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "city")
    private String city;

    @Column(name = "note_about_operator")
    private String note_about_operator;

    @Column(name = "rating")
    private int rating;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_employer_document")
    private EmployerImg operatorCallCenterImg;



    @ManyToMany
    @JoinTable (
            name = "operator_call_center_to_reason_cancellation",
            joinColumns = @JoinColumn (name = "operator_call_center_id"),
            inverseJoinColumns = @JoinColumn (name = "reason_cancellation_id")
    )
    private List<ReasonCancellation> reasonCancellationList;





}
