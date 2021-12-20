package dev.michalak.adam.springstring.repository;

import dev.michalak.adam.springstring.repository.entity.PalindromeEntity;
import org.springframework.data.repository.CrudRepository;

public interface StringRepository extends CrudRepository<PalindromeEntity, Long> { }
