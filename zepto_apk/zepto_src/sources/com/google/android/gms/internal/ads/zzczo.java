package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzczo {

    /* renamed from: a, reason: collision with root package name */
    public final zzfmu f27486a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f27487b;

    /* renamed from: c, reason: collision with root package name */
    public final ApplicationInfo f27488c;

    /* renamed from: d, reason: collision with root package name */
    public final String f27489d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f27490e;

    /* renamed from: f, reason: collision with root package name */
    public final PackageInfo f27491f;

    /* renamed from: g, reason: collision with root package name */
    public final zzija f27492g;

    /* renamed from: h, reason: collision with root package name */
    public final String f27493h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfaa f27494i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f27495j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfik f27496k;

    /* renamed from: l, reason: collision with root package name */
    public final int f27497l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdgd f27498m;

    public zzczo(zzfmu zzfmuVar, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, ArrayList arrayList, PackageInfo packageInfo, zzija zzijaVar, com.google.android.gms.ads.internal.util.zzj zzjVar, String str2, zzfaa zzfaaVar, zzfik zzfikVar, zzdgd zzdgdVar, int i2) {
        this.f27486a = zzfmuVar;
        this.f27487b = versionInfoParcel;
        this.f27488c = applicationInfo;
        this.f27489d = str;
        this.f27490e = arrayList;
        this.f27491f = packageInfo;
        this.f27492g = zzijaVar;
        this.f27493h = str2;
        this.f27494i = zzfaaVar;
        this.f27495j = zzjVar;
        this.f27496k = zzfikVar;
        this.f27498m = zzdgdVar;
        this.f27497l = i2;
    }

    public final zzfmb a(Bundle bundle) {
        this.f27498m.g();
        zzfmo zzfmoVar = zzfmo.SIGNALS;
        zzfmu zzfmuVar = this.f27486a;
        Objects.requireNonNull(zzfmuVar);
        return new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, this.f27494i.a(new zzczm(new Bundle(), new Bundle()), bundle, this.f27497l == 2)).d();
    }

    public final zzfmb b() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue()) {
            Bundle bundle2 = this.f27496k.t;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final zzfmb zzfmbVarA = a(bundle);
        zzfmo zzfmoVar = zzfmo.REQUEST_PARCEL;
        ListenableFuture[] listenableFutureArr = {zzfmbVarA, (ListenableFuture) this.f27492g.zzb()};
        zzfmu zzfmuVar = this.f27486a;
        zzfmuVar.getClass();
        return new zzfmd(zzfmuVar, zzfmoVar, Arrays.asList(listenableFutureArr)).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzczn
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzczo zzczoVar = this.f27483a;
                zzczoVar.getClass();
                zzczm zzczmVar = (zzczm) zzfmbVarA.f31386c.get();
                Bundle bundle3 = zzczmVar.f27481a;
                String str = (String) ((ListenableFuture) zzczoVar.f27492g.zzb()).get();
                boolean z = false;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.H7)).booleanValue() && zzczoVar.f27495j.q()) {
                    z = true;
                }
                boolean z2 = z;
                boolean zA = zzczoVar.f27496k.a();
                return new zzbza(bundle3, zzczoVar.f27487b, zzczoVar.f27488c, zzczoVar.f27489d, zzczoVar.f27490e, zzczoVar.f27491f, str, zzczoVar.f27493h, null, null, z2, zA, bundle, zzczmVar.f27482b, zzczoVar.f27497l);
            }
        }).d();
    }
}
