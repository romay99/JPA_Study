package com.jpa.demo.service;

import com.jpa.demo.domain.Delivery;
import com.jpa.demo.domain.Member;
import com.jpa.demo.domain.Order;
import com.jpa.demo.domain.OrderItem;
import com.jpa.demo.domain.item.Item;
import com.jpa.demo.repository.ItemRepository;
import com.jpa.demo.repository.MemberRepository;
import com.jpa.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findById(memberId);
        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId);
        order.cancel();
    }

    //나중에
//    public List<Order> findOrder(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}
