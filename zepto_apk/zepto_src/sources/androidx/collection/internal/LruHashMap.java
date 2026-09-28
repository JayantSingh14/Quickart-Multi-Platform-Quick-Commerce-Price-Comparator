package androidx.collection.internal;

import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class LruHashMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1613a;

    public LruHashMap(int i2) {
        this.f1613a = new LinkedHashMap(i2, 0.75f, true);
    }

    public LruHashMap() {
        this(16);
    }
}
