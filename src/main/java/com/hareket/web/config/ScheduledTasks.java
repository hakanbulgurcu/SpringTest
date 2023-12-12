package com.hareket.web.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
0       0       *       *       *       * = the top of every hour of every day.
10      *       *       *       *       * = every ten seconds.
0/10    *       *       *       *       * = every ten seconds.
0       0       8-10    *       *       * = 8, 9 and 10 o'clock of every day.
0       0       8,10    *       *       * = 8 and 10 o'clock of every day.
0       0/30    8-10    *       *       * = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
0       0       9-17    *       *       MON-FRI = on the hour nine-to-five weekdays
0       0       0       25      12      ? = every Christmas Day at midnight
0       0       12      *       *       ? = at 12:00 PM (noon) every day
0       15      10      ?       *       * = at 10:15 AM every day
0       15      10      *       *       ? = at 10:15 AM every day
0       *       14      *       *       ? = every minute starting at 2:00 PM and ending at 2:59 PM, every day
0       0/5     14      *       *       ? = every 5 minutes starting at 2:00 PM and ending at 2:55 PM, every day
0       0/5     14,18   *       *       ? = every 5 minutes starting at 2:00 PM and ending at 2:55 PM, AND fire every 5 minutes starting at 6:00 PM and ending at 6:55 PM, every day
0       0-5     14      *       *       ? = every minute starting at 2:00 PM and ending at 2:05 PM, every day
0       10,44   14      ?       3       WED	= at 2:10 PM and at 2:44 PM every Wednesday in the month of March
0       15      10      ?       *       MON-FRI	= at 10:15 AM every Monday, Tuesday, Wednesday, Thursday and Friday
0       15      10      15      *       ? = at 10:15 AM on the 15th day of every month
0       15      10      L       *       ? = at 10:15 AM on the last day of every month
0       15      10      ?       *       6L = at 10:15 AM on the last Friday of every month
0       15      10      ?       *       6L      2002-2005 = at 10:15 AM on every last friday of every month during the years 2002, 2003, 2004, and 2005
0       15      10      ?       *       6#3 = at 10:15 AM on the third Friday of every month
0       0       12      1/5     *       ? = at 12 PM (noon) every 5 days every month, starting on the first day of the month
0       11      11      11      11      ? = every November 11 at 11:11 AM

 Cron expression is represented by six fields:
 @Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week]")
 */

@Component
public class ScheduledTasks {
    private final Log log = LogFactory.getLog(this.getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 0/1 * * * *")
    public void reportCurrentTime() {
        log.info ("The time is now : " +  dateFormat.format(new Date ()));
    }
}