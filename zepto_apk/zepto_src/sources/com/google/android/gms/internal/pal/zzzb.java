package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzzb extends zzyy {

    /* renamed from: a, reason: collision with root package name */
    public final zzzr f38167a = new zzzr();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzzb) && ((zzzb) obj).f38167a.equals(this.f38167a);
        }
        return true;
    }

    public final zzyy g(String str) {
        return (zzyy) this.f38167a.get(str);
    }

    public final int hashCode() {
        return this.f38167a.hashCode();
    }
}
