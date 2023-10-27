package com.nasaexampleproject.nasaexampleapi.activities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nasaexampleproject.nasaexampleapi.datamodel.Apod;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApodActivity {

    private static final String NASA_APOD_URL = "https://api.nasa.gov/planetary/apod";
    private static final String API_KEY = "replace-with-real-API-key";

    private final RestTemplate restTemplate;
    
    /* 
     * Simple get apod method, always takes a date, even if it is today.
     */
    public Apod getApod (String date) {
        // Build URL
        String url = NASA_APOD_URL + "?api_key=" + API_KEY + "&date=" + date; 

        // Call and return the Apod data class.
        return restTemplate.getForObject(url, Apod.class);
    }

    /*
     * Get apods within given date range.
     */
    public List<Apod> getApodInDateRange (String startDate, String endDate) {
        List<Apod> apods = new ArrayList<>();
        LocalDate currentDate = LocalDate.parse(startDate);
        LocalDate finalDate = LocalDate.parse(endDate);

        while (!currentDate.isAfter(finalDate)) {
            String date = currentDate.toString();
            Apod apod = getApod(date);
            apods.add(apod);
            currentDate = currentDate.plusDays(1);
        }

        return apods;
    }
}
