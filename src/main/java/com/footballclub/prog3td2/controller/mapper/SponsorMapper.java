package com.footballclub.prog3td2.controller.mapper;

import com.footballclub.prog3td2.controller.dto.SponsorDto;
import com.footballclub.prog3td2.model.Sponsor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorMapper {
    public SponsorDto toRest(Sponsor sponsor) {
        return SponsorDto.builder()
                .id(sponsor.getId())
                .name(sponsor.getName())
                .build();
    }

    public Sponsor toDomain(SponsorDto sponsorDto) {
        Sponsor sponsor = new Sponsor();
        sponsor.setId(sponsorDto.getId());
        sponsor.setName(sponsor.getName());
        return sponsor;
    }

    public List<SponsorDto> toRest(List<Sponsor> sponsorList) {
        return sponsorList.stream().map(this::toRest).toList();
    }

    public List<Sponsor> toDomain(List<SponsorDto> sponsorDtoList) {
        return sponsorDtoList.stream().map(this::toDomain).toList();
    }
}
