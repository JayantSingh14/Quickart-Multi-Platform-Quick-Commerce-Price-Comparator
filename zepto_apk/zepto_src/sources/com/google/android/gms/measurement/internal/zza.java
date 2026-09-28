package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zza implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f38655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f38656b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzd f38657c;

    public zza(zzd zzdVar, String str, long j2) {
        this.f38655a = str;
        this.f38656b = j2;
        Objects.requireNonNull(zzdVar);
        this.f38657c = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.f38657c;
        zzdVar.g();
        String str = this.f38655a;
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = zzdVar.f38819c;
        boolean zIsEmpty = arrayMap.isEmpty();
        long j2 = this.f38656b;
        if (zIsEmpty) {
            zzdVar.f38820d = j2;
        }
        Integer num = (Integer) arrayMap.get(str);
        if (num != null) {
            arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
            return;
        }
        if (arrayMap.f1605c < 100) {
            arrayMap.put(str, 1);
            zzdVar.f38818b.put(str, Long.valueOf(j2));
        } else {
            zzgt zzgtVar = zzdVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.a("Too many ads visible");
        }
    }
}
