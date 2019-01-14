package com.chrisgruber.nanourl.controllers;

import com.chrisgruber.nanourl.models.UrlAlias;
import com.chrisgruber.nanourl.repositories.UrlAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/u")
public class RedirectionController {
    private UrlAliasRepository urlAliasRepository;

    @Autowired
    public RedirectionController(UrlAliasRepository urlAliasRepository) {
        this.urlAliasRepository = urlAliasRepository;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String redirectNanoUrl(@PathVariable String id, HttpServletRequest request) {
        UrlAlias urlAlias = this.urlAliasRepository.findByAliasPath(id);

        if (urlAlias == null) {
            return "redirect:/";
        }

        urlAlias.setTotalRedirects(urlAlias.getTotalRedirects() + 1);
        this.urlAliasRepository.save(urlAlias);

        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.MOVED_PERMANENTLY);

        return "redirect:" + urlAlias.getUrl();
    }
}
