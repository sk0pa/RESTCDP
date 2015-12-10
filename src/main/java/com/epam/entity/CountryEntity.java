package com.epam.entity;

public class CountryEntity {
    private String uuid;
    private String name;
    private String capital;
    private int countOfPeople;
    private String nameOfCurrency;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public String getNameOfCurrency() {
        return nameOfCurrency;
    }

    public void setNameOfCurrency(String nameOfCurrency) {
        this.nameOfCurrency = nameOfCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (countOfPeople != that.countOfPeople) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        return !(nameOfCurrency != null ? !nameOfCurrency.equals(that.nameOfCurrency) : that.nameOfCurrency != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + countOfPeople;
        result = 31 * result + (nameOfCurrency != null ? nameOfCurrency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", countOfPeople=" + countOfPeople +
                ", nameOfCurrency='" + nameOfCurrency + '\'' +
                '}';
    }
}
