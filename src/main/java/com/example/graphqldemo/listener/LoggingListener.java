package com.example.graphqldemo.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoggingListener implements GraphQLServletListener {

    private final Clock clock;

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        var startTime = Instant.now(clock);
        log.info("Received GraphQL request");

        return new RequestCallback() {
            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                //no-op
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response,
                                Throwable throwable) {
                //no-op
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("Completed request: {}",
                        Duration.between(startTime, Instant.now(clock)));
            }
        };
    }

}
