package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* loaded from: classes4.dex */
public final class zzpu {

    /* renamed from: a, reason: collision with root package name */
    public final Context f35342a;

    /* renamed from: b, reason: collision with root package name */
    public final zzpt f35343b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f35344c;

    /* renamed from: d, reason: collision with root package name */
    public final zzpq f35345d;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f35346e;

    /* renamed from: f, reason: collision with root package name */
    public final zzpr f35347f;

    /* renamed from: g, reason: collision with root package name */
    public zzpp f35348g;

    /* renamed from: h, reason: collision with root package name */
    public AudioDeviceInfo f35349h;

    /* renamed from: i, reason: collision with root package name */
    public zzd f35350i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35351j;

    public zzpu(Context context, zzpt zzptVar, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        Context applicationContext = context.getApplicationContext();
        this.f35342a = applicationContext;
        this.f35343b = zzptVar;
        this.f35350i = zzdVar;
        this.f35349h = audioDeviceInfo;
        String str = zzfj.f31254a;
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, null);
        this.f35344c = handler;
        this.f35345d = new zzpq(this);
        this.f35346e = new zzps(this);
        zzpp zzppVar = zzpp.f35332c;
        String str2 = Build.MANUFACTURER;
        Uri uriFor = (str2.equals("Amazon") || str2.equals("Xiaomi")) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.f35347f = uriFor != null ? new zzpr(this, handler, applicationContext.getContentResolver(), uriFor) : null;
    }

    public final void a(zzpp zzppVar) {
        if (!this.f35351j || zzppVar.equals(this.f35348g)) {
            return;
        }
        this.f35348g = zzppVar;
        zzse zzseVar = ((zzsb) this.f35343b).f35480a;
        zzseVar.e();
        zzpp zzppVar2 = zzseVar.f35489e;
        if (zzppVar2 == null || zzppVar.equals(zzppVar2)) {
            return;
        }
        zzseVar.f35489e = zzppVar;
        zzed zzedVar = zzseVar.f35487c;
        if (zzedVar != null) {
            zzedVar.c(-1, zzsa.f35479a);
            zzedVar.d();
        }
    }
}
