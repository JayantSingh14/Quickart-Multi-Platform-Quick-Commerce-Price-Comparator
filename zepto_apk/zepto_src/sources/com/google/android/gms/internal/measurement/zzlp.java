package com.google.android.gms.internal.measurement;

import org.xbill.DNS.Message;

/* loaded from: classes4.dex */
final class zzlp {

    /* renamed from: a, reason: collision with root package name */
    public final Object f37086a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37087b;

    public zzlp(Object obj, int i2) {
        this.f37086a = obj;
        this.f37087b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlp)) {
            return false;
        }
        zzlp zzlpVar = (zzlp) obj;
        return this.f37086a == zzlpVar.f37086a && this.f37087b == zzlpVar.f37087b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f37086a) * Message.MAXLENGTH) + this.f37087b;
    }
}
