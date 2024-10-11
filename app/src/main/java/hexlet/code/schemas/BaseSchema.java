package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean required = false;

    /***
     * Метод добавялет новую проверку в схему.
     *
     * @param name наименование проверки
     * @param validate проверка
     */
    protected void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    /***
     * Метод проверяет параметр на валидность.
     *
     * @param value проверяемое значение
     * @return флга успешности проверки
     */
    public boolean isValid(T value) {
        if (!required) {
            var validate = checks.get("required");
            if (!validate.test(value)) {
                return true;
            }
        }

        for (Predicate<T> validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }
        return true;
    }
}
