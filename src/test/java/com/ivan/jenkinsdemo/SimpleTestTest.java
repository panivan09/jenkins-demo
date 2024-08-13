package com.ivan.jenkinsdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SimpleTestTest {


    private SimpleTest simpleTest;

    @BeforeEach
    void setUp() {
        simpleTest = new SimpleTest();
    }

    @Test
    void getValue_shouldReturn12() {
        // Given
        String expected = "12";

        // When
        String actual = simpleTest.getValue();

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}