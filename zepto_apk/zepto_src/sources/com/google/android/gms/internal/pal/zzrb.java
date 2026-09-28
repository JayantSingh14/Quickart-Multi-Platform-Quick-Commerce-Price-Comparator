package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzrb {

    /* renamed from: b, reason: collision with root package name */
    public static final zzrb f38039b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f38040a;

    static {
        zzqz zzqzVar = new zzqz();
        HashMap map = zzqzVar.f38038a;
        if (map == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzrb zzrbVar = new zzrb(Collections.unmodifiableMap(map));
        zzqzVar.f38038a = null;
        f38039b = zzrbVar;
    }

    public /* synthetic */ zzrb(Map map) {
        this.f38040a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrb) {
            return this.f38040a.equals(((zzrb) obj).f38040a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f38040a.hashCode();
    }

    public final String toString() {
        return this.f38040a.toString();
    }
}
