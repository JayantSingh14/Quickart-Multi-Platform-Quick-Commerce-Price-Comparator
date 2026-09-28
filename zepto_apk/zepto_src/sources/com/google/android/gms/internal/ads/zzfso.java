package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfso extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfsp f31801a;

    public zzfso(zzfsp zzfspVar) {
        Objects.requireNonNull(zzfspVar);
        this.f31801a = zzfspVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean zEquals = intent.getAction().equals("android.intent.action.SCREEN_OFF");
        zzfsp zzfspVar = this.f31801a;
        if (zEquals) {
            zzfspVar.a(true, zzfspVar.f31805c);
            zzfspVar.f31804b = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfspVar.a(false, zzfspVar.f31805c);
            zzfspVar.f31804b = false;
        }
    }
}
