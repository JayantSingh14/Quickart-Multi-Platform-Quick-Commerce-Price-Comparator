package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
final class zzbx extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final zzdx f25660a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f25660a.e(new zzbw());
        }
    }
}
