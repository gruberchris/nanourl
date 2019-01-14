package com.chrisgruber.nanourl.controllers;

import com.chrisgruber.nanourl.models.UserProfile;
import com.chrisgruber.nanourl.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/userprofile")
public class UserProfileController {
    private UserProfileRepository userProfileRepository;

    public UserProfileController() {

    }

    @Autowired
    public UserProfileController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserProfile getUserProfileById(@PathVariable("id") int id) {
        return this.userProfileRepository.findById(id);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public UserProfile getUserProfileByEmail(@PathVariable("id") String email) {
        return this.userProfileRepository.findByEmail(email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserProfile(@PathVariable("id") int id) {
        this.userProfileRepository.delete(this.userProfileRepository.findById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUserProfile(@PathVariable("id") int id, @Valid @RequestBody UserProfile userProfile) {
        userProfile.setId(id);
        this.userProfileRepository.save(userProfile);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserProfile createUserProfile(@Valid @RequestBody UserProfile userProfile) {
        this.userProfileRepository.save(userProfile);
        return userProfile;
    }
}