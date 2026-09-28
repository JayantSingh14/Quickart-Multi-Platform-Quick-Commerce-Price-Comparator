package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdso implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f28444a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28445b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbnn f28446c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdsp f28447d;

    public /* synthetic */ zzdso(zzdsp zzdspVar, WeakReference weakReference, String str, zzbnn zzbnnVar) {
        Objects.requireNonNull(zzdspVar);
        this.f28447d = zzdspVar;
        this.f28444a = weakReference;
        this.f28445b = str;
        this.f28446c = zzbnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        Object obj2 = this.f28444a.get();
        if (obj2 == null) {
            this.f28447d.c(this.f28445b, this);
        } else {
            this.f28446c.a(obj2, map);
        }
    }
}
