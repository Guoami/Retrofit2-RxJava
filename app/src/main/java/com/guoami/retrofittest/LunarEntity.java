package com.guoami.retrofittest;

public class LunarEntity {
  private Data data;

  public class Data {
    private String year;
    private String month;
    private String day;

    private String lunarYear;
    private String lunarMonth;
    private String lunarDay;
    private String cyclicalYear;
    private String cyclicalMonth;
    private String cyclicalDay;

    public void setYear(String year) {
      this.year = year;
    }

    public void setMonth(String month) {
      this.month = month;
    }

    public void setDay(String day) {
      this.day = day;
    }

    public String getLunarYear() {
      return lunarYear;
    }

    public String getLunarMonth() {
      return lunarMonth;
    }

    public String getLunarDay() {
      return lunarDay;
    }

    public String getCyclicalYear() {
      return cyclicalYear;
    }

    public String getCyclicalMonth() {
      return cyclicalMonth;
    }

    public String getCyclicalDay() {
      return cyclicalDay;
    }
  }

  public void setData(Data data) {
    this.data = data;
  }

  public Data getData() {
    return this.data;
  }
}
