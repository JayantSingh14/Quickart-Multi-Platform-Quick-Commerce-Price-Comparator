package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdli implements zzdby, com.google.android.gms.ads.internal.overlay.zzr, zzdbe {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27875a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcir f27876b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f27877c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f27878d;

    /* renamed from: e, reason: collision with root package name */
    public final zzeiz f27879e;

    /* renamed from: f, reason: collision with root package name */
    public zzejb f27880f;

    public zzdli(Context context, zzcir zzcirVar, zzfhr zzfhrVar, VersionInfoParcel versionInfoParcel, zzeiz zzeizVar) {
        this.f27875a = context;
        this.f27876b = zzcirVar;
        this.f27877c = zzfhrVar;
        this.f27878d = versionInfoParcel;
        this.f27879e = zzeizVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
        this.f27880f = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    public final boolean a() {
        zzfrt zzfrtVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y5)).booleanValue()) {
            return false;
        }
        zzeiz zzeizVar = this.f27879e;
        synchronized (zzeizVar) {
            zzfrtVar = zzeizVar.f29447f;
        }
        return zzfrtVar != null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        zzcir zzcirVar;
        if (a()) {
            this.f27879e.c();
        } else {
            if (this.f27880f == null || (zzcirVar = this.f27876b) == null) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.b6)).booleanValue()) {
                zzcirVar.g("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        zzcir zzcirVar;
        zzeiy zzeiyVar;
        zzeix zzeixVar;
        zzfhr zzfhrVar = this.f27877c;
        if (!zzfhrVar.T || (zzcirVar = this.f27876b) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        if (zztVar.x.a(this.f27875a)) {
            if (a()) {
                this.f27879e.b();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.f27878d;
            int i2 = versionInfoParcel.f21401b;
            int length = String.valueOf(i2).length();
            int i3 = versionInfoParcel.f21402c;
            StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i3).length());
            sb.append(i2);
            sb.append(CLConstants.DOT_SALT_DELIMETER);
            sb.append(i3);
            String string = sb.toString();
            zzfin zzfinVar = zzfhrVar.V;
            String str = zzfinVar.a() + (-1) != 1 ? "javascript" : null;
            if (zzfinVar.a() == 1) {
                zzeixVar = zzeix.VIDEO;
                zzeiyVar = zzeiy.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeiyVar = zzfhrVar.Y == 2 ? zzeiy.UNSPECIFIED : zzeiy.BEGIN_TO_RENDER;
                zzeixVar = zzeix.HTML_DISPLAY;
            }
            zzejb zzejbVarB = zztVar.x.b(zzcirVar.k(), zzeixVar, zzeiyVar, string, str, zzfhrVar.l0);
            this.f27880f = zzejbVarB;
            if (zzejbVarB != null) {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X5)).booleanValue();
                zzfrl zzfrlVar = zzejbVarB.f29453a;
                zzeiv zzeivVar = zztVar.x;
                if (zBooleanValue) {
                    zzeivVar.e(zzfrlVar, zzcirVar.k());
                    Iterator it = zzcirVar.w().iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.zzt.C.x.d(zzfrlVar, (View) it.next());
                    }
                } else {
                    zzeivVar.e(zzfrlVar, zzcirVar.x());
                }
                zzcirVar.r0(this.f27880f);
                com.google.android.gms.ads.internal.zzt.C.x.c(zzfrlVar);
                zzcirVar.g("onSdkLoaded", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        zzcir zzcirVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.b6)).booleanValue() || (zzcirVar = this.f27876b) == null) {
            return;
        }
        if (this.f27880f != null || a()) {
            if (this.f27880f != null) {
                zzcirVar.g("onSdkImpression", new ArrayMap());
            } else {
                this.f27879e.c();
            }
        }
    }
}
