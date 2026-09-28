package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzcjx extends com.google.android.gms.ads.internal.client.zzec {

    /* renamed from: a, reason: collision with root package name */
    public final zzcfk f26443a;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f26445c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f26446d;

    /* renamed from: e, reason: collision with root package name */
    public int f26447e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzeg f26448f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26449g;

    /* renamed from: i, reason: collision with root package name */
    public float f26451i;

    /* renamed from: j, reason: collision with root package name */
    public float f26452j;

    /* renamed from: k, reason: collision with root package name */
    public float f26453k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26454l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26455m;
    public zzblg n;

    /* renamed from: b, reason: collision with root package name */
    public final Object f26444b = new Object();

    /* renamed from: h, reason: collision with root package name */
    public boolean f26450h = true;

    public zzcjx(zzcfk zzcfkVar, float f2, boolean z, boolean z2) {
        this.f26443a = zzcfkVar;
        this.f26451i = f2;
        this.f26445c = z;
        this.f26446d = z2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void B() {
        ac("stop", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void D1(com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.f26444b) {
            this.f26448f = zzegVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void N0(boolean z) {
        ac(true != z ? "unmute" : "mute", null);
    }

    public final void Yb(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        Object obj = this.f26444b;
        boolean z = zzgaVar.f21248b;
        boolean z2 = zzgaVar.f21249c;
        synchronized (obj) {
            this.f26454l = z;
            this.f26455m = z2;
        }
        boolean z3 = zzgaVar.f21247a;
        ac("initialState", CollectionUtils.mapOf("muteStart", true != z3 ? "0" : "1", "customControlsRequested", true != z ? "0" : "1", "clickToExpandRequested", true != z2 ? "0" : "1"));
    }

    public final void Zb(float f2, float f3, float f4, int i2, boolean z) {
        boolean z2;
        boolean z3;
        int i3;
        synchronized (this.f26444b) {
            try {
                z2 = true;
                if (f3 == this.f26451i && f4 == this.f26453k) {
                    z2 = false;
                }
                this.f26451i = f3;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ud)).booleanValue()) {
                    this.f26452j = f2;
                }
                z3 = this.f26450h;
                this.f26450h = z;
                i3 = this.f26447e;
                this.f26447e = i2;
                float f5 = this.f26453k;
                this.f26453k = f4;
                if (Math.abs(f4 - f5) > 1.0E-4f) {
                    this.f26443a.x().invalidate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            try {
                zzblg zzblgVar = this.n;
                if (zzblgVar != null) {
                    zzblgVar.j1(2, zzblgVar.g());
                }
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        ((zzcdn) zzcdo.f25987f).execute(new zzcjv(this, i3, i2, z3, z));
    }

    public final void ac(String str, Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f26441a.f26443a.g("pubVideoCmd", map2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() {
        ac("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() {
        ac(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzh() {
        boolean z;
        synchronized (this.f26444b) {
            z = this.f26450h;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzi() {
        int i2;
        synchronized (this.f26444b) {
            i2 = this.f26447e;
        }
        return i2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() {
        float f2;
        synchronized (this.f26444b) {
            f2 = this.f26451i;
        }
        return f2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() {
        float f2;
        synchronized (this.f26444b) {
            f2 = this.f26452j;
        }
        return f2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() {
        float f2;
        synchronized (this.f26444b) {
            f2 = this.f26453k;
        }
        return f2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzn() {
        boolean z;
        synchronized (this.f26444b) {
            try {
                z = false;
                if (this.f26445c && this.f26454l) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzo() {
        com.google.android.gms.ads.internal.client.zzeg zzegVar;
        synchronized (this.f26444b) {
            zzegVar = this.f26448f;
        }
        return zzegVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() {
        boolean z;
        Object obj = this.f26444b;
        boolean zZzn = zzn();
        synchronized (obj) {
            z = false;
            if (!zZzn) {
                try {
                    if (this.f26455m && this.f26446d) {
                        z = true;
                    }
                } finally {
                }
            }
        }
        return z;
    }
}
