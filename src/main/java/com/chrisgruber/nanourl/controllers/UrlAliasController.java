package com.chrisgruber.nanourl.controllers;

import com.chrisgruber.nanourl.models.UrlAlias;
import com.chrisgruber.nanourl.repositories.UrlAliasRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/urlalias")
public class UrlAliasController {
    @Autowired
    private UrlAliasRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UrlAlias> getAllUrlAlias() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UrlAlias getUrlAliasById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUrlAliasById(@PathVariable("id") ObjectId id, @Valid @RequestBody UrlAlias urlAlias) {
        urlAlias.set_id(id);
        repository.save(urlAlias);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UrlAlias createUrlAlias(@Valid @RequestBody UrlAlias urlAlias) {
        urlAlias.set_id(ObjectId.get());
        repository.save(urlAlias);
        return urlAlias;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUrlAlias(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }
}