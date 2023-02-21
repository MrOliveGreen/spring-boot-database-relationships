package io.datajek.databaserelationships.onetomany.bi;

import io.datajek.databaserelationships.onetomany.bi.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer>{

}