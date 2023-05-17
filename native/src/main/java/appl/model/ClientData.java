package appl.model;

public class ClientData {

    private final long valueLong;
    private final String valueString;
    private final boolean valueBool1;
    private final boolean valueBool2;

    public ClientData(long valueLong, String valueString, boolean valueBool1, boolean valueBool2) {
        this.valueLong = valueLong;
        this.valueString = valueString;
        this.valueBool1 = valueBool1;
        this.valueBool2 = valueBool2;
    }

    public long getValueLong() {
        return valueLong;
    }

    public String getValueString() {
        return valueString;
    }

    public boolean isValueBool1() {
        return valueBool1;
    }

    public boolean isValueBool2() {
        return valueBool2;
    }

    @Override
    public String toString() {
        return "ClientData{" +
                "valueLong=" + valueLong +
                ", valueString='" + valueString + '\'' +
                ", valueBool1=" + valueBool1 +
                ", valueBool2=" + valueBool2 +
                '}';
    }
}

