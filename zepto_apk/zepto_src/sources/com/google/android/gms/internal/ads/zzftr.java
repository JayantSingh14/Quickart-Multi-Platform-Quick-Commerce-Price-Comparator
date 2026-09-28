package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* loaded from: classes4.dex */
public abstract class zzftr extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public zzfts f31854a;

    /* renamed from: b, reason: collision with root package name */
    public final zzftj f31855b;

    public zzftr(zzftj zzftjVar) {
        this.f31855b = zzftjVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfts zzftsVar = this.f31854a;
        if (zzftsVar != null) {
            zzftsVar.f31858c = null;
            zzftr zzftrVar = (zzftr) zzftsVar.f31857b.poll();
            zzftsVar.f31858c = zzftrVar;
            if (zzftrVar != null) {
                zzftrVar.executeOnExecutor(zzftsVar.f31856a, new Object[0]);
            }
        }
    }
}
