package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzbvt implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbvu f25607a;

    public zzbvt(zzbvu zzbvuVar) {
        this.f25607a = zzbvuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) throws JSONException {
        this.f25607a.b("Operation denied by user.");
    }
}
