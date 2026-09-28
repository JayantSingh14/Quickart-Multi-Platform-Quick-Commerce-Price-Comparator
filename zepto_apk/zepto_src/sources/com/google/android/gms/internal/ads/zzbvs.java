package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;

/* loaded from: classes4.dex */
final class zzbvs implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbvu f25606a;

    public zzbvs(zzbvu zzbvuVar) {
        this.f25606a = zzbvuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        zzbvu zzbvuVar = this.f25606a;
        zzbvuVar.getClass();
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", zzbvuVar.f25610e);
        data.putExtra("eventLocation", zzbvuVar.f25614i);
        data.putExtra("description", zzbvuVar.f25613h);
        long j2 = zzbvuVar.f25611f;
        if (j2 > -1) {
            data.putExtra("beginTime", j2);
        }
        long j3 = zzbvuVar.f25612g;
        if (j3 > -1) {
            data.putExtra("endTime", j3);
        }
        data.setFlags(268435456);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        com.google.android.gms.ads.internal.util.zzs.t(zzbvuVar.f25609d, data);
    }
}
