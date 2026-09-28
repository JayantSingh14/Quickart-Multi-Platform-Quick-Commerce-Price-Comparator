package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzrg {

    /* renamed from: a, reason: collision with root package name */
    public final zzkj f38044a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38045b;

    /* renamed from: c, reason: collision with root package name */
    public final zzks f38046c;

    public /* synthetic */ zzrg(zzkj zzkjVar, int i2, zzks zzksVar) {
        this.f38044a = zzkjVar;
        this.f38045b = i2;
        this.f38046c = zzksVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrg)) {
            return false;
        }
        zzrg zzrgVar = (zzrg) obj;
        return this.f38044a == zzrgVar.f38044a && this.f38045b == zzrgVar.f38045b && this.f38046c.equals(zzrgVar.f38046c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f38044a, Integer.valueOf(this.f38045b), Integer.valueOf(this.f38046c.hashCode())});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, parameters='%s')", this.f38044a, Integer.valueOf(this.f38045b), this.f38046c);
    }
}
