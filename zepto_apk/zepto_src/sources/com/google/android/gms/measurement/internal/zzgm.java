package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzgm {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f38934b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f38935c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f38936d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final zzgl f38937a;

    public zzgm(zzgl zzglVar) {
        this.f38937a = zzglVar;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (Objects.equals(str, strArr[i2])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i2];
                        if (str2 == null) {
                            str2 = strArr2[i2] + "(" + strArr[i2] + ")";
                            strArr3[i2] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f38937a.zza() ? str : g(str, zzjl.f39203c, zzjl.f39201a, f38934b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f38937a.zza() ? str : g(str, zzjm.f39206b, zzjm.f39205a, f38935c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.f38937a.zza() ? str : str.startsWith("_exp_") ? b.D("experiment_id(", str, ")") : g(str, zzjn.f39210b, zzjn.f39209a, f38936d);
    }

    public final String d(zzbg zzbgVar) {
        zzjq zzjqVar = (zzjq) this.f38937a;
        if (!zzjqVar.zza()) {
            return zzbgVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzbgVar.f38771c);
        sb.append(",name=");
        sb.append(a(zzbgVar.f38769a));
        sb.append(",params=");
        zzbe zzbeVar = zzbgVar.f38770b;
        sb.append(zzbeVar == null ? null : !zzjqVar.zza() ? zzbeVar.f38768a.toString() : e(zzbeVar.A()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f38937a.zza()) {
            return bundle.toString();
        }
        StringBuilder sbW = b.w("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbW.length() != 8) {
                sbW.append(", ");
            }
            sbW.append(b(str));
            sbW.append("=");
            Object obj = bundle.get(str);
            sbW.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbW.append("}]");
        return sbW.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbW = b.w("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sbW.length() != 1) {
                    sbW.append(", ");
                }
                sbW.append(strE);
            }
        }
        sbW.append("]");
        return sbW.toString();
    }
}
