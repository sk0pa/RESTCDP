package com.epam.form;

public class CountryForm {
    private String name;
    private String capital;
    private int countOfPeople;
    private String nameOfCurrency;

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

        CountryForm that = (CountryForm) o;

        if (countOfPeople != that.countOfPeople) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (nameOfCurrency != null ? !nameOfCurrency.equals(that.nameOfCurrency) : that.nameOfCurrency != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + countOfPeople;
        result = 31 * result + (nameOfCurrency != null ? nameOfCurrency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountryForm{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", countOfPeople=" + countOfPeople +
                ", nameOfCurrency='" + nameOfCurrency + '\'' +
                '}';
    }
}
