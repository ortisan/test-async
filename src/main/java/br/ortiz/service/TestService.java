package br.ortiz.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestService {

    @Async
    public CompletableFuture<String> asyncMethodWithReturnType() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
            try {
               Integer number = 1 + (int) (Math.random() * (5 + 1));
               Thread.sleep(number * 1000);
                return "hello world !!!!";
            } catch (InterruptedException e) {
            }
            return null;
        });
    }


    public String sayHello() throws Exception {
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(
                asyncMethodWithReturnType(),
                asyncMethodWithReturnType(), asyncMethodWithReturnType(),
                asyncMethodWithReturnType());
        voidCompletableFuture.get();
        return "Hello";
    }
}
