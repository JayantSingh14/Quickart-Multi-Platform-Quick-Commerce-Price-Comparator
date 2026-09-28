package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;

/* loaded from: classes4.dex */
final class zzav implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f21500a;

    public zzav(zzaw zzawVar, Context context) {
        this.f21500a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        zzs.u(this.f21500a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
