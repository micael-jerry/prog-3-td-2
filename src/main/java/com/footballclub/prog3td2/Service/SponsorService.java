package com.footballclub.prog3td2.Service;

import com.footballclub.prog3td2.controller.exception.BadRequestException;
import com.footballclub.prog3td2.model.Sponsor;
import com.footballclub.prog3td2.repository.SponsorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService {
    private SponsorRepository sponsorRepository;

    public List<Sponsor> getAll() {
        return sponsorRepository.findAll();
    }

    public Sponsor getById(Integer id) {
        if (sponsorRepository.existsById(id)) {
            return sponsorRepository.getReferenceById(id);
        }
        throw new BadRequestException("Id: " + id + " not exist");
    }

    public List<Sponsor> saveAll(List<Sponsor> sponsorList) {
        return sponsorRepository.saveAll(sponsorList);
    }
}
