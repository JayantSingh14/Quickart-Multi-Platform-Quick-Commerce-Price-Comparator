package com.google.android.gms.internal.ads;

import org.xbill.DNS.Message;

/* loaded from: classes4.dex */
final class zziaa {

    /* renamed from: a, reason: collision with root package name */
    public final zzicc f34618a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34619b;

    public zziaa(int i2, zzicc zziccVar) {
        this.f34618a = zziccVar;
        this.f34619b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziaa)) {
            return false;
        }
        zziaa zziaaVar = (zziaa) obj;
        return this.f34618a == zziaaVar.f34618a && this.f34619b == zziaaVar.f34619b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f34618a) * Message.MAXLENGTH) + this.f34619b;
    }
}
