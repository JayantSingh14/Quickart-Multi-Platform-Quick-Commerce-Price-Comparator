package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzdoi implements zzbjl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbcc f28093a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f28094b;

    /* JADX WARN: Multi-variable type inference failed */
    public zzdoi(zzdpj zzdpjVar, ViewGroup viewGroup) {
        this.f28093a = (zzbcc) zzdpjVar;
        this.f28094b = viewGroup;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$OnTouchListener, com.google.android.gms.internal.ads.zzbcc] */
    @Override // com.google.android.gms.internal.ads.zzbjl
    public final void a(MotionEvent motionEvent) {
        this.f28093a.onTouch(null, motionEvent);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$OnClickListener, com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    @Override // com.google.android.gms.internal.ads.zzbjl
    public final void zza() {
        zzgtd zzgtdVar = zzdoh.p;
        ?? r1 = this.f28093a;
        Map mapZzk = r1.zzk();
        if (mapZzk == null) {
            return;
        }
        zzguy zzguyVar = (zzguy) zzgtdVar;
        int i2 = zzguyVar.f33234d;
        int i3 = 0;
        while (i3 < i2) {
            Object obj = mapZzk.get((String) zzguyVar.get(i3));
            i3++;
            if (obj != null) {
                r1.onClick(this.f28094b);
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    @Override // com.google.android.gms.internal.ads.zzbjl
    public final JSONObject zzc() {
        return this.f28093a.zzp();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbcc, com.google.android.gms.internal.ads.zzdpj] */
    @Override // com.google.android.gms.internal.ads.zzbjl
    public final JSONObject zzd() {
        return this.f28093a.zzq();
    }
}
