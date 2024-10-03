package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new HashMap<>();

    protected void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    public boolean isValid(T value) {
        for (Predicate<T> validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
