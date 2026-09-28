package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class KotlinRandom extends java.util.Random {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Companion f53816a = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // java.util.Random
    public final int next(int i2) {
        throw null;
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        throw null;
    }

    @Override // java.util.Random
    public final void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        throw null;
    }

    @Override // java.util.Random
    public final double nextDouble() {
        throw null;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        throw null;
    }

    @Override // java.util.Random
    public final int nextInt() {
        throw null;
    }

    @Override // java.util.Random
    public final long nextLong() {
        throw null;
    }

    @Override // java.util.Random
    public final void setSeed(long j2) {
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public final int nextInt(int i2) {
        throw null;
    }
}
