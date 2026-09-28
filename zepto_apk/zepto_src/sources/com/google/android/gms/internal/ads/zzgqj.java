package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgqj implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f33074a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzgqp f33075b;

    public zzgqj(zzgqp zzgqpVar, String str) {
        this.f33074a = str;
        Objects.requireNonNull(zzgqpVar);
        this.f33075b = zzgqpVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        zzgqp zzgqpVar = this.f33075b;
        return zzgqpVar.f33081a.a(zzgqpVar, this.f33074a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzgpu.a(sb, iterator(), ", ");
        sb.append(']');
        return sb.toString();
    }
}
