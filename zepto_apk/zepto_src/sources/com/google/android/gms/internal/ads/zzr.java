package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* loaded from: classes4.dex */
public final class zzr {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f35419a = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    public boolean f35420b;

    public final void a(int i2) {
        zzgqa.f(!this.f35420b);
        this.f35419a.append(i2, true);
    }

    public final zzs b() {
        zzgqa.f(!this.f35420b);
        this.f35420b = true;
        return new zzs(this.f35419a);
    }
}
