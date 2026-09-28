package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
final class zzehx extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertDialog f29373a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Timer f29374b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.overlay.zzm f29375c;

    public zzehx(zzeif zzeifVar, AlertDialog alertDialog, Timer timer, com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.f29373a = alertDialog;
        this.f29374b = timer;
        this.f29375c = zzmVar;
        Objects.requireNonNull(zzeifVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f29373a.dismiss();
        this.f29374b.cancel();
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.f29375c;
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }
}
