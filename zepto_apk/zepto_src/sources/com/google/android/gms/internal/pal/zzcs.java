package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzcs extends zzct {
    public AdvertisingIdClient.Info C;

    @Override // com.google.android.gms.internal.pal.zzct, com.google.android.gms.internal.pal.zzcr
    public final zzr b(Context context, View view, Activity activity) {
        return null;
    }

    @Override // com.google.android.gms.internal.pal.zzct, com.google.android.gms.internal.pal.zzcr
    public final zzr d(Context context, View view, Activity activity) {
        return null;
    }

    @Override // com.google.android.gms.internal.pal.zzct
    public final ArrayList i(zzdu zzduVar, Context context, zzr zzrVar, zzi zziVar) {
        ArrayList arrayList = new ArrayList();
        if (zzduVar.f37635b == null) {
            return arrayList;
        }
        arrayList.add(new zzem(zzduVar, "ysEnh8zkgcN8WwINs5FP7vGybZW2TtVSX36HO6emvdUrcCkVbC9hrF5Pe5ZSZx3i", "3LpdW89cIASEFv5WvS5ZDEWsiVGQitP33SL3WZgJ6zE=", zzrVar, zzduVar.a(), 24));
        return arrayList;
    }

    @Override // com.google.android.gms.internal.pal.zzct
    public final void j(zzdu zzduVar, Context context, zzr zzrVar, zzi zziVar) throws InterruptedException {
        if (!zzduVar.f37646m) {
            zzct.o(i(zzduVar, context, zzrVar, zziVar));
            return;
        }
        AdvertisingIdClient.Info info = this.C;
        if (info != null) {
            String str = info.f21070a;
            if (!TextUtils.isEmpty(str)) {
                zzrVar.o(zzdx.b(str));
                if (zzrVar.f37406c) {
                    zzrVar.k();
                    zzrVar.f37406c = false;
                }
                zzaf.g0((zzaf) zzrVar.f37405b);
                boolean z = this.C.f21071b;
                if (zzrVar.f37406c) {
                    zzrVar.k();
                    zzrVar.f37406c = false;
                }
                zzaf.X((zzaf) zzrVar.f37405b, z);
            }
            this.C = null;
        }
    }
}
