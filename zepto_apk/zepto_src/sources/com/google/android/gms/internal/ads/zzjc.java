package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
public final class zzjc {

    /* renamed from: a, reason: collision with root package name */
    public final Context f34982a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfc f34983b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgqs f34984c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgqs f34985d;

    /* renamed from: e, reason: collision with root package name */
    public zzgqs f34986e;

    /* renamed from: f, reason: collision with root package name */
    public zzgqs f34987f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgqs f34988g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgpr f34989h;

    /* renamed from: i, reason: collision with root package name */
    public final Looper f34990i;

    /* renamed from: j, reason: collision with root package name */
    public final int f34991j;

    /* renamed from: k, reason: collision with root package name */
    public final zzd f34992k;

    /* renamed from: l, reason: collision with root package name */
    public final int f34993l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f34994m;
    public final zzmq n;
    public final zzmp o;
    public final long p;
    public final long q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final boolean v;
    public boolean w;
    public final String x;
    public final zzim y;

    public zzjc(final Context context, zzmn zzmnVar) {
        zzjb zzjbVar = new zzjb(zzmnVar);
        zziw zziwVar = new zziw(context);
        zzgqs zzgqsVar = new zzgqs() { // from class: com.google.android.gms.internal.ads.zzix
            @Override // com.google.android.gms.internal.ads.zzgqs
            public final /* synthetic */ Object zza() {
                return new zzzu(context);
            }
        };
        zziv zzivVar = zziv.f34975a;
        zziy zziyVar = new zziy(context);
        zziu zziuVar = zziu.f34974a;
        context.getClass();
        this.f34982a = context;
        this.f34984c = zzjbVar;
        this.f34985d = zziwVar;
        this.f34986e = zzgqsVar;
        this.f34987f = zzivVar;
        this.f34988g = zziyVar;
        this.f34989h = zziuVar;
        String str = zzfj.f31254a;
        Looper looperMyLooper = Looper.myLooper();
        this.f34990i = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        this.f34992k = zzd.f27533b;
        this.f34993l = 1;
        this.f34994m = true;
        this.n = zzmq.f35222d;
        this.o = zzmp.f35219b;
        this.y = new zzim(zzfj.s(20L), zzfj.s(500L));
        this.f34983b = zzdn.f27991a;
        this.p = 500L;
        this.q = 2000L;
        this.r = 600000;
        this.s = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.t = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.u = 600000;
        this.v = true;
        this.x = "";
        this.f34991j = -1000;
        if (Build.VERSION.SDK_INT >= 35) {
            int i2 = zzis.f34966a;
        }
    }
}
