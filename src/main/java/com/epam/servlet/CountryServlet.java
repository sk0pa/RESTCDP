package com.epam.servlet;

import com.epam.dao.CountryDao;
import com.epam.dao.impl.inmemory.CountryDaoImpl;
import com.epam.entity.CountryEntity;
import com.epam.extractor.CountryEntityExtractor;
import com.epam.form.CountryForm;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/country")
@Singleton
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class CountryServlet extends CountryEntity {
    private CountryDao countryDao;

    public CountryServlet() {
        countryDao = new CountryDaoImpl();
    }

    @GET
    public List<CountryEntity> getCountry() {
        return countryDao.findAllCountry();
    }

    @GET
    @Path("{uuid}")
    public CountryEntity getCountryByUuid(@PathParam("uuid") String uuid) {
        return countryDao.findByUuid(uuid);
    }

    @POST
    public void create(CountryForm countryForm) {
        countryDao.create(CountryEntityExtractor.extract(countryForm));
    }

    @PUT
    public void update(CountryEntity countryEntity) {
        countryDao.update(countryEntity);
    }

    @DELETE
    @Path("{uuid}")
    public void delete(@PathParam("uuid") String uuid) {
        countryDao.delete(uuid);
    }
}
