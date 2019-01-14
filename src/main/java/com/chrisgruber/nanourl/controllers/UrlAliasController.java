package com.chrisgruber.nanourl.controllers;

import com.chrisgruber.nanourl.exceptions.NanoUrlEntityNotFoundException;
import com.chrisgruber.nanourl.exceptions.NanoUrlEntitySaveException;
import com.chrisgruber.nanourl.models.Counter;
import com.chrisgruber.nanourl.models.UrlAlias;
import com.chrisgruber.nanourl.models.UserProfile;
import com.chrisgruber.nanourl.repositories.CounterRepository;
import com.chrisgruber.nanourl.repositories.UrlAliasRepository;
import com.chrisgruber.nanourl.services.UrlInversionService;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/urlalias")
public class UrlAliasController {
    @Autowired
    private UrlAliasRepository repository;

    @Autowired
    private CounterRepository counterRepository;

    @Autowired
    private UrlInversionService urlInversionService;

    @Value("${nanourl.defaultHost}")
    private String defaultHost;

    @Value("${nanourl.defaultScheme}")
    private String defaultScheme;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UrlAlias> getAllUrlAlias() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UrlAlias getUrlAliasById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUrlAliasById(@PathVariable("id") long id, @Valid @RequestBody UrlAlias urlAlias) {
        urlAlias.setId(id);
        repository.save(urlAlias);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UrlAlias createUrlAlias(@Valid @RequestBody UrlAlias urlAlias) {
        Counter urlAliasCounter = null;
        final String urlAliasCounterName = "urlAlias";

        try {
            urlAliasCounter = counterRepository.findById(urlAliasCounterName).get();
        } catch (NoSuchElementException e) {
            // Return HTTP Status 404
            throw new NanoUrlEntityNotFoundException();
        }

        urlAliasCounter.setSequenceValue(urlAliasCounter.getSequenceValue() + 1);

        String nextEncodedUrlAliasId = urlInversionService.Encode(urlAliasCounter.getSequenceValue());

        urlAlias.setId(urlAliasCounter.getSequenceValue());
        urlAlias.setAliasUrl(this.defaultScheme + "://" + this.defaultHost + "/u/" + nextEncodedUrlAliasId);
        urlAlias.setAliasPath(nextEncodedUrlAliasId);
        // TODO: Temp hard code a fake user profile
        urlAlias.setOwnerUserProfile(new UserProfile(0, "noone@example.com"));

        try {
            repository.save(urlAlias);
            counterRepository.save(urlAliasCounter);
        } catch (MongoException e) {
            // Return HTTP Status 500
            throw new NanoUrlEntitySaveException();
        }

        return urlAlias;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUrlAlias(@PathVariable long id) {
        repository.delete(repository.findById(id));
    }
}