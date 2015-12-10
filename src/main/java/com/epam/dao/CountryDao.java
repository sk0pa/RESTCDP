package com.epam.dao;

import com.epam.entity.CountryEntity;

import java.util.List;

public interface CountryDao {
    List<CountryEntity> findAllCountry();

    CountryEntity findByUuid(String uuid);

    void create(CountryEntity extract);

    void update(CountryEntity countryEntity);

    void delete(String uuid);
}
