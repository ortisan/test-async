package br.ortiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@Service
public class TestService {

    @Value("${url_async}")
    private String urlAsync;

    @Autowired
    RestTemplate restTemplate;

    @Async
    public CompletableFuture<String> asyncRestTemplateCall() {
        ResponseEntity<String> response = restTemplate
                .exchange(urlAsync, HttpMethod.GET, null, String.class);
        return CompletableFuture.completedFuture(response.getBody());
    }


    public String sayHello() throws Exception {
        final CompletableFuture<String> call1 = asyncRestTemplateCall();
        final CompletableFuture<String> call2 = asyncRestTemplateCall();
        final CompletableFuture<String> call3 = asyncRestTemplateCall();
        final CompletableFuture<String> call4 = asyncRestTemplateCall();
        final CompletableFuture<String> call5 = asyncRestTemplateCall();
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(call1, call2, call3, call4, call5);
        voidCompletableFuture.get();

        final String return1 = call1.get();
        final String return2 = call2.get();
        final String return3 = call3.get();
        final String return4 = call4.get();
        final String return5 = call5.get();

        return String.join(", ", Arrays.asList(return1, return2, return3, return4, return5));
    }
}
