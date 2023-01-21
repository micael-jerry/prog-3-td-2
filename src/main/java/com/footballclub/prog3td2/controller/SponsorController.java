package com.footballclub.prog3td2.controller;

import com.footballclub.prog3td2.Service.SponsorService;
import com.footballclub.prog3td2.controller.dto.CreateSponsorDto;
import com.footballclub.prog3td2.controller.dto.SponsorDto;
import com.footballclub.prog3td2.controller.mapper.SponsorMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public List<SponsorDto> postSponsors(@RequestBody List<CreateSponsorDto> createSponsorDtoList) {
        return sponsorService.saveAll(
                        createSponsorDtoList.stream()
                                .map(sponsorMapper::toDomain)
                                .toList()
                ).stream()
                .map(sponsorMapper::toRest)
                .toList();
    }
}
