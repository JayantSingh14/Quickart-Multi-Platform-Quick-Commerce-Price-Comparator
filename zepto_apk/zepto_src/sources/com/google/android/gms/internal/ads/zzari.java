package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzari implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f24210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f24211b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzark f24212c;

    public zzari(zzark zzarkVar, String str, long j2) {
        this.f24210a = str;
        this.f24211b = j2;
        Objects.requireNonNull(zzarkVar);
        this.f24212c = zzarkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzark zzarkVar = this.f24212c;
        zzarkVar.f24213a.a(this.f24211b, this.f24210a);
        zzarkVar.f24213a.b(zzarkVar.toString());
    }
}
