package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcqq implements zzdbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzfji f26902a;

    public zzcqq(zzfji zzfjiVar) {
        this.f26902a = zzfjiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void P(Context context) {
        zzfir zzfirVar;
        try {
            try {
                this.f26902a.f31270a.zzl();
            } finally {
            }
        } catch (zzfir e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke onPause for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void S(Context context) {
        zzfir zzfirVar;
        try {
            zzbtc zzbtcVar = this.f26902a.f31270a;
            try {
                zzbtcVar.zzm();
                if (context != null) {
                    try {
                        zzbtcVar.R0(new ObjectWrapper(context));
                    } finally {
                    }
                }
            } finally {
            }
        } catch (zzfir e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke onResume for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void a(Context context) {
        zzfir zzfirVar;
        try {
            try {
                this.f26902a.f31270a.zzi();
            } finally {
            }
        } catch (zzfir e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke onDestroy for the mediation adapter.", e2);
        }
    }
}
