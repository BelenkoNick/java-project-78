package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        addCheck("required", value -> value != null && !value.isEmpty());
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", value -> value.contains(substring));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> value.length() >= length);
        return this;
    }
}
