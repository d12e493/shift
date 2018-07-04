package com.davis.shift.configuration;

import com.davis.shift.controller.UserController;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {

        System.out.println("CustomResourceProcessor");

        resource.getLinks().forEach(l->System.out.println(l));

        resource.add(ControllerLinkBuilder.linkTo(UserController.class).withRel("users"));
        return resource;
    }
}