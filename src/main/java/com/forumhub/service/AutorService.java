package com.forumhub.service;

import com.forumhub.model.Autor;
import com.forumhub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


}
