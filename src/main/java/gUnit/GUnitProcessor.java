package gUnit;

import utils.ReflectionHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GUnitProcessor {
   private static List<Method> before = new ArrayList<>(), after = new ArrayList<>(), tests = new ArrayList<>();
    public static <T> void run(Class<T> claz) {
        Method[] methods = claz.getDeclaredMethods();
        if (methods != null && methods.length != 0) {
            for (Method m : methods) {
                Annotation[] methodAnnotations = m.getDeclaredAnnotations();
                if (methodAnnotations != null && methodAnnotations.length != 0) {
                    for (Annotation a : methodAnnotations) {
                        if (annotations.Before.class.equals(a.annotationType())) {
                            before.add(m);
                            continue;
                        }
                        if (annotations.After.class.equals(a.annotationType())) {
                            after.add(m);
                            continue;
                        }
                        if (annotations.Test.class.equals(a.annotationType())) {
                            tests.add(m);
                        }
                    }
                }
            }
        }
        if (!tests.isEmpty()) {
            for (Method t : tests) {
                T instance = ReflectionHelper.createInstance(claz);
                for (Method b : before) {
                    try {
                        b.invoke(instance);
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    t.invoke(instance);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }

                for (Method a : after) {
                    try {
                        a.invoke(instance);
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}