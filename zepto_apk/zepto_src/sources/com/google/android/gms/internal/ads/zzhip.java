package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhip {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhip f33865b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f33866a;

    static {
        zzhio zzhioVar = new zzhio();
        HashMap map = zzhioVar.f33864a;
        if (map == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzhip zzhipVar = new zzhip(Collections.unmodifiableMap(map));
        zzhioVar.f33864a = null;
        f33865b = zzhipVar;
    }

    public /* synthetic */ zzhip(Map map) {
        this.f33866a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhip) {
            return this.f33866a.equals(((zzhip) obj).f33866a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f33866a.hashCode();
    }

    public final String toString() {
        return this.f33866a.toString();
    }
}
