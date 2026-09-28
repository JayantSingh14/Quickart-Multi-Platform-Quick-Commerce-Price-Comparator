package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f45257a;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f45257a = bool;
    }

    public static boolean o(JsonPrimitive jsonPrimitive) {
        Serializable serializable = jsonPrimitive.f45257a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.gson.JsonElement
    public final double b() {
        return this.f45257a instanceof Number ? m().doubleValue() : Double.parseDouble(n());
    }

    @Override // com.google.gson.JsonElement
    public final int d() {
        return this.f45257a instanceof Number ? m().intValue() : Integer.parseInt(n());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        Serializable serializable = this.f45257a;
        Serializable serializable2 = jsonPrimitive.f45257a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (o(this) && o(jsonPrimitive)) {
            return ((serializable instanceof BigInteger) || (serializable2 instanceof BigInteger)) ? j().equals(jsonPrimitive.j()) : m().longValue() == jsonPrimitive.m().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        if ((serializable instanceof BigDecimal) && (serializable2 instanceof BigDecimal)) {
            return (serializable instanceof BigDecimal ? (BigDecimal) serializable : NumberLimits.b(n())).compareTo(serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : NumberLimits.b(jsonPrimitive.n())) == 0;
        }
        double dB = b();
        double dB2 = jsonPrimitive.b();
        if (dB != dB2) {
            return Double.isNaN(dB) && Double.isNaN(dB2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f45257a;
        if (serializable == null) {
            return 31;
        }
        if (o(this)) {
            jDoubleToLongBits = m().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    @Override // com.google.gson.JsonElement
    public final long i() {
        return this.f45257a instanceof Number ? m().longValue() : Long.parseLong(n());
    }

    public final BigInteger j() {
        Serializable serializable = this.f45257a;
        return serializable instanceof BigInteger ? (BigInteger) serializable : o(this) ? BigInteger.valueOf(m().longValue()) : NumberLimits.c(n());
    }

    public final boolean k() {
        Serializable serializable = this.f45257a;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(n());
    }

    public final Number m() {
        Serializable serializable = this.f45257a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String n() {
        Serializable serializable = this.f45257a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return m().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.f45257a = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.f45257a = str;
    }
}
