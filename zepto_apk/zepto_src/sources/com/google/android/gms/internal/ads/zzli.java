package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzli {

    /* renamed from: a, reason: collision with root package name */
    public final long f35093a;

    /* renamed from: b, reason: collision with root package name */
    public final float f35094b;

    /* renamed from: c, reason: collision with root package name */
    public final long f35095c;

    public /* synthetic */ zzli(zzlh zzlhVar) {
        this.f35093a = zzlhVar.f35090a;
        this.f35094b = zzlhVar.f35091b;
        this.f35095c = zzlhVar.f35092c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzli)) {
            return false;
        }
        zzli zzliVar = (zzli) obj;
        return this.f35093a == zzliVar.f35093a && this.f35094b == zzliVar.f35094b && this.f35095c == zzliVar.f35095c;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f35093a), Float.valueOf(this.f35094b), Long.valueOf(this.f35095c));
    }
}
