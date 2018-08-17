package my.education.serialization.util;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by bender on 06.08.2018.
 */
public class TestUtils {
    public static boolean simpleObjectMatcher(Object one, Object two, String... excluded){
        return EqualsBuilder.reflectionEquals(one, two, excluded);
    }
}