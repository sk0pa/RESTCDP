package com.epam.dao.impl.inmemory;

import com.epam.dao.CountryDao;
import com.epam.entity.CountryEntity;
import com.epam.exception.CountryNotFound;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class CountryDaoImpl implements CountryDao {
    private List<CountryEntity> countryEntities;

    public CountryDaoImpl() {
        countryEntities = new CopyOnWriteArrayList<CountryEntity>();
    }

    public CountryDaoImpl(List<CountryEntity> countryEntities) {
        this.countryEntities = countryEntities;
    }

    public List<CountryEntity> findAllCountry() {
        return countryEntities;
    }

    public CountryEntity findByUuid(String uuid) {
        for (CountryEntity countryEntity : countryEntities) {
            if(countryEntity.getUuid().equals(uuid)) {
                return countryEntity;
            }
        }

        return null;
    }

    public void create(CountryEntity extract) {
        extract.setUuid(UUID.randomUUID().toString());

        countryEntities.add(extract);
    }

    public void update(CountryEntity countryEntity) {
        CountryEntity target = findByUuid(countryEntity.getUuid().toString());

        if(target == null) {
            throw new CountryNotFound("Country not found!");
        }

        target.setCountOfPeople(countryEntity.getCountOfPeople());
    }

    public void delete(String uuid) {
        for (int i = 0; i < countryEntities.size(); i++) {
            CountryEntity countryEntity = countryEntities.get(i);
            if(countryEntity.getUuid().equals(uuid)) {
                countryEntities.remove(i);
                return;
            }
        }

        throw new CountryNotFound("Country not found!");
    }
}
