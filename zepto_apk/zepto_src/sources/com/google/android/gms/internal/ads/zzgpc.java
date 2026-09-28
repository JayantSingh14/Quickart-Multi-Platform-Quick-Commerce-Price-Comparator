package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes4.dex */
final /* synthetic */ class zzgpc implements zzgqs {
    @Override // com.google.android.gms.internal.ads.zzgqs
    public final /* synthetic */ Object zza() {
        HandlerThread handlerThread = new HandlerThread("OverlayDisplayService", 10);
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
