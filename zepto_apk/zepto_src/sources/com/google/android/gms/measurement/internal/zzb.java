package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f38745a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f38746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzd f38747c;

    public zzb(zzd zzdVar, String str, long j2) {
        this.f38745a = str;
        this.f38746b = j2;
        Objects.requireNonNull(zzdVar);
        this.f38747c = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.f38747c;
        zzdVar.g();
        String str = this.f38745a;
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = zzdVar.f38819c;
        Integer num = (Integer) arrayMap.get(str);
        zzib zzibVar = zzdVar.f39180a;
        if (num == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(str, "Call to endAdUnitExposure for unknown ad unit id");
            return;
        }
        zzma zzmaVar = zzibVar.f39095l;
        zzib.k(zzmaVar);
        zzlt zzltVarM = zzmaVar.m(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            arrayMap.put(str, Integer.valueOf(iIntValue));
            return;
        }
        arrayMap.remove(str);
        ArrayMap arrayMap2 = zzdVar.f38818b;
        Long l2 = (Long) arrayMap2.get(str);
        long j2 = this.f38746b;
        zzgt zzgtVar2 = zzibVar.f39089f;
        if (l2 == null) {
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j2 - l2.longValue();
            arrayMap2.remove(str);
            zzdVar.l(str, jLongValue, zzltVarM);
        }
        if (arrayMap.isEmpty()) {
            long j3 = zzdVar.f38820d;
            if (j3 == 0) {
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.a("First ad exposure time was never set");
            } else {
                zzdVar.k(j2 - j3, zzltVarM);
                zzdVar.f38820d = 0L;
            }
        }
    }
}
