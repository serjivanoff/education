package serialization;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.util.*;

/**
 * TODO toList() method add checks for all primitive types (for now only some of them, just to check that it works at all)
 */

public class JsonSerializer {
    public String toJson(Object object) throws IllegalAccessException {
        return toJsonBuilder(object).build().toString();
    }

    private JsonObjectBuilder toJsonBuilder(Object object) throws IllegalAccessException {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        Class<?> klass = object.getClass();
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(klass.getDeclaredFields()));

        Class<?> superClass = klass.getSuperclass();
        if (!"Object".equals(superClass.getSimpleName())) {
            fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
        }
        for (Field f : fields) {
            f.setAccessible(true);
            if (isLeafOfTree(f)) {
                builder.add(f.getName(), f.get(object).toString());
            } else if (isArrayOrCollection(f)) {
                JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
                Collection collection = castToCollection(f, object);
                for (Object o : collection) {
                    if (isLeafOfTree(o.getClass())) {
                        if (o instanceof Integer) {
                            arrayBuilder.add(((int) o));
                        } else if (o instanceof Double) {
                            arrayBuilder.add(((double) o));
                        } else if (o instanceof Long) {
                            arrayBuilder.add((long) o);
                        } else if (o instanceof Boolean) {
                            arrayBuilder.add((boolean) o);
                        } else if (o instanceof Character) {
                            arrayBuilder.add((char) o);
                        } else if (o instanceof Byte) {
                            arrayBuilder.add((byte) o);
                        } else if (o instanceof Float) {
                            arrayBuilder.add((float) o);
                        }
                        else if (o instanceof Short) {
                            arrayBuilder.add((short) o);
                        }
                    } else {
                        arrayBuilder.add(toJsonBuilder(o));
                    }
                }
                builder.add(f.getName(), arrayBuilder);
            } else {
                builder.add(f.getName(), toJsonBuilder(f.get(object)));
            }
            f.setAccessible(false);
        }
        return builder;
    }

    private boolean isLeafOfTree(Class claz) {
        String name = claz.getSimpleName().toLowerCase();
        return name.equals("int") || name.equals("integer")
                || name.equals("long") || name.equals("char")
                || name.equals("character") || name.equals("double")
                || name.equals("float") || name.equals("byte") || name.equals("boolean")||name.equals("short");
    }

    private Collection castToCollection(Field f, Object o) throws IllegalAccessException {
        String type = f.getType().getSimpleName().toLowerCase();
        if (type.contains("collection")) {
            return (Collection) f.get(o);
        } else if (type.contains("[]"))
            return toList(f.get(o));
        else return Collections.emptyList();
    }

    private List toList(Object o) {
        List result = new ArrayList();
        if (o instanceof int[]) {
            for (int i : (int[]) o) {
                result.add(i);
            }
        } else if (o instanceof double[]) {
            for (double d : (double[]) o) {
                result.add(d);
            }
        } else {
            for (Object obj : (Object[]) o) {
                result.add(obj);
            }
        }
        return result;
    }

    private boolean isLeafOfTree(Field f) {
        if (f == null) return false;
        String type = f.getType().getSimpleName().toLowerCase();
        return type.equals("int") || type.equals("integer")
                || type.equals("boolean") || type.equals("string") || type.equals("byte")
                || type.equals("char") || type.equals("double")
                || type.equals("float") || type.equals("long");
    }

    private boolean isArrayOrCollection(Field f) {
        if (f == null) return false;
        String type = f.getType().getSimpleName().toLowerCase();
        return type.contains("list") || type.contains("[]") || type.contains("collection")
                || type.contains("tree") || type.contains("set");
    }
}
