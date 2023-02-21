package io.datajek.databaserelationships.onetomany.bi;

import io.datajek.databaserelationships.onetomany.bi.PlayerProfile;
import io.datajek.databaserelationships.onetomany.bi.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository repo;

    public List<io.datajek.databaserelationships.onetomany.bi.PlayerProfile> allPlayerProfiles() {
        return repo.findAll();
    }

    public io.datajek.databaserelationships.onetomany.bi.PlayerProfile getPlayerProfile(int id){
        return repo.findById(id).get();
    }

    public io.datajek.databaserelationships.onetomany.bi.PlayerProfile addPlayerProfile(io.datajek.databaserelationships.onetomany.bi.PlayerProfile profile) {
        profile.setId(0);
        //check if profile contains nested player
        if(profile.getPlayer()!=null) {
            profile.getPlayer().setPlayerProfile(profile);
        }
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {
        PlayerProfile tempPlayerProfile = repo.findById(id).get();
        tempPlayerProfile.getPlayer().setPlayerProfile(null);
        tempPlayerProfile.setPlayer(null);
        repo.save(tempPlayerProfile);
        repo.delete(tempPlayerProfile);
    }
}

