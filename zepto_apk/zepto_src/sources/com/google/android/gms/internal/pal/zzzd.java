package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class zzzd extends zzyy {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f38168a;

    public zzzd(zzzj zzzjVar) {
        this.f38168a = zzzjVar;
    }

    public static boolean i(zzzd zzzdVar) {
        Serializable serializable = zzzdVar.f38168a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.android.gms.internal.pal.zzyy
    public final int b() {
        return this.f38168a instanceof Number ? g().intValue() : Integer.parseInt(d());
    }

    @Override // com.google.android.gms.internal.pal.zzyy
    public final String d() {
        Serializable serializable = this.f38168a;
        return !(serializable instanceof Number) ? serializable instanceof Boolean ? ((Boolean) serializable).toString() : (String) serializable : g().toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzzd.class != obj.getClass()) {
            return false;
        }
        zzzd zzzdVar = (zzzd) obj;
        if (i(this) && i(zzzdVar)) {
            return g().longValue() == zzzdVar.g().longValue();
        }
        Serializable serializable = this.f38168a;
        boolean z = serializable instanceof Number;
        Serializable serializable2 = zzzdVar.f38168a;
        if (!z || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        double dDoubleValue = g().doubleValue();
        double dDoubleValue2 = zzzdVar.g().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final Number g() {
        Serializable serializable = this.f38168a;
        return serializable instanceof String ? new zzzj((String) serializable) : (Number) serializable;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        if (i(this)) {
            jDoubleToLongBits = g().longValue();
        } else {
            Serializable serializable = this.f38168a;
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(g().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public zzzd(Boolean bool) {
        this.f38168a = bool;
    }

    public zzzd(String str) {
        str.getClass();
        this.f38168a = str;
    }
}
