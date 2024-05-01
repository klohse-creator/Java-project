package edu.wgu.d387_sample_code.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/timezone")
@CrossOrigin
public class TimeZoneController {



    @GetMapping("/livepresentation")
    public ResponseEntity<List<String>> getLivePresentationTimes() {
        List<String> presentationTimes = new ArrayList<String>();

        try {

            ZonedDateTime startTimeEst = ZonedDateTime.of(LocalDateTime.of(2024,6,14, 13,0),ZoneId.of("America/New_York"));
            ZonedDateTime startTimeMT = startTimeEst.withZoneSameInstant(ZoneId.of("America/Denver"));
            ZonedDateTime startTimeUTC = startTimeEst.withZoneSameInstant(ZoneId.of("UTC"));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a z MM-dd-yyyy");
            presentationTimes.add(startTimeEst.format(dtf));
            presentationTimes.add(startTimeMT.format(dtf));
            presentationTimes.add(startTimeUTC.format(dtf));

        } catch (Exception e) {

            presentationTimes.add(e.toString());
        }

        return ResponseEntity.ok(presentationTimes);
    }
}
