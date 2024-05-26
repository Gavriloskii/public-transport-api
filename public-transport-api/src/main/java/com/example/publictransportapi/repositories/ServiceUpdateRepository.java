// ServiceUpdateRepository.java
package com.example.publictransportapi.repositories;

import com.example.publictransportapi.entities.ServiceUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUpdateRepository extends JpaRepository<ServiceUpdate, Long> {}

