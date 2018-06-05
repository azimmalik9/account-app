package com.ibm.poc.es.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.math.BigDecimal;

/**
 * Created by satish on 03/06/2018.
 */
@Document(indexName = "bank", type = "account")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"id"}, alphabetic = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {

//    account_number: 995,
//    balance: 21153,
//    firstname: "Phelps",
//    lastname: "Parrish",
//    age: 25,
//    gender: "M",
//    address: "666 Miller Place",
//    employer: "Pearlessa",
//    email: "phelpsparrish@pearlessa.com",
//    city: "Brecon",
//    state: "ME"
//

    @Id
    @Field(analyzer = "account")
    private String accountNumber;

    private Double balance;

    private String firstname;

    private String lastname;

    private Integer age;

    private String gender;

    private String address;

    private String employer;

    private String email;

    private String city;

    private String state;

}
