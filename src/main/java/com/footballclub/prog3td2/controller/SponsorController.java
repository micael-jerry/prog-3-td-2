package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.SponsorService;
import com.footballclub.prog3td2.model.Sponsor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sponsors")
public class SponsorController {
    private SponsorService sponsorService;

    @GetMapping
    public List<Sponsor> getAllSponsors() {
        return sponsorService.getAll();
    }
}
