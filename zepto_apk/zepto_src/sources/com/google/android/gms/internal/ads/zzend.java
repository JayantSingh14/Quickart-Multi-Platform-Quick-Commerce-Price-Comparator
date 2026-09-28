package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzend implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzejj f29854a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29855b;

    public zzend(zzene zzeneVar, zzejj zzejjVar, zzfhr zzfhrVar) {
        this.f29854a = zzejjVar;
        this.f29855b = zzfhrVar;
        Objects.requireNonNull(zzeneVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) throws zzfir, zzdlg {
        try {
            zzfji zzfjiVar = (zzfji) this.f29854a.f29463b;
            zzfjiVar.b(z);
            try {
                zzfjiVar.f31270a.Y8(new ObjectWrapper(context));
            } catch (Throwable th) {
                throw new zzfir(th);
            }
        } catch (zzfir e2) {
            throw new zzdlg(e2.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29855b;
    }
}
