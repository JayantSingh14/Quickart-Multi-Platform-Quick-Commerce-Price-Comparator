package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzc extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f21409a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21410b;

    public zzc(zzf zzfVar, Context context, String str) {
        this.f21409a = context;
        this.f21410b = str;
        Objects.requireNonNull(zzfVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzu(this.f21409a, null).b(this.f21410b, null);
    }
}
