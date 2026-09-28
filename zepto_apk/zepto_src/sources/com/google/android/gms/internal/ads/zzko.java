package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

@RequiresApi
/* loaded from: classes4.dex */
final class zzko {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f35032a;

    /* renamed from: b, reason: collision with root package name */
    public final IntConsumer f35033b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzkp f35034c;

    public /* synthetic */ zzko(zzkp zzkpVar, Context context) {
        Objects.requireNonNull(zzkpVar);
        this.f35034c = zzkpVar;
        this.f35032a = new WeakReference(context);
        IntConsumer intConsumer = new IntConsumer() { // from class: com.google.android.gms.internal.ads.zzkm
            @Override // java.util.function.IntConsumer
            public final /* synthetic */ void accept(int i2) {
                zzkp zzkpVar2 = this.f35030a.f35034c;
                if (zzkpVar2.V) {
                    return;
                }
                zzkpVar2.p(1, 19, Integer.valueOf(i2));
            }
        };
        this.f35033b = intConsumer;
        final zzdx zzdxVarA = zzkpVar.u.a(zzkpVar.s, null);
        context.registerDeviceIdChangeListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzkn
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                zzdxVarA.e(runnable);
            }
        }, intConsumer);
    }
}
