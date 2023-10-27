package com.nasaexampleproject.nasaexampleapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nasaexampleproject.nasaexampleapi.activities.ApodActivity;
import com.nasaexampleproject.nasaexampleapi.datamodel.Apod;

public class ApodControllerTest {

    private static final String START_DATE = "2023-10-25";
    private static final String END_DATE = "2023-10-26";
    
    private ApodController apodController;
    @Mock
    private ApodActivity apodActivity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        apodController = new ApodController(apodActivity);
    }

    @Test
    public void testGetAstronomyPicturesInDateRange() {
        // Given
        Apod apod1 = Apod.builder().date(START_DATE).build();
        Apod apod2 = Apod.builder().date(END_DATE).build();
        List<Apod> expectedApods = new ArrayList<>();
        expectedApods.add(apod1);
        expectedApods.add(apod2);
        when(apodActivity.getApodInDateRange(START_DATE, END_DATE)).thenReturn(expectedApods);

        // When
        List<Apod> actualApods = apodController.getApodInDateRange(START_DATE, END_DATE);

        // (Lazy) Then
        assertEquals(expectedApods.size(), actualApods.size());
    }
}
