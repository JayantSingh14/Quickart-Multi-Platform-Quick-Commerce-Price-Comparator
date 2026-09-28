package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzjv implements FutureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzog f39222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39223b;

    public zzjv(zzli zzliVar, zzog zzogVar) {
        this.f39222a = zzogVar;
        Objects.requireNonNull(zzliVar);
        this.f39223b = zzliVar;
    }

    public final void a() throws JSONException, NumberFormatException {
        zzib zzibVar = this.f39223b.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        SparseArray sparseArrayM = zzhgVar.m();
        zzog zzogVar = this.f39222a;
        sparseArrayM.put(zzogVar.f39546c, Long.valueOf(zzogVar.f39545b));
        zzhg zzhgVar2 = zzibVar.f39088e;
        zzib.j(zzhgVar2);
        int[] iArr = new int[sparseArrayM.size()];
        long[] jArr = new long[sparseArrayM.size()];
        for (int i2 = 0; i2 < sparseArrayM.size(); i2++) {
            iArr[i2] = sparseArrayM.keyAt(i2);
            jArr[i2] = ((Long) sparseArrayM.valueAt(i2)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzhgVar2.n.b(bundle);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) throws JSONException, NumberFormatException {
        zzli zzliVar = this.f39223b;
        zzliVar.g();
        zzliVar.f39321i = false;
        zzib zzibVar = zzliVar.f39180a;
        int i2 = 2;
        if (zzibVar.f39087d.q(null, zzfx.T0)) {
            String message = th.getMessage();
            zzliVar.n = false;
            if (message != null) {
                if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                    if (message.contains("Background")) {
                        zzliVar.n = true;
                    }
                    i2 = 1;
                } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    i2 = 3;
                }
            }
        }
        int i3 = i2 - 1;
        zzog zzogVar = this.f39222a;
        zzgt zzgtVar = zzibVar.f39089f;
        if (i3 == 0) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgt.o(zzibVar.q().m()), zzgt.o(th.toString()));
            zzliVar.f39322j = 1;
            zzliVar.K().add(zzogVar);
            return;
        }
        if (i3 != 1) {
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgt.o(zzibVar.q().m()), th);
            a();
            zzliVar.f39322j = 1;
            zzliVar.L();
            return;
        }
        zzliVar.K().add(zzogVar);
        if (zzliVar.f39322j > ((Integer) zzfx.w0.a(null)).intValue()) {
            zzliVar.f39322j = 1;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.c("registerTriggerAsync failed. May try later. App ID, throwable", zzgt.o(zzibVar.q().m()), zzgt.o(th.toString()));
            return;
        }
        zzib.l(zzgtVar);
        zzgtVar.f38961i.d("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgt.o(zzibVar.q().m()), zzgt.o(String.valueOf(zzliVar.f39322j)), zzgt.o(th.toString()));
        int i4 = zzliVar.f39322j;
        if (zzliVar.f39323k == null) {
            zzliVar.f39323k = new zzjw(zzliVar, zzibVar);
        }
        zzliVar.f39323k.b(i4 * 1000);
        int i5 = zzliVar.f39322j;
        zzliVar.f39322j = i5 + i5;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) throws JSONException, NumberFormatException {
        zzli zzliVar = this.f39223b;
        zzliVar.g();
        a();
        zzliVar.f39321i = false;
        zzliVar.f39322j = 1;
        zzgt zzgtVar = zzliVar.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.b(this.f39222a.f39544a, "Successfully registered trigger URI");
        zzliVar.L();
    }
}
