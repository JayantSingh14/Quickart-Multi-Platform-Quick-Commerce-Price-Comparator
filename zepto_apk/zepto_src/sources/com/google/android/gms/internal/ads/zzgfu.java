package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
final class zzgfu extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Context f32486f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f32487g;

    public zzgfu(zzavs zzavsVar, zzgev zzgevVar, Map map, Context context, zzgnc zzgncVar) {
        super("7lU8u/acj3glwX97dsCp50xaNaDZf5AvZZ8CZCZNZxVmN9GtRvkGNhtjwrrwJvh7", "R2aDW6OJL1JMomVNIKoK9g6amqmi0+KEXVHpRQdnX+U=", zzavsVar, zzgevVar, zzgncVar.a(120));
        this.f32486f = context;
        this.f32487g = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Long lValueOf = -1L;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                Long l2 = (Long) method.invoke("", this.f32486f);
                if (l2 == null) {
                    throw null;
                }
                lValueOf = l2;
            } else {
                ListenableFuture listenableFuture = (ListenableFuture) this.f32487g.get("gs");
                if (listenableFuture != null && listenableFuture.isDone()) {
                    lValueOf = Long.valueOf(((zzawp) listenableFuture.get()).B0());
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        synchronized (zzavsVar) {
            long jLongValue = lValueOf.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).e0(jLongValue);
        }
    }
}
