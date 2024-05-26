// FareRepository.java
package com.example.publictransportapi.repositories;

import com.example.publictransportapi.entities.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Long> {}

