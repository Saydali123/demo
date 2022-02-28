package com.example.demo.services.organization;

import com.example.demo.dto.organization.OrganizationCreateDto;
import com.example.demo.entity.organization.Organization;
import com.example.demo.repository.organization.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getOrganization(){
        return organizationRepository.findAll();
    }

    public Organization gerOrganizationById(Integer id){
        Optional<Organization> optionalOrganization = organizationRepository.findById(id);

        return optionalOrganization.orElse(null);
    }


    public Long createOrganization(OrganizationCreateDto dto){
        Organization organization = new Organization();

        organization.setName(dto.getName());
        organization.setLogo(dto.getLogo());
        organization.setOwner(dto.getOwner());

        Organization save = organizationRepository.save(organization);
        return save.getId();
    }
}
