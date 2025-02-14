package com.librarymanagement.loan.application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LoanServiceTest {

    @Autowired
    private LoanService loanService;


    @AfterEach
    public void after() {

    }

    @Test
    void 동시에_100개의_요청으로_책_대출을_시도하면_단_한_번만_대출이_성공한다() throws InterruptedException {
        // given
        Long bookId = 1L; // 테스트용 책 ID
        Long userId = 1L; // 테스트용 사용자 ID

        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicInteger exceptionCount = new AtomicInteger(0);  // AtomicInteger를 사용하여 예외 발생 횟수를 저장

        // when
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    loanService.borrowBook(bookId, userId);  // 대출 시도
                } catch (Exception e) {
                    exceptionCount.incrementAndGet();  // 예외 발생 시 카운트 증가
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();  // 모든 쓰레드가 종료될 때까지 기다림


        // 예외 발생 횟수는 99여야 하므로, 예외 발생 횟수를 확인
        assertEquals(99, exceptionCount.get());  // 예외 발생 횟수는 99여야 함
    }

}
