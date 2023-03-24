package com.example.assignment01date.controller;

import com.example.assignment01date.model.RequestBodyModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/v1")
public class level1 {
    @GetMapping("/level1")
    public ResponseEntity<?> lession1(@RequestParam Long unixTime) {
        Instant instant = Instant.ofEpochSecond(unixTime);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        return ResponseEntity.ok(dateTime);
    }

    //    localhost:8080/api/v1/level1?unixTime=1679565970
    @GetMapping("/level2")
    public ResponseEntity<?> lession2(@RequestParam Long unixTime) {
        Instant instant = Instant.ofEpochSecond(unixTime);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime current = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        Long result = ChronoUnit.YEARS.between(dateTime, current);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/level3/header")
    public ResponseEntity<?> lession3RequestHeader(@RequestHeader Long unixTime) {
        Instant instant = Instant.ofEpochSecond(unixTime);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime current = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        Long resultYear = ChronoUnit.YEARS.between(dateTime, current);
        Long resultDate = ChronoUnit.DAYS.between(dateTime, current);
        return ResponseEntity.ok("số năm từ thời điểm input đến hiện tại: " + resultYear +
                "\nsố ngày từ thời điểm input đến hiện tại: " + resultDate);
    }
//localhost:8080/api/v1/level3/header
//    Headers: "Key: unixTime" : "Value:ví dụ:167956597"

    @GetMapping("/level3")
    public ResponseEntity<?> lession2RequestBody(@RequestBody RequestBodyModel model) {
        Instant instant = Instant.ofEpochSecond(model.getUnixTime());
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime current = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        Long resultYear = ChronoUnit.YEARS.between(dateTime, current);
        Long resultDate = ChronoUnit.DAYS.between(dateTime, current);
        return ResponseEntity.ok("số năm từ thời điểm input đến hiện tại: " + resultYear +
                "\nsố ngày từ thời điểm input đến hiện tại: " + resultDate);
    }

    @GetMapping("/level4")
    public ResponseEntity<?> lession4(@RequestParam String date) {
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        long years = ChronoUnit.YEARS.between(inputDate, currentDate);
        long days = ChronoUnit.DAYS.between(inputDate, currentDate);
        return ResponseEntity.ok("số năm từ thời điểm input đến hiện tại: " + years +
                "\nsố ngày từ thời điểm input đến hiện tại: " + days);
    }

    @GetMapping("/level5")
    public ResponseEntity<?> lession5(@RequestParam String date) {
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        long years = ChronoUnit.YEARS.between(inputDate, currentDate);
        long days = ChronoUnit.DAYS.between(inputDate, currentDate);
        return ResponseEntity.ok("số năm từ thời điểm input đến hiện tại: " + years +
                "\nsố ngày từ thời điểm input đến hiện tại: " + days);
    }

}
