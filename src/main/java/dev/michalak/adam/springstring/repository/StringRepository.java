package dev.michalak.adam.springstring.repository;

import dev.michalak.adam.springstring.repository.entity.PalindromeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringRepository extends CrudRepository<PalindromeEntity, Long> { }
