package com.kbank.orderservice.service;

import com.kbank.orderservice.dao.OrderMapper;
import com.kbank.orderservice.dto.OrderDto;
import com.kbank.orderservice.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getUnitPrice() * orderDto.getQty());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);

        orderMapper.save(orderEntity);

        OrderDto returnDto = mapper.map(orderMapper.findByOrderId(orderDto.getOrderId()), OrderDto.class);

        return returnDto;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderMapper.findByOrderId(orderId);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto returnDto = mapper.map(orderEntity, OrderDto.class);
        
        return returnDto;
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(String userId) {
        return orderMapper.findByUserId(userId);
    }
}
