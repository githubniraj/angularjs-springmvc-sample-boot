package com.hantsylabs.restexample.springmvc.test.slice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author hantsy
 */
@RunWith(SpringRunner.class)
@JsonTest()
public class LocalDateTimeJsonComponentTest {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LocalDateTimeJsonComponentTest.class);
    @Inject
    JacksonTester<TimeObj> tester;

    @Inject
    Jackson2ObjectMapperBuilder mapper;

    @Test
    public void testJsonWithJacksonTester() throws Exception {

        assertNotNull(tester);

        String dateTimeStirng = "2016-03-29T20:05:01.101Z";
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.parse(dateTimeStirng), ZoneId.systemDefault());
        TimeObj obj = new TimeObj(dateTime);

        assertThat(tester.write(obj).getJson()).containsIgnoringCase("{\"now\":\"2016-03-29T20:05:01.101Z\"}");

        TimeObj parsedDateTime = tester.parseObject("{\"now\":\"2016-03-29T20:05:01.101Z\"}");
        log.debug("parsed Date time @" + parsedDateTime);

        assertTrue(dateTime.equals(parsedDateTime.getNow()));
    }

    @Test
    public void testJson() throws Exception {

        assertNotNull(mapper);
        LocalDateTime dateTime = LocalDateTime.now();
        Map test = new HashMap();
        test.put("now", dateTime);

        String formattedDTString = mapper.build().writeValueAsString(test);
        log.debug("formated datetime @" + formattedDTString);

        TimeObj parsedDateTimeMap = mapper.build().readValue("{\"now\":\"2016-03-29T20:05:01.101Z\"}", TimeObj.class);
        log.debug("parsed Date time @" + parsedDateTimeMap);
    }

    static class TimeObj {

        private LocalDateTime now;

        @java.beans.ConstructorProperties({"now"})
        public TimeObj(LocalDateTime now) {
            this.now = now;
        }

        public TimeObj() {
        }

        public LocalDateTime getNow() {
            return this.now;
        }

        public void setNow(LocalDateTime now) {
            this.now = now;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof TimeObj)) return false;
            final TimeObj other = (TimeObj) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$now = this.getNow();
            final Object other$now = other.getNow();
            if (this$now == null ? other$now != null : !this$now.equals(other$now)) return false;
            return true;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $now = this.getNow();
            result = result * PRIME + ($now == null ? 43 : $now.hashCode());
            return result;
        }

        protected boolean canEqual(Object other) {
            return other instanceof TimeObj;
        }

        public String toString() {
            return "com.hantsylabs.restexample.springmvc.test.slice.LocalDateTimeJsonComponentTest.TimeObj(now=" + this.getNow() + ")";
        }
    }

}
