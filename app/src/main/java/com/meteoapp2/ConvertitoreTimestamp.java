package com.meteoapp2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ConvertitoreTimestamp {
    public void main(String[] args) {
        long sunriseTimestamp = 1708412767;
        long sunsetTimestamp = 1708449769;

        LocalDateTime sunriseDateTime = fromUnixTime(sunriseTimestamp);
        LocalDateTime sunsetDateTime = fromUnixTime(sunsetTimestamp);

        System.out.println("Alba: " + sunriseDateTime);
        System.out.println("Tramonto: " + sunsetDateTime);
    }

    public LocalDateTime fromUnixTime(long unixTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneOffset.UTC);
    }
}
