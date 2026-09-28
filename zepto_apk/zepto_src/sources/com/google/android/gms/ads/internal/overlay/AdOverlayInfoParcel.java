package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcjn;
import com.google.android.gms.internal.ads.zzdax;
import com.google.android.gms.internal.ads.zzdir;
import com.google.android.gms.internal.ads.zzdkw;
import com.google.android.gms.internal.ads.zzeav;
import com.google.android.gms.internal.ads.zzeif;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    public static final AtomicLong y = new AtomicLong(0);
    public static final ConcurrentHashMap z = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final zzc f21314a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zza f21315b;

    /* renamed from: c, reason: collision with root package name */
    public final zzr f21316c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcir f21317d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbmf f21318e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21319f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21320g;

    /* renamed from: h, reason: collision with root package name */
    public final String f21321h;

    /* renamed from: i, reason: collision with root package name */
    public final zzad f21322i;

    /* renamed from: j, reason: collision with root package name */
    public final int f21323j;

    /* renamed from: k, reason: collision with root package name */
    public final int f21324k;

    /* renamed from: l, reason: collision with root package name */
    public final String f21325l;

    /* renamed from: m, reason: collision with root package name */
    public final VersionInfoParcel f21326m;
    public final String n;
    public final com.google.android.gms.ads.internal.zzl o;
    public final zzbmd p;
    public final String q;
    public final String r;
    public final String s;
    public final zzdax t;
    public final zzdir u;
    public final zzbwr v;
    public final boolean w;
    public final long x;

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbmd zzbmdVar, zzbmf zzbmfVar, zzad zzadVar, zzcjn zzcjnVar, boolean z2, int i2, String str, VersionInfoParcel versionInfoParcel, zzdir zzdirVar, zzeif zzeifVar, boolean z3) {
        this.f21314a = null;
        this.f21315b = zzaVar;
        this.f21316c = zzrVar;
        this.f21317d = zzcjnVar;
        this.p = zzbmdVar;
        this.f21318e = zzbmfVar;
        this.f21319f = null;
        this.f21320g = z2;
        this.f21321h = null;
        this.f21322i = zzadVar;
        this.f21323j = i2;
        this.f21324k = 3;
        this.f21325l = str;
        this.f21326m = versionInfoParcel;
        this.n = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = zzdirVar;
        this.v = zzeifVar;
        this.w = z3;
        this.x = y.getAndIncrement();
    }

    public static AdOverlayInfoParcel b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e2) {
            if (!((Boolean) zzbd.f21150e.f21153c.a(zzbgk.ce)).booleanValue()) {
                return null;
            }
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdOverlayInfoParcel.getFromIntent", e2);
            return null;
        }
    }

    public static final IBinder r(Object obj) {
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.ce)).booleanValue()) {
            return null;
        }
        return new ObjectWrapper(obj).asBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f21314a, i2, false);
        com.google.android.gms.ads.internal.client.zza zzaVar = this.f21315b;
        SafeParcelWriter.writeIBinder(parcel, 3, r(zzaVar), false);
        zzr zzrVar = this.f21316c;
        SafeParcelWriter.writeIBinder(parcel, 4, r(zzrVar), false);
        zzcir zzcirVar = this.f21317d;
        SafeParcelWriter.writeIBinder(parcel, 5, r(zzcirVar), false);
        zzbmf zzbmfVar = this.f21318e;
        SafeParcelWriter.writeIBinder(parcel, 6, r(zzbmfVar), false);
        SafeParcelWriter.writeString(parcel, 7, this.f21319f, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f21320g);
        SafeParcelWriter.writeString(parcel, 9, this.f21321h, false);
        zzad zzadVar = this.f21322i;
        SafeParcelWriter.writeIBinder(parcel, 10, r(zzadVar), false);
        SafeParcelWriter.writeInt(parcel, 11, this.f21323j);
        SafeParcelWriter.writeInt(parcel, 12, this.f21324k);
        SafeParcelWriter.writeString(parcel, 13, this.f21325l, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.f21326m, i2, false);
        SafeParcelWriter.writeString(parcel, 16, this.n, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.o, i2, false);
        zzbmd zzbmdVar = this.p;
        SafeParcelWriter.writeIBinder(parcel, 18, r(zzbmdVar), false);
        SafeParcelWriter.writeString(parcel, 19, this.q, false);
        SafeParcelWriter.writeString(parcel, 24, this.r, false);
        SafeParcelWriter.writeString(parcel, 25, this.s, false);
        zzdax zzdaxVar = this.t;
        SafeParcelWriter.writeIBinder(parcel, 26, r(zzdaxVar), false);
        zzdir zzdirVar = this.u;
        SafeParcelWriter.writeIBinder(parcel, 27, r(zzdirVar), false);
        zzbwr zzbwrVar = this.v;
        SafeParcelWriter.writeIBinder(parcel, 28, r(zzbwrVar), false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.w);
        long j2 = this.x;
        SafeParcelWriter.writeLong(parcel, 30, j2);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.ce)).booleanValue()) {
            z.put(Long.valueOf(j2), new zzp(zzaVar, zzrVar, zzcirVar, zzbmdVar, zzbmfVar, zzadVar, zzdaxVar, zzdirVar, zzbwrVar, ((ScheduledThreadPoolExecutor) zzcdo.f25985d).schedule(new zzq(j2), ((Integer) r3.f21153c.a(zzbgk.ee)).intValue(), TimeUnit.SECONDS)));
        }
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbmd zzbmdVar, zzbmf zzbmfVar, zzad zzadVar, zzcjn zzcjnVar, boolean z2, int i2, String str, String str2, VersionInfoParcel versionInfoParcel, zzdir zzdirVar, zzeif zzeifVar) {
        this.f21314a = null;
        this.f21315b = zzaVar;
        this.f21316c = zzrVar;
        this.f21317d = zzcjnVar;
        this.p = zzbmdVar;
        this.f21318e = zzbmfVar;
        this.f21319f = str2;
        this.f21320g = z2;
        this.f21321h = str;
        this.f21322i = zzadVar;
        this.f21323j = i2;
        this.f21324k = 3;
        this.f21325l = null;
        this.f21326m = versionInfoParcel;
        this.n = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = zzdirVar;
        this.v = zzeifVar;
        this.w = false;
        this.x = y.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzdkw zzdkwVar, zzcir zzcirVar, int i2, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.zzl zzlVar, String str2, String str3, String str4, zzdax zzdaxVar, zzeif zzeifVar, String str5) {
        this.f21314a = null;
        this.f21315b = null;
        this.f21316c = zzdkwVar;
        this.f21317d = zzcirVar;
        this.p = null;
        this.f21318e = null;
        this.f21320g = false;
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.e1)).booleanValue()) {
            this.f21319f = null;
            this.f21321h = null;
        } else {
            this.f21319f = str2;
            this.f21321h = str3;
        }
        this.f21322i = null;
        this.f21323j = i2;
        this.f21324k = 1;
        this.f21325l = null;
        this.f21326m = versionInfoParcel;
        this.n = str;
        this.o = zzlVar;
        this.q = str5;
        this.r = null;
        this.s = str4;
        this.t = zzdaxVar;
        this.u = null;
        this.v = zzeifVar;
        this.w = false;
        this.x = y.getAndIncrement();
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, zzcjn zzcjnVar, boolean z2, int i2, VersionInfoParcel versionInfoParcel, zzdir zzdirVar, zzeif zzeifVar) {
        this.f21314a = null;
        this.f21315b = zzaVar;
        this.f21316c = zzrVar;
        this.f21317d = zzcjnVar;
        this.p = null;
        this.f21318e = null;
        this.f21319f = null;
        this.f21320g = z2;
        this.f21321h = null;
        this.f21322i = zzadVar;
        this.f21323j = i2;
        this.f21324k = 2;
        this.f21325l = null;
        this.f21326m = versionInfoParcel;
        this.n = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = zzdirVar;
        this.v = zzeifVar;
        this.w = false;
        this.x = y.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z2, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, String str4, com.google.android.gms.ads.internal.zzl zzlVar, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z3, long j2) {
        this.f21314a = zzcVar;
        this.f21319f = str;
        this.f21320g = z2;
        this.f21321h = str2;
        this.f21323j = i2;
        this.f21324k = i3;
        this.f21325l = str3;
        this.f21326m = versionInfoParcel;
        this.n = str4;
        this.o = zzlVar;
        this.q = str5;
        this.r = str6;
        this.s = str7;
        this.w = z3;
        this.x = j2;
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.ce)).booleanValue()) {
            zzp zzpVar = (zzp) z.remove(Long.valueOf(j2));
            if (zzpVar != null) {
                this.f21315b = zzpVar.f21372a;
                this.f21316c = zzpVar.f21373b;
                this.f21317d = zzpVar.f21374c;
                this.p = zzpVar.f21375d;
                this.f21318e = zzpVar.f21376e;
                this.t = zzpVar.f21378g;
                this.u = zzpVar.f21379h;
                this.v = zzpVar.f21380i;
                this.f21322i = zzpVar.f21377f;
                zzpVar.f21381j.cancel(false);
                return;
            }
            throw new NullPointerException("AdOverlayObjects is null");
        }
        this.f21315b = (com.google.android.gms.ads.internal.client.zza) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder));
        this.f21316c = (zzr) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder2));
        this.f21317d = (zzcir) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder3));
        this.p = (zzbmd) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder6));
        this.f21318e = (zzbmf) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder4));
        this.f21322i = (zzad) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder5));
        this.t = (zzdax) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder7));
        this.u = (zzdir) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder8));
        this.v = (zzbwr) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder9));
    }

    public AdOverlayInfoParcel(zzc zzcVar, com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, VersionInfoParcel versionInfoParcel, zzcjn zzcjnVar, zzdir zzdirVar, String str) {
        this.f21314a = zzcVar;
        this.f21315b = zzaVar;
        this.f21316c = zzrVar;
        this.f21317d = zzcjnVar;
        this.p = null;
        this.f21318e = null;
        this.f21319f = null;
        this.f21320g = false;
        this.f21321h = null;
        this.f21322i = zzadVar;
        this.f21323j = -1;
        this.f21324k = 4;
        this.f21325l = null;
        this.f21326m = versionInfoParcel;
        this.n = null;
        this.o = null;
        this.q = str;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = zzdirVar;
        this.v = null;
        this.w = false;
        this.x = y.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzeav zzeavVar, zzcir zzcirVar, VersionInfoParcel versionInfoParcel) {
        this.f21316c = zzeavVar;
        this.f21317d = zzcirVar;
        this.f21323j = 1;
        this.f21326m = versionInfoParcel;
        this.f21314a = null;
        this.f21315b = null;
        this.p = null;
        this.f21318e = null;
        this.f21319f = null;
        this.f21320g = false;
        this.f21321h = null;
        this.f21322i = null;
        this.f21324k = 1;
        this.f21325l = null;
        this.n = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = false;
        this.x = y.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzcjn zzcjnVar, VersionInfoParcel versionInfoParcel, String str, String str2, zzbwr zzbwrVar) {
        this.f21314a = null;
        this.f21315b = null;
        this.f21316c = null;
        this.f21317d = zzcjnVar;
        this.p = null;
        this.f21318e = null;
        this.f21319f = null;
        this.f21320g = false;
        this.f21321h = null;
        this.f21322i = null;
        this.f21323j = 14;
        this.f21324k = 5;
        this.f21325l = null;
        this.f21326m = versionInfoParcel;
        this.n = null;
        this.o = null;
        this.q = str;
        this.r = str2;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = zzbwrVar;
        this.w = false;
        this.x = y.getAndIncrement();
    }
}
