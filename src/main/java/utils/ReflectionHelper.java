package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by bender on 27.04.2018.
 */

public class ReflectionHelper {
    private ReflectionHelper() {
    }

    public static <T> T createInstance(Class<T> claz, Object... args) {
        T result = null;
        Constructor<?>[] constructors = claz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            if (args.length == c.getParameterCount()) {
                try {
                    result = (T) c.newInstance(args);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void methodInvoker(Method m, Object...args){

    }
}