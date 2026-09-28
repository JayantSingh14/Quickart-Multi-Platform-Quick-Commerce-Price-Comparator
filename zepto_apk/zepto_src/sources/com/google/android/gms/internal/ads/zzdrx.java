package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzdrx implements zzbjl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdry f28387a;

    public zzdrx(zzdry zzdryVar) {
        Objects.requireNonNull(zzdryVar);
        this.f28387a = zzdryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final void a(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final void zza() {
        zzdnh zzdnhVar = this.f28387a.f28391d;
        if (zzdnhVar != null) {
            synchronized (zzdnhVar) {
                zzdnhVar.n.Y("_videoMediaView");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final JSONObject zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final JSONObject zzd() {
        return null;
    }
}
