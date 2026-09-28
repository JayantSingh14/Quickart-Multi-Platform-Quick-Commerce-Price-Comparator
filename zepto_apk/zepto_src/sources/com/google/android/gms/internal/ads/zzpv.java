package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzpv {

    /* renamed from: a, reason: collision with root package name */
    public boolean f35352a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f35353b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f35354c;

    public final zzpw a() {
        if (this.f35352a || !(this.f35353b || this.f35354c)) {
            return new zzpw(this);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
