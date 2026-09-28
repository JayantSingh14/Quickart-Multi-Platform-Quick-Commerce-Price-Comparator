package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Objects;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class zzaz {

    /* renamed from: f, reason: collision with root package name */
    public static final zzaz f38739f = new zzaz(100, (String) null, (Boolean) null, (Boolean) null);

    /* renamed from: a, reason: collision with root package name */
    public final int f38740a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38741b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f38742c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38743d;

    /* renamed from: e, reason: collision with root package name */
    public final EnumMap f38744e;

    public zzaz(int i2, String str, Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.f38744e = enumMap;
        enumMap.put((EnumMap) zzjj.AD_USER_DATA, (zzjj) (bool == null ? zzjh.UNINITIALIZED : bool.booleanValue() ? zzjh.GRANTED : zzjh.DENIED));
        this.f38740a = i2;
        this.f38741b = d();
        this.f38742c = bool2;
        this.f38743d = str;
    }

    public static zzaz b(String str) {
        if (str == null || str.length() <= 0) {
            return f38739f;
        }
        String[] strArrSplit = str.split(":");
        int i2 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zzjjVarArr = zzji.DMA.f39191a;
        int length = zzjjVarArr.length;
        int i3 = 1;
        int i4 = 0;
        while (i4 < length) {
            enumMap.put((EnumMap) zzjjVarArr[i4], (zzjj) zzjk.e(strArrSplit[i3].charAt(0)));
            i4++;
            i3++;
        }
        return new zzaz(enumMap, i2, (Boolean) null, (String) null);
    }

    public static zzaz c(int i2, Bundle bundle) {
        if (bundle == null) {
            return new zzaz(i2, (String) null, (Boolean) null, (Boolean) null);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.DMA.f39191a) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzjk.d(bundle.getString(zzjjVar.f39197a)));
        }
        return new zzaz(enumMap, i2, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final zzjh a() {
        zzjh zzjhVar = (zzjh) this.f38744e.get(zzjj.AD_USER_DATA);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f38740a);
        for (zzjj zzjjVar : zzji.DMA.f39191a) {
            sb.append(":");
            sb.append(zzjk.h((zzjh) this.f38744e.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaz)) {
            return false;
        }
        zzaz zzazVar = (zzaz) obj;
        if (this.f38741b.equalsIgnoreCase(zzazVar.f38741b) && Objects.equals(this.f38742c, zzazVar.f38742c)) {
            return Objects.equals(this.f38743d, zzazVar.f38743d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f38742c;
        int i2 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f38743d;
        return ((str == null ? 17 : str.hashCode()) * WKSRecord.Service.NETBIOS_NS) + this.f38741b.hashCode() + (i2 * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjk.a(this.f38740a));
        for (zzjj zzjjVar : zzji.DMA.f39191a) {
            sb.append(",");
            sb.append(zzjjVar.f39197a);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.f38744e.get(zzjjVar);
            if (zzjhVar == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = zzjhVar.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f38742c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f38743d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public zzaz(EnumMap enumMap, int i2, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.f38744e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f38740a = i2;
        this.f38741b = d();
        this.f38742c = bool;
        this.f38743d = str;
    }
}
