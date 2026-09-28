package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbqx implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbqu f25445a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.util.zzbv f25446b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbrr f25447c;

    public zzbqx(zzbrr zzbrrVar, zzbqu zzbquVar, com.google.android.gms.ads.internal.util.zzbv zzbvVar) {
        this.f25445a = zzbquVar;
        this.f25446b = zzbvVar;
        Objects.requireNonNull(zzbrrVar);
        this.f25447c = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzbrr zzbrrVar = this.f25447c;
        synchronized (zzbrrVar.f25488a) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Lock acquired");
                com.google.android.gms.ads.internal.util.client.zzo.e("JS Engine is requesting an update");
                if (zzbrrVar.f25496i == 0) {
                    com.google.android.gms.ads.internal.util.client.zzo.e("Starting reload.");
                    zzbrrVar.f25496i = 2;
                    zzbrrVar.a();
                }
                this.f25445a.x0("/requestReload", (zzbnn) this.f25446b.f21547a);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
