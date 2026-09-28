package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzaz implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzai f36779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzg f36780b;

    public zzaz(zzai zzaiVar, zzg zzgVar) {
        this.f36779a = zzaiVar;
        this.f36780b = zzgVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzao zzaoVar = (zzao) obj;
        zzao zzaoVar2 = (zzao) obj2;
        if (zzaoVar instanceof zzat) {
            return !(zzaoVar2 instanceof zzat) ? 1 : 0;
        }
        if (zzaoVar2 instanceof zzat) {
            return -1;
        }
        zzai zzaiVar = this.f36779a;
        return zzaiVar == null ? zzaoVar.zzc().compareTo(zzaoVar2.zzc()) : (int) zzh.h(zzaiVar.a(this.f36780b, Arrays.asList(zzaoVar, zzaoVar2)).zzd().doubleValue());
    }
}
