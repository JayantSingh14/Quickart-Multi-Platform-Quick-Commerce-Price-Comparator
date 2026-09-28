package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzcdf implements zzbde {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f25963b;

    /* renamed from: d, reason: collision with root package name */
    public final zzcdc f25965d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f25962a = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f25966e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f25967f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public boolean f25968g = false;

    /* renamed from: c, reason: collision with root package name */
    public final zzcdd f25964c = new zzcdd();

    public zzcdf(String str, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f25965d = new zzcdc(str, zzjVar);
        this.f25963b = zzjVar;
    }

    public final void a(zzccu zzccuVar) {
        synchronized (this.f25962a) {
            this.f25966e.add(zzccuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void j1(boolean z) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
        com.google.android.gms.ads.internal.util.zzj zzjVar = this.f25963b;
        zzcdc zzcdcVar = this.f25965d;
        if (z) {
            if (jCurrentTimeMillis - zzjVar.j() > ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q1)).longValue()) {
                zzcdcVar.f25950d = -1;
            } else {
                zzcdcVar.f25950d = zzjVar.l();
            }
            this.f25968g = true;
            return;
        }
        zzjVar.d();
        synchronized (zzjVar.f21580a) {
            try {
                if (zzjVar.o != jCurrentTimeMillis) {
                    zzjVar.o = jCurrentTimeMillis;
                    SharedPreferences.Editor editor = zzjVar.f21586g;
                    if (editor != null) {
                        editor.putLong("app_last_background_time_ms", jCurrentTimeMillis);
                        zzjVar.f21586g.apply();
                    }
                    zzjVar.e();
                }
            } finally {
            }
        }
        int i2 = zzcdcVar.f25950d;
        zzjVar.d();
        synchronized (zzjVar.f21580a) {
            try {
                if (zzjVar.q == i2) {
                    return;
                }
                zzjVar.q = i2;
                SharedPreferences.Editor editor2 = zzjVar.f21586g;
                if (editor2 != null) {
                    editor2.putInt("request_in_session_count", i2);
                    zzjVar.f21586g.apply();
                }
                zzjVar.e();
            } finally {
            }
        }
    }
}
