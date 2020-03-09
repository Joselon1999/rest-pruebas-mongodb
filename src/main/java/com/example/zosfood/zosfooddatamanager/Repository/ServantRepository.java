package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Entity.Servant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServantRepository extends JpaRepository<Servant,String> {
}
