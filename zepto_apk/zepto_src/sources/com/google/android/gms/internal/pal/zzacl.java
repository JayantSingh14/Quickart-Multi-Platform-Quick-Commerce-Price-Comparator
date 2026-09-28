package com.google.android.gms.internal.pal;

import org.xbill.DNS.Message;

/* loaded from: classes4.dex */
final class zzacl {

    /* renamed from: a, reason: collision with root package name */
    public final zzaef f37386a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37387b;

    public zzacl(zzaef zzaefVar, int i2) {
        this.f37386a = zzaefVar;
        this.f37387b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzacl)) {
            return false;
        }
        zzacl zzaclVar = (zzacl) obj;
        return this.f37386a == zzaclVar.f37386a && this.f37387b == zzaclVar.f37387b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f37386a) * Message.MAXLENGTH) + this.f37387b;
    }
}
