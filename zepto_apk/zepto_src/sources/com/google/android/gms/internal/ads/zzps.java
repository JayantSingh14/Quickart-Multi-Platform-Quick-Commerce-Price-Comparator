package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzps extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpu f35341a;

    public /* synthetic */ zzps(zzpu zzpuVar) {
        Objects.requireNonNull(zzpuVar);
        this.f35341a = zzpuVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzpu zzpuVar = this.f35341a;
        zzpuVar.a(zzpp.b(context, intent, zzpuVar.f35350i, zzpuVar.f35349h));
    }
}
