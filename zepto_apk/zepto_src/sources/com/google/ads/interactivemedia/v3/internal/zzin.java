package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
final class zzin extends BroadcastReceiver {
    final /* synthetic */ zzio zza;

    public zzin(zzio zzioVar) {
        this.zza = zzioVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
