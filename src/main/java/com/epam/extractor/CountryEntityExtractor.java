package com.epam.extractor;

import com.epam.entity.CountryEntity;
import com.epam.form.CountryForm;

public class CountryEntityExtractor {
    public static CountryEntity extract(CountryForm countryForm) {
        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setName(countryForm.getName());
        countryEntity.setCapital(countryForm.getCapital());
        countryEntity.setCountOfPeople(countryForm.getCountOfPeople());
        countryEntity.setNameOfCurrency(countryForm.getNameOfCurrency());

        return countryEntity;
    }
}
