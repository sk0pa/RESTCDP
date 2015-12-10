package com.epam.step;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RequestSteps {

  private final String USER_AGENT = "Mozilla/5.0";

  public String doPost(String url, int expResponceCode, String name, String capital, int count, String currency) {
    StringBuffer response;
    HttpURLConnection con;
    try {
      URL obj = new URL(url);
      if (url.contains("https")) {
        con = (HttpsURLConnection) obj.openConnection();
      } else {
        con = (HttpURLConnection) obj.openConnection();
      }
      con.setDoOutput(true);
      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
      con.setRequestProperty("User-Agent", USER_AGENT);

      byte[] outputBytes = ("{\"name\":\"" + name + "\","
                            + "\"capital\":\"" + capital + "\","
                            + "\"countOfPeople\":\"" + count + "\","
                            + "\"nameOfCurrency\":\"" + currency + "\"}").getBytes("UTF-8");
      OutputStream os = con.getOutputStream();
      os.write(outputBytes);
      os.close();

      int responseCode = con.getResponseCode();
      System.out.println(responseCode);
      Assert.assertEquals(responseCode, expResponceCode, "Request was performed successfully");

      response = readConnection(con);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return response.toString();

  }

  public String doGetAll(String url, int expResponceCode) {

    StringBuffer response;
    HttpURLConnection con;
    try {
      URL obj = new URL(url);
      if (url.contains("https")) {
        con = (HttpsURLConnection) obj.openConnection();
      } else {
        con = (HttpURLConnection) obj.openConnection();
      }
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", USER_AGENT);

      int responseCode = con.getResponseCode();
      Assert.assertTrue(responseCode == expResponceCode, "Request was performed successfully");

      response = readConnection(con);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return response.toString();
  }

  public String doGet(String url, int expResponceCode, String id) {
    StringBuffer response;
    HttpURLConnection con;
    try {
      URL obj = new URL(url + "/" + id);
      if (url.contains("https")) {
        con = (HttpsURLConnection) obj.openConnection();
      } else {
        con = (HttpURLConnection) obj.openConnection();
      }
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", USER_AGENT);
      int responseCode = con.getResponseCode();
      Assert.assertEquals(responseCode, expResponceCode, "Request was performed successfully");

      response = readConnection(con);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return response.toString();
  }

  public String doPut(String url, int expResponceCode, String id, String name, String capital, int count, String currency) {
    StringBuffer response;
    HttpURLConnection con;
    try {
      URL obj = new URL(url);
      if (url.contains("https")) {
        con = (HttpsURLConnection) obj.openConnection();
      } else {
        con = (HttpURLConnection) obj.openConnection();
      }
      con.setDoOutput(true);
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept", "application/json");
      con.setRequestMethod("PUT");
      con.connect();

      byte[] outputBytes = ("{\"uuid\":\"" + id + "\","
                            + "\"name\":\"" + name + "\","
                            + "\"capital\":\"" + capital + "\","
                            + "\"countOfPeople\":\"" + count + "\","
                            + "\"nameOfCurrency\":\"" + currency + "\"}").getBytes("UTF-8");
      OutputStream os = con.getOutputStream();
      os.write(outputBytes);
      os.close();
      int responseCode = con.getResponseCode();
      Assert.assertEquals(responseCode, expResponceCode, "Request was performed successfully");

      response = readConnection(con);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return response.toString();
  }

  public String doDelete(String url, int expResponceCode, String id) {
    StringBuffer response;
    HttpURLConnection con;
    try {
      URL obj = new URL(url + "/" + id);
      if (url.contains("https")) {
        con = (HttpsURLConnection) obj.openConnection();
      } else {
        con = (HttpURLConnection) obj.openConnection();
      }
      con.setRequestMethod("DELETE");
      con.setRequestProperty("User-Agent", USER_AGENT);
      int responseCode = con.getResponseCode();
      Assert.assertEquals(responseCode, expResponceCode, "Request was performed successfully");

      response = readConnection(con);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return response.toString();
  }

  public String getId(String response, String countryName) {
    try {
      JSONParser parser = new JSONParser();
      Object countriesObject = parser.parse(response);
      JSONArray countries = (JSONArray) countriesObject;
      for (Object contry : countries) {
        JSONObject jsonContry = (JSONObject) contry;
        if (jsonContry.get("name").equals(countryName)) {
          return jsonContry.get("uuid").toString();
        }
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getCount(String response) {
    try {
      JSONParser parser = new JSONParser();
      Object countryObject = parser.parse(response);
      JSONObject jsonContry = (JSONObject) countryObject;
      return jsonContry.get("countOfPeople").toString();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void checkNewCount(String response, int count) {
    int newCount = Integer.valueOf(getCount(response));
    Assert.assertEquals(newCount, count, "Country has expected count of people");
  }
  private StringBuffer readConnection(HttpURLConnection con) throws IOException {
    StringBuffer response = null;
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      return response;
    } catch (FileNotFoundException e) {
      return response;
    }
  }
}
