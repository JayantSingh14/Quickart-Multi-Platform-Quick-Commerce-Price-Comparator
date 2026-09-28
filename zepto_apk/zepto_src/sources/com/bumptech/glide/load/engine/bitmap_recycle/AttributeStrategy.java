package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.v4.media.b;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes3.dex */
class AttributeStrategy implements LruPoolStrategy {

    @VisibleForTesting
    public static class Key implements Poolable {

        /* renamed from: a, reason: collision with root package name */
        public final KeyPool f16047a;

        public Key(KeyPool keyPool) {
            this.f16047a = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void a() {
            this.f16047a.c(this);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            ((Key) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return (((0 * 31) + 0) * 31) + 0;
        }

        public final String toString() {
            StringBuilder sbT = b.t(0, 0, "[", "x", "], ");
            sbT.append((Object) null);
            return sbT.toString();
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
        return "AttributeStrategy:\n  null";
    }
}
