package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeju implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzejj f29507a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29508b;

    public zzeju(zzejv zzejvVar, zzejj zzejjVar, zzfhr zzfhrVar) {
        this.f29507a = zzejjVar;
        this.f29508b = zzfhrVar;
        Objects.requireNonNull(zzejvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) throws zzfir, zzdlg {
        try {
            zzfji zzfjiVar = (zzfji) this.f29507a.f29463b;
            zzfjiVar.b(z);
            try {
                zzfjiVar.f31270a.n4(new ObjectWrapper(context));
            } catch (Throwable th) {
                throw new zzfir(th);
            }
        } catch (zzfir e2) {
            throw new zzdlg(e2.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29508b;
    }
}
