package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* loaded from: classes4.dex */
public final class zzast extends zziir implements Closeable, AutoCloseable {
    static {
        zziiy.b(zzast.class);
    }

    public zzast(zziis zziisVar, zzass zzassVar) {
        zzcgf zzcgfVar = (zzcgf) zziisVar;
        long jZzb = zzcgfVar.zzb();
        this.f34854b = zziisVar;
        this.f34856d = zzcgfVar.zzc();
        zzcgfVar.h(zzcgfVar.zzc() + jZzb);
        this.f34857e = zzcgfVar.zzc();
        this.f34853a = (zzasr) zzassVar;
    }

    @Override // com.google.android.gms.internal.ads.zziir, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zziir
    public final String toString() {
        String string = this.f34854b.toString();
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.g(7, string));
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
