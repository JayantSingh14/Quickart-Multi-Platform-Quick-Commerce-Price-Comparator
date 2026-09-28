package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzdpo implements zzdnu, zzdfm {

    /* renamed from: a, reason: collision with root package name */
    public final zzbto f28182a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdbc f28183b;

    /* renamed from: c, reason: collision with root package name */
    public final zzddd f28184c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdai f28185d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdip f28186e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f28187f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfhr f28188g;

    /* renamed from: h, reason: collision with root package name */
    public final VersionInfoParcel f28189h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfik f28190i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f28191j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f28192k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f28193l = true;

    /* renamed from: m, reason: collision with root package name */
    public final zzbtk f28194m;
    public final zzbtl n;

    public zzdpo(zzbtk zzbtkVar, zzbtl zzbtlVar, zzbto zzbtoVar, zzdbc zzdbcVar, zzddd zzdddVar, zzdai zzdaiVar, zzdip zzdipVar, Context context, zzfhr zzfhrVar, VersionInfoParcel versionInfoParcel, zzfik zzfikVar) {
        this.f28194m = zzbtkVar;
        this.n = zzbtlVar;
        this.f28182a = zzbtoVar;
        this.f28183b = zzdbcVar;
        this.f28184c = zzdddVar;
        this.f28185d = zzdaiVar;
        this.f28186e = zzdipVar;
        this.f28187f = context;
        this.f28188g = zzfhrVar;
        this.f28189h = versionInfoParcel;
        this.f28190i = zzfikVar;
    }

    public static final HashMap d(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void H() {
        try {
            zzbto zzbtoVar = this.f28182a;
            if (zzbtoVar != null) {
                zzbtoVar.v();
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call destroy", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void W(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void X(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Y(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Z(View view) {
        try {
            ObjectWrapper objectWrapper = new ObjectWrapper(view);
            zzbto zzbtoVar = this.f28182a;
            if (zzbtoVar != null) {
                zzbtoVar.s8(objectWrapper);
                return;
            }
            zzbtk zzbtkVar = this.f28194m;
            if (zzbtkVar != null) {
                Parcel parcelG = zzbtkVar.g();
                zzbcd.e(parcelG, objectWrapper);
                zzbtkVar.j1(16, parcelG);
            } else {
                zzbtl zzbtlVar = this.n;
                if (zzbtlVar != null) {
                    Parcel parcelG2 = zzbtlVar.g();
                    zzbcd.e(parcelG2, objectWrapper);
                    zzbtlVar.j1(14, parcelG2);
                }
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call untrackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void a() {
        try {
            zzbto zzbtoVar = this.f28182a;
            if (zzbtoVar == null || !zzbtoVar.f()) {
                return;
            }
            zzfhr zzfhrVar = this.f28188g;
            if (zzfhrVar.f31153e != 4 && !zzfhrVar.D0) {
                return;
            }
            zzbtoVar.h();
            this.f28183b.g();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to report impression from an adapter", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void a0(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final JSONObject b0(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final int c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void c0(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i2) {
        if (!this.f28192k) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.f28188g.L) {
            e(view2);
        } else {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void d0(Bundle bundle) {
    }

    public final void e(View view) {
        try {
            zzbto zzbtoVar = this.f28182a;
            zzdip zzdipVar = this.f28186e;
            zzdai zzdaiVar = this.f28185d;
            if (zzbtoVar != null && !zzbtoVar.p0()) {
                zzbtoVar.R0(new ObjectWrapper(view));
                zzdaiVar.h();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
                    zzdipVar.S();
                    return;
                }
                return;
            }
            zzbtk zzbtkVar = this.f28194m;
            if (zzbtkVar != null) {
                Parcel parcelZ0 = zzbtkVar.z0(14, zzbtkVar.g());
                ClassLoader classLoader = zzbcd.f24690a;
                boolean z = parcelZ0.readInt() != 0;
                parcelZ0.recycle();
                if (!z) {
                    ObjectWrapper objectWrapper = new ObjectWrapper(view);
                    Parcel parcelG = zzbtkVar.g();
                    zzbcd.e(parcelG, objectWrapper);
                    zzbtkVar.j1(11, parcelG);
                    zzdaiVar.h();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
                        zzdipVar.S();
                        return;
                    }
                    return;
                }
            }
            zzbtl zzbtlVar = this.n;
            if (zzbtlVar != null) {
                Parcel parcelZ02 = zzbtlVar.z0(12, zzbtlVar.g());
                ClassLoader classLoader2 = zzbcd.f24690a;
                boolean z2 = parcelZ02.readInt() != 0;
                parcelZ02.recycle();
                if (z2) {
                    return;
                }
                ObjectWrapper objectWrapper2 = new ObjectWrapper(view);
                Parcel parcelG2 = zzbtlVar.g();
                zzbcd.e(parcelG2, objectWrapper2);
                zzbtlVar.j1(9, parcelG2);
                zzdaiVar.h();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
                    zzdipVar.S();
                }
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call handleClick", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean e0(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void f0(zzblp zzblpVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void g0(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean h() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final JSONObject h0(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3 A[Catch: RemoteException -> 0x0032, JSONException -> 0x0050, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0032, blocks: (B:2:0x0000, B:5:0x0022, B:9:0x002c, B:14:0x0039, B:16:0x0041, B:17:0x0050, B:19:0x0056, B:21:0x0062, B:24:0x006e, B:27:0x0075, B:29:0x008b, B:41:0x00ac, B:44:0x00b3, B:45:0x00b7, B:46:0x00cd, B:48:0x00d3, B:52:0x00e5, B:54:0x00f1, B:57:0x0103, B:59:0x012c), top: B:66:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzdnu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i0(android.view.View r14, java.util.Map r15, java.util.Map r16, com.google.android.gms.internal.ads.zzdpj r17, com.google.android.gms.internal.ads.zzdpj r18) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpo.i0(android.view.View, java.util.Map, java.util.Map, com.google.android.gms.internal.ads.zzdpj, com.google.android.gms.internal.ads.zzdpj):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void j0(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.f28192k && this.f28188g.L) {
            return;
        }
        e(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void k0(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void l0(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            boolean z = this.f28191j;
            zzfhr zzfhrVar = this.f28188g;
            if (!z) {
                this.f28191j = com.google.android.gms.ads.internal.zzt.C.o.d(this.f28187f, this.f28189h.f21400a, zzfhrVar.C.toString(), this.f28190i.f31219g);
            }
            if (this.f28193l) {
                zzbto zzbtoVar = this.f28182a;
                zzdbc zzdbcVar = this.f28183b;
                if (zzbtoVar != null) {
                    if (zzfhrVar.D0) {
                        if (zzbtoVar.f()) {
                            return;
                        }
                        zzbtoVar.h();
                        zzdbcVar.g();
                        return;
                    }
                    if (zzbtoVar.f() && zzfhrVar.f31153e == 4) {
                        this.f28184c.g();
                        return;
                    } else {
                        zzbtoVar.h();
                        zzdbcVar.g();
                        return;
                    }
                }
                zzbtk zzbtkVar = this.f28194m;
                if (zzbtkVar != null) {
                    Parcel parcelZ0 = zzbtkVar.z0(13, zzbtkVar.g());
                    ClassLoader classLoader = zzbcd.f24690a;
                    boolean z2 = parcelZ0.readInt() != 0;
                    parcelZ0.recycle();
                    if (!z2) {
                        zzbtkVar.j1(10, zzbtkVar.g());
                        zzdbcVar.g();
                        return;
                    }
                }
                zzbtl zzbtlVar = this.n;
                if (zzbtlVar != null) {
                    Parcel parcelZ02 = zzbtlVar.z0(11, zzbtlVar.g());
                    ClassLoader classLoader2 = zzbcd.f24690a;
                    boolean z3 = parcelZ02.readInt() != 0;
                    parcelZ02.recycle();
                    if (z3) {
                        return;
                    }
                    zzbtlVar.j1(8, zzbtlVar.g());
                    zzdbcVar.g();
                }
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to call recordImpression", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void m() {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void zzg() {
        this.f28192k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final boolean zzh() {
        return this.f28188g.L;
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void B() {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void Z0() {
    }

    @Override // com.google.android.gms.internal.ads.zzdnu
    public final void m0(View view, MotionEvent motionEvent) {
    }
}
