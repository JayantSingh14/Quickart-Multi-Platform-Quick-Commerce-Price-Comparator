package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata
/* loaded from: classes3.dex */
public final class LruCacheKt$lruCache$4 extends LruCache<Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function2<Object, Object, Integer> f2986a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1<Object, Object> f2987b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function4<Boolean, Object, Object, Object, Unit> f2988c;

    @Override // android.util.LruCache
    public final Object create(Object obj) {
        return this.f2987b.invoke(obj);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        this.f2988c.d(Boolean.valueOf(z), obj, obj2, obj3);
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        return ((Number) this.f2986a.invoke(obj, obj2)).intValue();
    }
}
