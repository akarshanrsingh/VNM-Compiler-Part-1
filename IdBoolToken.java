public class IdBoolToken extends Token {

    private String value;

    public IdBoolToken(int kind, String image) {
        super(kind, image);
        this.value = image;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}