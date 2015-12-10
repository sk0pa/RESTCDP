package com.epam.test;

import com.epam.step.RequestSteps;

import org.testng.annotations.Test;

public class RequestTest {

  public static final String URL = "http://localhost:8080/country";
  public static final int SUCCESS_CODE = 200;
  public static final int SUCCESS_CODE_NO_CONTENT = 204;
  public static final String COUNTRY_NAME = "Ukraine";
  public static final String COUNTRY_CAPITAL = "Kyiv";
  public static final String COUNTRY_CURRENCY = "UA";
  public static final Integer INITIAL_COUNT = 5000;
  public static final Integer LATER_COUNT = 10000;
  public String id;
  RequestSteps request = new RequestSteps();

  @Test(priority = 0)
  public void checkPost() {
    request.doPost(URL, SUCCESS_CODE_NO_CONTENT, COUNTRY_NAME, COUNTRY_CAPITAL, INITIAL_COUNT, COUNTRY_CURRENCY);
  }

  @Test(priority = 1)
  public void checkGet() {
    String response = request.doGetAll(URL, SUCCESS_CODE);
    id = request.getId(response, COUNTRY_NAME);
    request.doGet(URL, SUCCESS_CODE, id);
  }

  @Test(priority = 2)
  public void checkPut() {
    request.doPut(URL, SUCCESS_CODE_NO_CONTENT, id, COUNTRY_NAME, COUNTRY_CAPITAL, LATER_COUNT, COUNTRY_CURRENCY);
    String response = request.doGet(URL, SUCCESS_CODE, id);
    request.checkNewCount(response, LATER_COUNT);
  }

  @Test(priority = 3)
  public void checkDelete() {
    request.doDelete(URL, SUCCESS_CODE_NO_CONTENT, id);
    request.doGet(URL, SUCCESS_CODE_NO_CONTENT, id);
  }
}
