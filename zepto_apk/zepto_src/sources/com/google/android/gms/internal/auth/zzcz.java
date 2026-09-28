package com.google.android.gms.internal.auth;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzcz {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f36315a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36316b = "";

    /* renamed from: c, reason: collision with root package name */
    public final boolean f36317c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f36318d;

    public zzcz(Uri uri, boolean z, boolean z2) {
        this.f36315a = uri;
        this.f36317c = z;
        this.f36318d = z2;
    }

    public final zzcz a() {
        if (!this.f36316b.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new zzcz(this.f36315a, true, this.f36318d);
    }

    public final void b(long j2) {
        new zzcv(this, Long.valueOf(j2));
    }

    public final void c(boolean z) {
        new zzcw(this, Boolean.valueOf(z));
    }
}
