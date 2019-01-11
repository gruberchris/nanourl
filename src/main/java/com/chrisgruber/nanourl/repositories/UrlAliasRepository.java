package com.chrisgruber.nanourl.repositories;

import com.chrisgruber.nanourl.models.UrlAlias;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlAliasRepository extends MongoRepository<UrlAlias, String> {
    UrlAlias findById(int id);
}