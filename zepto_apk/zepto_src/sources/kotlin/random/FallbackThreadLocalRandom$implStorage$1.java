package kotlin.random;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<java.util.Random> {
    @Override // java.lang.ThreadLocal
    public final java.util.Random initialValue() {
        return new java.util.Random();
    }
}
