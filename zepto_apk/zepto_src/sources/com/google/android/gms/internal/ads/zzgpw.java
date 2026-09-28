package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzgpw {

    /* renamed from: a, reason: collision with root package name */
    public final String f33059a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgpv f33060b;

    /* renamed from: c, reason: collision with root package name */
    public zzgpv f33061c;

    public zzgpw(String str) {
        zzgpv zzgpvVar = new zzgpv();
        this.f33060b = zzgpvVar;
        this.f33061c = zzgpvVar;
        this.f33059a = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f33059a);
        sb.append('{');
        zzgpv zzgpvVar = this.f33060b.f33058b;
        String str = "";
        while (zzgpvVar != null) {
            Object obj = zzgpvVar.f33057a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzgpvVar = zzgpvVar.f33058b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
