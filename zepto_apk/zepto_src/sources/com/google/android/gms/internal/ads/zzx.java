package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzx {

    /* renamed from: a, reason: collision with root package name */
    public final String f35802a;

    /* renamed from: b, reason: collision with root package name */
    public final String f35803b;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzx(String str, String str2) {
        this.f35802a = zzfj.o(str);
        this.f35803b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzx.class == obj.getClass()) {
            zzx zzxVar = (zzx) obj;
            if (Objects.equals(this.f35802a, zzxVar.f35802a) && Objects.equals(this.f35803b, zzxVar.f35803b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f35803b.hashCode() * 31;
        String str = this.f35802a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
