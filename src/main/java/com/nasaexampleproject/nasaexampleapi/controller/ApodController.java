package com.nasaexampleproject.nasaexampleapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nasaexampleproject.nasaexampleapi.activities.ApodActivity;
import com.nasaexampleproject.nasaexampleapi.datamodel.Apod;

import lombok.AllArgsConstructor;

/*
 * Apod Rest controller
 */
@RestController
@RequestMapping("/apod")
@AllArgsConstructor
public class ApodController {

    private ApodActivity apodActivity;
    
    /*
     * Mapping for getting the current APOD.
     */
    @GetMapping("/today")
    public Apod getApod () {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        return apodActivity.getApod(date);
    }

    /*
     * Mapping for a user defined date range.
     */
    @GetMapping("/dateRange")
    public List<Apod> getApodInDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        return apodActivity.getApodInDateRange(startDate, endDate);
    }
}
