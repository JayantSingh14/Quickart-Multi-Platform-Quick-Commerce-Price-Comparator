package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzccg;
import com.google.android.gms.internal.ads.zzccn;
import com.google.android.gms.internal.ads.zzfne;
import com.google.android.gms.internal.ads.zzfno;
import com.google.android.gms.internal.ads.zzgyj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzad implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f21759a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzccn f21760b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzccg f21761c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfne f21762d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f21763e;

    public zzad(zzau zzauVar, ListenableFuture listenableFuture, zzccn zzccnVar, zzccg zzccgVar, zzfne zzfneVar) {
        this.f21759a = listenableFuture;
        this.f21760b = zzccnVar;
        this.f21761c = zzccgVar;
        this.f21762d = zzfneVar;
        Objects.requireNonNull(zzauVar);
        this.f21763e = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.x8)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("SignalGeneratorImpl.generateSignals", th);
        } else {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("SignalGeneratorImpl.generateSignals", th);
        }
        zzfno zzfnoVarGc = zzau.gc(this.f21759a, this.f21760b);
        if (((Boolean) zzbid.f25135e.c()).booleanValue() && zzfnoVarGc != null) {
            zzfne zzfneVar = this.f21762d;
            zzfneVar.c(th);
            zzfneVar.a(false);
            zzfnoVarGc.a(zzfneVar);
            zzfnoVarGc.h();
        }
        zzccg zzccgVar = this.f21761c;
        if (zzccgVar == null) {
            return;
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
                sb.append("Internal error. ");
                sb.append(message);
                message = sb.toString();
            }
            zzccgVar.b(message);
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzau zzauVar = this.f21763e;
        AtomicBoolean atomicBoolean = zzauVar.C;
        zzbj zzbjVar = (zzbj) obj;
        zzfno zzfnoVarGc = zzau.gc(this.f21759a, this.f21760b);
        atomicBoolean.set(true);
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r8)).booleanValue();
        zzfne zzfneVar = this.f21762d;
        zzccg zzccgVar = this.f21761c;
        if (!zBooleanValue) {
            if (zzccgVar != null) {
                try {
                    zzccgVar.b("QueryInfo generation has been disabled.");
                } catch (RemoteException e2) {
                    String strConcat = "QueryInfo generation has been disabled.".concat(e2.toString());
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(strConcat);
                }
            }
            if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                return;
            }
            zzfneVar.b("QueryInfo generation has been disabled.");
            zzfneVar.a(false);
            zzfnoVarGc.a(zzfneVar);
            zzfnoVarGc.h();
            return;
        }
        try {
            try {
                if (zzbjVar == null) {
                    if (zzccgVar != null) {
                        zzccgVar.G2(null, null, null);
                    }
                    zzfneVar.a(true);
                    if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                        return;
                    }
                    zzfnoVarGc.a(zzfneVar);
                    zzfnoVarGc.h();
                    return;
                }
                try {
                    String str = zzbjVar.f21852a;
                    if (TextUtils.isEmpty((!TextUtils.isEmpty(zzbjVar.f21854c) ? new JSONObject(zzbjVar.f21854c) : new JSONObject(zzbjVar.f21853b)).optString("request_id", ""))) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("The request ID is empty in request JSON.");
                        if (zzccgVar != null) {
                            zzccgVar.b("Internal error: request ID is empty in request JSON.");
                        }
                        zzfneVar.b("Request ID empty");
                        zzfneVar.a(false);
                        if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                            return;
                        }
                        zzfnoVarGc.a(zzfneVar);
                        zzfnoVarGc.h();
                        return;
                    }
                    Bundle bundle = zzbjVar.f21857f;
                    boolean z = zzauVar.q;
                    String str2 = zzauVar.r;
                    String str3 = zzauVar.s;
                    if (z && bundle != null && bundle.getInt(str3, -1) == -1) {
                        bundle.putInt(str3, zzauVar.t.get());
                    }
                    if (zzauVar.p && bundle != null && TextUtils.isEmpty(bundle.getString(str2))) {
                        if (TextUtils.isEmpty(zzauVar.v)) {
                            zzauVar.v = com.google.android.gms.ads.internal.zzt.C.f21679c.E(zzauVar.f21796c, zzauVar.u.f21400a);
                        }
                        bundle.putString(str2, zzauVar.v);
                    }
                    if (zzccgVar != null) {
                        if (TextUtils.isEmpty(zzbjVar.f21854c)) {
                            zzccgVar.G2(str, zzbjVar.f21853b, bundle);
                        } else {
                            zzccgVar.G2(str, zzbjVar.f21854c, bundle);
                        }
                    }
                    zzfneVar.a(true);
                    if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                        return;
                    }
                    zzfnoVarGc.a(zzfneVar);
                    zzfnoVarGc.h();
                } catch (JSONException e3) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to create JSON object from the request string.");
                    if (zzccgVar != null) {
                        String string = e3.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 33);
                        sb.append("Internal error for request JSON: ");
                        sb.append(string);
                        zzccgVar.b(sb.toString());
                    }
                    zzfneVar.c(e3);
                    zzfneVar.a(false);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("SignalGeneratorImpl.generateSignals.onSuccess", e3);
                    if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                        return;
                    }
                    zzfnoVarGc.a(zzfneVar);
                    zzfnoVarGc.h();
                }
            } catch (RemoteException e4) {
                zzfneVar.c(e4);
                zzfneVar.a(false);
                int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("SignalGeneratorImpl.generateSignals.onSuccess", e4);
                if (!((Boolean) zzbid.f25135e.c()).booleanValue() || zzfnoVarGc == null) {
                    return;
                }
                zzfnoVarGc.a(zzfneVar);
                zzfnoVarGc.h();
            }
        } catch (Throwable th) {
            if (((Boolean) zzbid.f25135e.c()).booleanValue() && zzfnoVarGc != null) {
                zzfnoVarGc.a(zzfneVar);
                zzfnoVarGc.h();
            }
            throw th;
        }
    }
}
