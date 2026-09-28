package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class Pools {

    @Metadata
    /* loaded from: classes.dex */
    public interface Pool<T> {
        boolean a(Object obj);

        Object b();
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f2991a;

        /* renamed from: b, reason: collision with root package name */
        public int f2992b;

        public SimplePool(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2991a = new Object[i2];
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean a(Object instance) {
            Object[] objArr;
            boolean z;
            Intrinsics.checkNotNullParameter(instance, "instance");
            int i2 = this.f2992b;
            int i3 = 0;
            while (true) {
                objArr = this.f2991a;
                if (i3 >= i2) {
                    z = false;
                    break;
                }
                if (objArr[i3] == instance) {
                    z = true;
                    break;
                }
                i3++;
            }
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i4 = this.f2992b;
            if (i4 >= objArr.length) {
                return false;
            }
            objArr[i4] = instance;
            this.f2992b = i4 + 1;
            return true;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object b() {
            int i2 = this.f2992b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            Object[] objArr = this.f2991a;
            Object obj = objArr[i3];
            Intrinsics.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            objArr[i3] = null;
            this.f2992b--;
            return obj;
        }
    }

    @Metadata
    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: c, reason: collision with root package name */
        public final Object f2993c;

        public SynchronizedPool(int i2) {
            super(i2);
            this.f2993c = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final boolean a(Object instance) {
            boolean zA;
            Intrinsics.checkNotNullParameter(instance, "instance");
            synchronized (this.f2993c) {
                zA = super.a(instance);
            }
            return zA;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final Object b() {
            Object objB;
            synchronized (this.f2993c) {
                objB = super.b();
            }
            return objB;
        }
    }
}
