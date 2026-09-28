package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzep extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f36912e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f36913f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Bundle f36914g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f36915h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ zzfb f36916i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzep(zzfb zzfbVar, String str, String str2, Bundle bundle, boolean z) {
        super(zzfbVar, true);
        this.f36912e = str;
        this.f36913f = str2;
        this.f36914g = bundle;
        this.f36915h = z;
        Objects.requireNonNull(zzfbVar);
        this.f36916i = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        ((zzcr) Preconditions.checkNotNull(this.f36916i.f36950g)).logEvent(this.f36912e, this.f36913f, this.f36914g, this.f36915h, true, this.f36917a);
    }
}
