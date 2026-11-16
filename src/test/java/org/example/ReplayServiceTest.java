package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ReplayServiceTest {

    private ReplayService replayService;

    @BeforeEach
    void setUp() {
        replayService = new ReplayService();
    }

    @Test
    void startPlayback() {
        replayService.play();
    }

}