package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzil {

    /* renamed from: a, reason: collision with root package name */
    public final String f34923a;

    /* renamed from: b, reason: collision with root package name */
    public final zzv f34924b;

    /* renamed from: c, reason: collision with root package name */
    public final zzv f34925c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34926d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34927e;

    public zzil(String str, zzv zzvVar, zzv zzvVar2, int i2, int i3) {
        boolean z;
        if (i2 != 0) {
            z = false;
            if (i3 == 0) {
                i3 = 0;
                z = true;
            }
        } else {
            z = true;
        }
        zzgqa.a(z);
        zzgqa.a(true ^ TextUtils.isEmpty(str));
        this.f34923a = str;
        this.f34924b = zzvVar;
        zzvVar2.getClass();
        this.f34925c = zzvVar2;
        this.f34926d = i2;
        this.f34927e = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzil.class == obj.getClass()) {
            zzil zzilVar = (zzil) obj;
            if (this.f34926d == zzilVar.f34926d && this.f34927e == zzilVar.f34927e && this.f34923a.equals(zzilVar.f34923a) && this.f34924b.equals(zzilVar.f34924b) && this.f34925c.equals(zzilVar.f34925c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f34925c.hashCode() + ((this.f34924b.hashCode() + ((this.f34923a.hashCode() + ((((this.f34926d + 527) * 31) + this.f34927e) * 31)) * 31)) * 31);
    }
}
