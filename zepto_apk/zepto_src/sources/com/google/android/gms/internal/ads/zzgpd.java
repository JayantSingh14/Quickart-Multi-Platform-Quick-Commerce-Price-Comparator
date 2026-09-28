package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzgpd {

    /* renamed from: b, reason: collision with root package name */
    public final Context f33040b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgpe f33041c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f33044f;

    /* renamed from: g, reason: collision with root package name */
    public final Intent f33045g;

    /* renamed from: i, reason: collision with root package name */
    public ServiceConnection f33047i;

    /* renamed from: j, reason: collision with root package name */
    public zzgnh f33048j;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f33043e = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final String f33042d = "OverlayDisplayService";

    /* renamed from: a, reason: collision with root package name */
    public final zzgqs f33039a = zzgqw.a(new zzgpc());

    /* renamed from: h, reason: collision with root package name */
    public final IBinder.DeathRecipient f33046h = new IBinder.DeathRecipient() { // from class: com.google.android.gms.internal.ads.zzgoy
        @Override // android.os.IBinder.DeathRecipient
        public final /* synthetic */ void binderDied() {
            zzgpd zzgpdVar = this.f33033a;
            zzgpdVar.f33041c.a("%s : Binder has died.", zzgpdVar.f33042d);
            ArrayList arrayList = zzgpdVar.f33043e;
            synchronized (arrayList) {
                arrayList.clear();
            }
        }
    };

    public zzgpd(Context context, zzgpe zzgpeVar, Intent intent) {
        this.f33040b = context;
        this.f33041c = zzgpeVar;
        this.f33045g = intent;
    }

    public final void a(final Runnable runnable) {
        ((Handler) this.f33039a.zza()).post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgpb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Runnable runnable2 = runnable;
                zzgpd zzgpdVar = this.f33037a;
                zzgpdVar.getClass();
                try {
                    runnable2.run();
                } catch (RuntimeException e2) {
                    zzgpdVar.f33041c.c("error caused by ", e2);
                }
            }
        });
    }
}
