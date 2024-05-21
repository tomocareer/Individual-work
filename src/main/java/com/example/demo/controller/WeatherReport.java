
package com.example.demo.controller;
import java.time.LocalDateTime;

public class WeatherReport {
    private String publishingOffice;
    private LocalDateTime reportDatetime;
    private String targetArea;
    private String headlineText;
    private String text;

    // コンストラクタ
    public WeatherReport() {
    }

    // ゲッターとセッター
    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public LocalDateTime getReportDatetime() {
        return reportDatetime;
    }

    public void setReportDatetime(LocalDateTime reportDatetime) {
        this.reportDatetime = reportDatetime;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // toStringメソッド
    @Override
    public String toString() {
        return "WeatherReport{" +
                "publishingOffice='" + publishingOffice + '\'' +
                ", reportDatetime=" + reportDatetime +
                ", targetArea='" + targetArea + '\'' +
                ", headlineText='" + headlineText + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
