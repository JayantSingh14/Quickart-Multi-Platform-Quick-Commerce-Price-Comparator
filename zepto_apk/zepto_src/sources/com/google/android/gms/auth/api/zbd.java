package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

@Deprecated
/* loaded from: classes4.dex */
public final class zbd implements Api.ApiOptions.Optional {

    /* renamed from: c, reason: collision with root package name */
    public static final zbd f22224c = new zbd(new zbc());

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22225a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22226b;

    public zbd(zbc zbcVar) {
        this.f22225a = zbcVar.f22222a.booleanValue();
        this.f22226b = zbcVar.f22223b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbd)) {
            return false;
        }
        zbd zbdVar = (zbd) obj;
        zbdVar.getClass();
        return Objects.equal(null, null) && this.f22225a == zbdVar.f22225a && Objects.equal(this.f22226b, zbdVar.f22226b);
    }

    public final int hashCode() {
        return Objects.hashCode(null, Boolean.valueOf(this.f22225a), this.f22226b);
    }
}
