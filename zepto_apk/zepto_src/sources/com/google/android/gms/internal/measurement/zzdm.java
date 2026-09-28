package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdm extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzdf f36856e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36857f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f36858g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzfb f36859h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdm(zzfb zzfbVar, zzdf zzdfVar, String str, String str2) {
        super(zzfbVar, true);
        this.f36856e = zzdfVar;
        this.f36857f = str;
        this.f36858g = str2;
        Objects.requireNonNull(zzfbVar);
        this.f36859h = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36859h.f36950g)).setCurrentScreenByScionActivityInfo(this.f36856e, this.f36857f, this.f36858g, this.f36917a);
    }
}
