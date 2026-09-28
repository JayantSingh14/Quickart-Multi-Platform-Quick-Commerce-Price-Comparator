package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
final class zzazn implements zzfvz {

    /* renamed from: a, reason: collision with root package name */
    public final zzfuh f24542a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfuv f24543b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbaa f24544c;

    /* renamed from: d, reason: collision with root package name */
    public final zzazm f24545d;

    /* renamed from: e, reason: collision with root package name */
    public final zzayw f24546e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbac f24547f;

    /* renamed from: g, reason: collision with root package name */
    public final zzazu f24548g;

    /* renamed from: h, reason: collision with root package name */
    public final zzazl f24549h;

    public zzazn(zzfuh zzfuhVar, zzfuv zzfuvVar, zzbaa zzbaaVar, zzazm zzazmVar, zzayw zzaywVar, zzbac zzbacVar, zzazu zzazuVar, zzazl zzazlVar) {
        this.f24542a = zzfuhVar;
        this.f24543b = zzfuvVar;
        this.f24544c = zzbaaVar;
        this.f24545d = zzazmVar;
        this.f24546e = zzaywVar;
        this.f24547f = zzbacVar;
        this.f24548g = zzazuVar;
        this.f24549h = zzazlVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0119 A[Catch: all -> 0x00fd, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {all -> 0x00fd, blocks: (B:12:0x00ee, B:14:0x00f2, B:16:0x00f9, B:20:0x00ff, B:22:0x0108, B:24:0x010c, B:26:0x0115, B:28:0x0119), top: B:41:0x00ee }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.HashMap a() {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazn.a():java.util.HashMap");
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzb() {
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzc() {
        HashMap mapA = a();
        zzazl zzazlVar = this.f24549h;
        if (zzazlVar != null) {
            List list = zzazlVar.f24540a;
            zzazlVar.f24540a = Collections.EMPTY_LIST;
            mapA.put("vst", list);
        }
        return mapA;
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zzd() {
        HashMap mapA = a();
        zzbaa zzbaaVar = this.f24544c;
        if (zzbaaVar.f24619l <= -2) {
            WeakReference weakReference = zzbaaVar.f24615h;
            if ((weakReference != null ? (View) weakReference.get() : null) == null) {
                zzbaaVar.f24619l = -3L;
            }
        }
        mapA.put("lts", Long.valueOf(zzbaaVar.f24619l));
        return mapA;
    }

    @Override // com.google.android.gms.internal.ads.zzfvz
    public final HashMap zze() {
        HashMap map = new HashMap();
        map.put("t", new Throwable());
        return map;
    }
}
