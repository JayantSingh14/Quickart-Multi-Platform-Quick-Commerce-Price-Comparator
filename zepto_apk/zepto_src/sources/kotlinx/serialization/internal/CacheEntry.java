package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

@Metadata
/* loaded from: classes3.dex */
final class CacheEntry<T> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55780a;

    public CacheEntry(KSerializer kSerializer) {
        this.f55780a = kSerializer;
    }
}
