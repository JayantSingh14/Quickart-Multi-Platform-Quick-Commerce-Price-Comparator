package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzgyj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzae implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbxn f21764a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f21765b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f21766c;

    public zzae(zzau zzauVar, zzbxn zzbxnVar, boolean z) {
        this.f21764a = zzbxnVar;
        this.f21765b = z;
        Objects.requireNonNull(zzauVar);
        this.f21766c = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        try {
            zzbxn zzbxnVar = this.f21764a;
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
            sb.append("Internal error: ");
            sb.append(message);
            zzbxnVar.c0(sb.toString());
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.f21764a.J0(arrayList);
            zzau zzauVar = this.f21766c;
            if (!zzauVar.n && !this.f21765b) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                boolean zBc = zzau.bc(uri, zzauVar.z, zzauVar.A);
                zzfpi zzfpiVar = zzauVar.f21806m;
                if (zBc) {
                    zzfpiVar.b(zzau.ec(uri, zzauVar.w, "1").toString(), null, null, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g8)).booleanValue()) {
                        zzfpiVar.b(uri.toString(), null, null, null);
                    }
                }
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }
}
