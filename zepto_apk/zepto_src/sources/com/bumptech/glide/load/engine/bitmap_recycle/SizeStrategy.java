package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.v4.media.b;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

@RequiresApi
/* loaded from: classes3.dex */
final class SizeStrategy implements LruPoolStrategy {

    @VisibleForTesting
    public static final class Key implements Poolable {

        /* renamed from: a, reason: collision with root package name */
        public final KeyPool f16086a;

        public Key(KeyPool keyPool) {
            this.f16086a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void a() {
            this.f16086a.c(this);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            ((Key) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return b.g(0, "[", "]");
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final Poolable a() {
            return new Key(this);
        }
    }

    public final String toString() {
        return "SizeStrategy:\n  null\n  SortedSizesnull";
    }
}
