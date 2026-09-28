package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzebp {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29020a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f29021b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f29022c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f29023d = new AtomicReference("");

    public zzebp(Context context, VersionInfoParcel versionInfoParcel, zzgyw zzgywVar) {
        this.f29020a = context;
        this.f29021b = versionInfoParcel;
        this.f29022c = zzgywVar;
    }

    public static final String c(String str) {
        return com.google.android.gms.ads.internal.util.zzs.K(new String(Base64.decode(str, 0)), new String(Base64.decode((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.wf), 10), StandardCharsets.UTF_8));
    }

    public final String a() {
        zzbgb zzbgbVar = zzbgk.sf;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzbgb zzbgbVar2 = zzbgk.uf;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (!((String) zzbgiVar.a(zzbgbVar2)).isEmpty() && !((String) zzbgiVar.a(zzbgk.vf)).isEmpty() && !((String) zzbgiVar.a(zzbgk.wf)).isEmpty()) {
                String str = (String) this.f29023d.get();
                if (!str.isEmpty()) {
                    return str;
                }
                this.f29022c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebo
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzebp zzebpVar = this.f29019a;
                        AtomicReference atomicReference = zzebpVar.f29023d;
                        synchronized (atomicReference) {
                            try {
                                if (((String) atomicReference.get()).isEmpty()) {
                                    atomicReference.set(zzebpVar.b());
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                return null;
            }
        }
        return null;
    }

    public final String b() throws SecurityException {
        String name;
        VersionInfoParcel versionInfoParcel = this.f29021b;
        String strC = null;
        if (versionInfoParcel.f21403d) {
            name = zzcjc.class.getName();
        } else {
            try {
                name = (String) new JSONObject(c((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.uf))).get(Integer.toString(versionInfoParcel.f21402c));
            } catch (ClassCastException | IllegalArgumentException | NullPointerException | JSONException e2) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.tf)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("SdkIE", e2);
                }
                name = null;
            }
        }
        if (TextUtils.isEmpty(name)) {
            return "2";
        }
        try {
            strC = c((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vf));
        } catch (IllegalArgumentException e3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.tf)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("SdkIE", e3);
            }
        }
        if (TextUtils.isEmpty(strC)) {
            return "3";
        }
        try {
            for (Method method : this.f29020a.getClassLoader().loadClass(name).getDeclaredMethods()) {
                if (method.getName().matches(strC)) {
                    return "1";
                }
            }
            return "0";
        } catch (ClassNotFoundException unused) {
            return "4";
        } catch (NoClassDefFoundError unused2) {
            return CLConstants.CREDTYPE_DEBIT_DLENGTH;
        } catch (SecurityException unused3) {
            return "7";
        } catch (PatternSyntaxException unused4) {
            return "5";
        }
    }
}
