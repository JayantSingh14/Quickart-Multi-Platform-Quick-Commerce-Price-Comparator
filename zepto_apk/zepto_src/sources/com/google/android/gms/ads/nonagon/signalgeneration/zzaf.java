package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzgyj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaf implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbxn f21767a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f21768b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f21769c;

    public zzaf(zzau zzauVar, zzbxn zzbxnVar, boolean z) {
        this.f21767a = zzbxnVar;
        this.f21768b = z;
        Objects.requireNonNull(zzauVar);
        this.f21769c = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        try {
            zzbxn zzbxnVar = this.f21767a;
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
        ArrayList arrayList;
        ArrayList arrayList2;
        List<Uri> list = (List) obj;
        try {
            zzau zzauVar = this.f21769c;
            zzauVar.getClass();
            Iterator it = list.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = zzauVar.y;
                arrayList2 = zzauVar.x;
                if (zHasNext) {
                    if (zzau.bc((Uri) it.next(), arrayList2, arrayList)) {
                        zzauVar.t.getAndIncrement();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f21767a.J0(list);
            if (!zzauVar.o && !this.f21768b) {
                return;
            }
            for (Uri uri : list) {
                boolean zBc = zzau.bc(uri, arrayList2, arrayList);
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
