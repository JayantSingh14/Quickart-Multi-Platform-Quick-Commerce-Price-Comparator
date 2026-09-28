package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzqd {

    /* renamed from: a, reason: collision with root package name */
    public boolean f35377a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f35378b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f35379c;

    /* renamed from: d, reason: collision with root package name */
    public int f35380d = 0;

    public final zzqe a() {
        if (this.f35377a || !(this.f35378b || this.f35379c)) {
            return new zzqe(this);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupportedForOffload is false");
    }
}
