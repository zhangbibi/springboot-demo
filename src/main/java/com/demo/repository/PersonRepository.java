package com.demo.repository;

import com.demo.domain.Person;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by zhangyaping on 20/3/28.
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "person")
    Person findPerson(String id);

    boolean savePerson(Person person);
}
