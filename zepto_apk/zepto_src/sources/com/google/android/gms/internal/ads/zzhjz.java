package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhjz implements zzhke {

    /* renamed from: a, reason: collision with root package name */
    public final String f33909a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhxc f33910b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhzl f33911c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhoz f33912d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhpw f33913e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f33914f;

    public zzhjz(String str, zzhxc zzhxcVar, zzhzl zzhzlVar, zzhoz zzhozVar, zzhpw zzhpwVar, Integer num) {
        this.f33909a = str;
        this.f33910b = zzhxcVar;
        this.f33911c = zzhzlVar;
        this.f33912d = zzhozVar;
        this.f33913e = zzhpwVar;
        this.f33914f = num;
    }

    public static zzhjz a(String str, zzhzl zzhzlVar, zzhoz zzhozVar, zzhpw zzhpwVar, Integer num) throws GeneralSecurityException {
        if (zzhpwVar == zzhpw.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzhjz(str, zzhkl.b(str), zzhzlVar, zzhozVar, zzhpwVar, num);
    }
}
