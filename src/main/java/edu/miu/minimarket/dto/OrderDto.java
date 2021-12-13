package edu.miu.minimarket.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDto {

    private Long id;
    private LocalDate createdDate;
    private String orderStatus;
    private double totalPrice;



}
