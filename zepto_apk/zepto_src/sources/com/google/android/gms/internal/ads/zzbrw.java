package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbrw {

    /* renamed from: a, reason: collision with root package name */
    public final Object f25499a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f25500b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public zzbsf f25501c;

    /* renamed from: d, reason: collision with root package name */
    public zzbsf f25502d;

    public static final boolean c(Context context) {
        if (((Boolean) zzbiq.f25205c.c()).booleanValue()) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        com.google.android.gms.ads.internal.util.zzq zzqVarL = com.google.android.gms.ads.internal.util.zzs.L(context);
        return zzqVarL.f21606b.toLowerCase(Locale.ROOT).equals("ru");
    }

    public final zzbsf a(Context context, VersionInfoParcel versionInfoParcel, zzfnr zzfnrVar) {
        zzbsf zzbsfVar;
        String str;
        synchronized (this.f25500b) {
            try {
                if (this.f25502d == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    if (c(context)) {
                        str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25013c);
                    } else {
                        str = (String) zzbiu.f25219a.c();
                    }
                    this.f25502d = new zzbsf(applicationContext, versionInfoParcel, str, zzfnrVar);
                }
                zzbsfVar = this.f25502d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbsfVar;
    }

    public final zzbsf b(Context context, VersionInfoParcel versionInfoParcel, zzfnr zzfnrVar) {
        zzbsf zzbsfVar;
        String str;
        synchronized (this.f25499a) {
            try {
                if (this.f25501c == null) {
                    if (c(context)) {
                        str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25013c);
                    } else if (((Boolean) zzbiq.f25209g.c()).booleanValue()) {
                        str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25011a);
                    } else {
                        str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25012b);
                    }
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    this.f25501c = new zzbsf(context, versionInfoParcel, str, zzfnrVar);
                }
                zzbsfVar = this.f25501c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbsfVar;
    }
}
