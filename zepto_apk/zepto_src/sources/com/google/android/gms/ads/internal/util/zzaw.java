package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f21501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21502b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f21503c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f21504d;

    public zzaw(zzax zzaxVar, Context context, String str, boolean z, boolean z2) {
        this.f21501a = context;
        this.f21502b = str;
        this.f21503c = z;
        this.f21504d = z2;
        Objects.requireNonNull(zzaxVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        Context context = this.f21501a;
        AlertDialog.Builder builderK = zzs.k(context);
        builderK.setMessage(this.f21502b);
        if (this.f21503c) {
            builderK.setTitle("Error");
        } else {
            builderK.setTitle("Info");
        }
        if (this.f21504d) {
            builderK.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderK.setPositiveButton("Learn More", new zzav(this, context));
            builderK.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderK.create().show();
    }
}
