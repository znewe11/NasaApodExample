package com.nasaexampleproject.nasaexampleapi.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.nasaexampleproject.nasaexampleapi.datamodel.Apod;

public class ApodActivityTest {

    private static final String DATE_STRING = "2023-10-20";
    private static final String TITLE = "SomeTitle";
    private static final String EXPLANATION = "Some Explaination";
    private static final String SOME_URL = "https://helloworld.com";

    private ApodActivity apodActivity;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        apodActivity = new ApodActivity(restTemplate);
    }

    @Test
    public void testGetApod () {
        // Given
        Apod expectedApod = Apod.builder()
                                .title(TITLE)
                                .explanation(EXPLANATION)
                                .url(SOME_URL)
                                .date(DATE_STRING)
                                .build();

        when(restTemplate.getForObject(anyString(), eq(Apod.class)))
            .thenReturn(expectedApod);

        // When
        Apod responseApod = apodActivity.getApod(DATE_STRING);

        // Then
        assertEquals(expectedApod.getTitle(), responseApod.getTitle());
        assertEquals(expectedApod.getExplanation(), responseApod.getExplanation());
        assertEquals(expectedApod.getUrl(), responseApod.getUrl());
        assertEquals(expectedApod.getDate(), responseApod.getDate());
    }
    
}
