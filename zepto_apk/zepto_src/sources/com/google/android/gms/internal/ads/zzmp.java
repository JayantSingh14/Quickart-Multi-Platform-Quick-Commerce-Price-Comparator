package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzmp {

    /* renamed from: b, reason: collision with root package name */
    public static final zzmp f35219b = new zzmp(new zzmo());

    /* renamed from: a, reason: collision with root package name */
    public final zzgtn f35220a;

    public zzmp(zzmo zzmoVar) {
        this.f35220a = zzmoVar.f35218a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzmp) && this.f35220a.equals(((zzmp) obj).f35220a);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.f35220a, null, null, bool, bool, bool, bool, bool);
    }
}
