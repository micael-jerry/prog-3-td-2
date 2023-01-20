package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.SponsorService;
import com.footballclub.prog3td2.controller.dto.SponsorDto;
import com.footballclub.prog3td2.controller.mapper.SponsorMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sponsors")
public class SponsorController {
    private SponsorService sponsorService;
    private SponsorMapper sponsorMapper;

    @GetMapping
    public List<SponsorDto> getAllSponsors() {
        return sponsorService.getAll().stream().map(sponsorMapper::toRest).toList();
    }

    @GetMapping(value = "/{id}")
    public SponsorDto getSponsor(@PathVariable Integer id) {
        return sponsorMapper.toRest(
                sponsorService.getById(id)
        );
    }
}
