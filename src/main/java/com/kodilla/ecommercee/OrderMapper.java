package com.kodilla.ecommercee;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public GenericEntity mapToOrder(final OrderDto orderDto) {
        return new GenericEntity();
    }

    public OrderDto mapToOrderDto(final GenericEntity entity) {
        return new OrderDto();
    }

    public List<OrderDto> mapToOrderDtoList(final List<GenericEntity> orderList) {
        return orderList.stream()
                .map(e -> new OrderDto(e.getId(), e.getValue()))
                .collect(Collectors.toList());
    }

}
