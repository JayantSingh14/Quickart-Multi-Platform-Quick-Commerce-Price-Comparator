package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbci extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbcm f24697a;

    public zzbci(zzbcm zzbcmVar) {
        Objects.requireNonNull(zzbcmVar);
        this.f24697a = zzbcmVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f24697a.d(3);
    }
}
