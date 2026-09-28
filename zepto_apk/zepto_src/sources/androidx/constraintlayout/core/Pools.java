package androidx.constraintlayout.core;

/* loaded from: classes3.dex */
final class Pools {

    public interface Pool<T> {
    }

    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f1684a = new Object[256];

        /* renamed from: b, reason: collision with root package name */
        public int f1685b;

        public final boolean a(ArrayRow arrayRow) {
            int i2 = this.f1685b;
            Object[] objArr = this.f1684a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = arrayRow;
            this.f1685b = i2 + 1;
            return true;
        }
    }
}
