package com.jpa.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrderServiceTest {

    @Test // 상품주문
    public void 상품주문() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void 주문취소() throws Exception {
        //given

        //when

        //then
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given

        //when

        //then
    }


}