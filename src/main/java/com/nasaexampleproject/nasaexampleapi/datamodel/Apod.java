package com.nasaexampleproject.nasaexampleapi.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
 * Data model for the Astronomy Picture of the Day.
 * An example of this model is found here 
 * https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Apod {
    private String title;
    private String url;
    private String explanation;
    private String date;
}
