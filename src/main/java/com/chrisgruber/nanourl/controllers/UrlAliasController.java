package com.chrisgruber.nanourl.controllers;

import com.chrisgruber.nanourl.models.Counter;
import com.chrisgruber.nanourl.models.UrlAlias;
import com.chrisgruber.nanourl.repositories.CounterRepository;
import com.chrisgruber.nanourl.repositories.UrlAliasRepository;
import com.chrisgruber.nanourl.services.UrlInversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/urlalias")
public class UrlAliasController {
    @Autowired
    private UrlAliasRepository repository;

    @Autowired
    private CounterRepository counterRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UrlAlias> getAllUrlAlias() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UrlAlias getUrlAliasById(@PathVariable("id") int id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUrlAliasById(@PathVariable("id") int id, @Valid @RequestBody UrlAlias urlAlias) {
        urlAlias.set_id(id);
        repository.save(urlAlias);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UrlAlias createUrlAlias(@Valid @RequestBody UrlAlias urlAlias) {
        Counter urlAliasCounter = counterRepository.findById("urlAlias").get();
        urlAliasCounter.sequenceValue += 1;

        UrlInversionService urlInversionService = new UrlInversionService();
        String nextEncodedUrlAliasId = urlInversionService.Encode(urlAliasCounter.sequenceValue);

        urlAlias.set_id(urlAliasCounter.sequenceValue);
        urlAlias.set_aliasUrl(nextEncodedUrlAliasId);

        repository.save(urlAlias);
        counterRepository.save(urlAliasCounter);

        return urlAlias;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUrlAlias(@PathVariable int id) {
        repository.delete(repository.findById(id));
    }
}