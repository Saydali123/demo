package com.example.demo.controller.organization;

import com.example.demo.dto.organization.OrganizationCreateDto;
import com.example.demo.dto.organization.OrganizationUpdateDto;
import com.example.demo.entity.organization.Organization;
import com.example.demo.services.organization.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/*")
public class OrganizationController {

    final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @RequestMapping(value = "organization/", method = RequestMethod.GET)
    public List<Organization> getOrganization() {
        return organizationService.getOrganization();
    }


    @RequestMapping(value = "organization/{id}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable Integer id) {
        return organizationService.gerOrganizationById(id);
    }

    @RequestMapping(value = "organization", method = RequestMethod.POST)
    public Long createOrganization(@RequestBody OrganizationCreateDto orgCreateDto){
        return organizationService.createOrganization(orgCreateDto);
    }

//    @RequestMapping(value = "organization/{id}", method = RequestMethod.PUT)
//    public Long updateOrganization(@RequestBody OrganizationUpdateDto updateDto, @PathVariable Integer id){
//
//    }
}
