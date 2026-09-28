package com.bumptech.glide.util.pool;

/* loaded from: classes3.dex */
public abstract class StateVerifier {

    public static class DebugStateVerifier extends StateVerifier {
        @Override // com.bumptech.glide.util.pool.StateVerifier
        public final void b() {
            throw null;
        }
    }

    public static class DefaultStateVerifier extends StateVerifier {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f16535a;

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public final void b() {
            if (this.f16535a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static StateVerifier a() {
        return new DefaultStateVerifier();
    }

    public abstract void b();
}
