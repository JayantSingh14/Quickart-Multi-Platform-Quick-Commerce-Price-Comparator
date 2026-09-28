package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzbvz implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbwa f25632a;

    public zzbvz(zzbwa zzbwaVar) {
        this.f25632a = zzbwaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) throws JSONException {
        this.f25632a.b("User canceled the download.");
    }
}
