package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class zzhxn extends zzhxj {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f34471a;

    public zzhxn(Boolean bool) {
        this.f34471a = bool;
    }

    public static boolean j(zzhxn zzhxnVar) {
        Serializable serializable = zzhxnVar.f34471a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.android.gms.internal.ads.zzhxj
    public final String b() {
        Serializable serializable = this.f34471a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return g().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(serializable.getClass())));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzhxn.class != obj.getClass()) {
            return false;
        }
        zzhxn zzhxnVar = (zzhxn) obj;
        Serializable serializable = this.f34471a;
        Serializable serializable2 = zzhxnVar.f34471a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (j(this) && j(zzhxnVar)) {
            return ((serializable instanceof BigInteger) || (serializable2 instanceof BigInteger)) ? i().equals(zzhxnVar.i()) : g().longValue() == zzhxnVar.g().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        if ((serializable instanceof BigDecimal) && (serializable2 instanceof BigDecimal)) {
            return (serializable instanceof BigDecimal ? (BigDecimal) serializable : zzhyb.a(b())).compareTo(serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : zzhyb.a(zzhxnVar.b())) == 0;
        }
        double dDoubleValue = serializable instanceof Number ? g().doubleValue() : Double.parseDouble(b());
        double dDoubleValue2 = serializable2 instanceof Number ? zzhxnVar.g().doubleValue() : Double.parseDouble(zzhxnVar.b());
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final Number g() {
        Serializable serializable = this.f34471a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new zzhxs((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f34471a;
        if (serializable == null) {
            return 31;
        }
        if (j(this)) {
            jDoubleToLongBits = g().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(g().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final BigInteger i() {
        Serializable serializable = this.f34471a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (j(this)) {
            return BigInteger.valueOf(g().longValue());
        }
        String strB = b();
        zzhyb.b(strB);
        return new BigInteger(strB);
    }

    public zzhxn(Number number) {
        this.f34471a = number;
    }

    public zzhxn(String str) {
        this.f34471a = str;
    }
}
