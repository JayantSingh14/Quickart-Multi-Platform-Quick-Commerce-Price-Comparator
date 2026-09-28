package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhxl extends zzhxj {

    /* renamed from: a, reason: collision with root package name */
    public final zzhya f34470a = new zzhya(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzhxl) && ((zzhxl) obj).f34470a.equals(this.f34470a);
        }
        return true;
    }

    public final zzhxj g(String str) {
        return (zzhxj) this.f34470a.get(str);
    }

    public final int hashCode() {
        return this.f34470a.hashCode();
    }
}
