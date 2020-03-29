package com.demo.resource;

import com.demo.autoinject.TestController;
import com.demo.domain.Person;
import com.demo.repository.PersonRepository;
import com.demo.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/save")
    public Person registerBean(@RequestBody Person person) {
        personRepository.savePerson(person);
        return person;
    }

    @GetMapping("/get/{name}")
    public Person get(@PathVariable String name){
        return personRepository.findPerson(name);
    }

}
