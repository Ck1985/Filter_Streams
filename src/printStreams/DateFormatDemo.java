package printStreams;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.printf("two digit hour on 24-hour clock %tH/%TH \n", now, now);
        System.out.printf("two digit hour on 12-hour clock %tI/%TI \n", now, now);
        System.out.printf("one or two digit hour on 24-hour clock %tk/%Tk \n ", now, now);
        System.out.printf("one or two digit hour on 13-hour clock %tl/%Tl \n", now, now);
        System.out.printf("two digit minute from 00 to 59: %tM/%TM \n", now, now);
        System.out.printf("two digit second from 00 to 60: %tS/%TS \n ", now, now);
        System.out.printf("milisecond %tL/%TL\n", now, now);
        System.out.printf("nanosecond %tN/%TN\n",now,now);
        System.out.printf("locale-specifier morning / afternoon indicator %tp/%Tp\n", now, now);
        System.out.printf("RFC 822 numeric time zone indicator: %tz/%Tz\n", now, now);
        System.out.printf("Time zone abbreviation %tZ/%TZ\n", now, now);
        System.out.printf("second form epoch %ts/%Ts", now, now);
        System.out.printf("milisecond from epoch %tQ\n", now);
        System.out.printf("localized month name: %tB/%TB", now, now);
        System.out.printf("localgized abbreviated month name %tb/%Tb\n",now,now);
        System.out.printf("localized abbreviated month name %th/%Th\n",now,now);
        System.out.printf("localized day name %tA/%TA\n",now,now);
        System.out.printf("localized abbreviated day %ta/%Ta\n",now,now);
        System.out.printf("two digit century %tc/%tC\n", now, now);
        System.out.printf("Four digit year %tY/%TY\n", now, now);
        System.out.printf("Two digit year %ty/%Ty\n", now, now);
        System.out.printf("Three digit day of year %tj/%Tj\n", now, now);
        System.out.printf("Two digit month %tm/%Tm\n", now, now);
        System.out.printf("Two digit day of month %td/%Td\n", now, now);
        System.out.printf("one or two digit day of month %te/%Te\n", now, now);
        System.out.printf("hour and minute on 24 hour clock %tR/%TR\n", now, now);
        System.out.printf("Hour minute and second on 24 hour clock %tT/%TT\n", now, now);
        System.out.printf("Hour minute and second on 12 hour clock %tr/%Tr\n", now, now);
        System.out.printf("month - day - year: %tD/%TD\n", now, now);
        System.out.printf("ISO 8601 Standard date %tF/%TF\n", now, now);
        System.out.printf("Unix date format %tc/%tC", now, now);
    }
}
