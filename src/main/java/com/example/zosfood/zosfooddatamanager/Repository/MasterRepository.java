package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, String> {
}
