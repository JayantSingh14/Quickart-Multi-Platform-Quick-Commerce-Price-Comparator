package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import java.util.LinkedHashSet;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;

@ThreadSafe
@Metadata
/* loaded from: classes.dex */
public final class BoundedLinkedHashSet<E> {

    /* renamed from: a, reason: collision with root package name */
    public final int f17728a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f17729b;

    public BoundedLinkedHashSet(int i2) {
        this.f17728a = i2;
        this.f17729b = new LinkedHashSet(i2);
    }

    public final synchronized void a(CacheKey cacheKey) {
        try {
            if (this.f17729b.size() == this.f17728a) {
                LinkedHashSet linkedHashSet = this.f17729b;
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            this.f17729b.remove(cacheKey);
            this.f17729b.add(cacheKey);
        } catch (Throwable th) {
            throw th;
        }
    }
}
