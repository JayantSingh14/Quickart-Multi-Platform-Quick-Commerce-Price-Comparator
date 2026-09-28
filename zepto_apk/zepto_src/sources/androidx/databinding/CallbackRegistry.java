package androidx.databinding;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3354a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public long f3355b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long[] f3356c;

    /* renamed from: d, reason: collision with root package name */
    public int f3357d;

    /* renamed from: e, reason: collision with root package name */
    public final NotifierCallback f3358e;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void a(Object obj, ObservableList observableList, int i2, Object obj2);
    }

    public CallbackRegistry(NotifierCallback notifierCallback) {
        this.f3358e = notifierCallback;
    }

    public synchronized void a(int i2, Object obj, Object obj2) throws Throwable {
        try {
            try {
                this.f3357d++;
                int size = this.f3354a.size();
                int length = this.f3356c == null ? -1 : r0.length - 1;
                c((ObservableList) obj, i2, obj2, length);
                b((ObservableList) obj, i2, obj2, (length + 2) * 64, size, 0L);
                int i3 = this.f3357d - 1;
                this.f3357d = i3;
                if (i3 == 0) {
                    long[] jArr = this.f3356c;
                    if (jArr != null) {
                        for (int length2 = jArr.length - 1; length2 >= 0; length2--) {
                            long j2 = this.f3356c[length2];
                            if (j2 != 0) {
                                d((length2 + 1) * 64, j2);
                                this.f3356c[length2] = 0;
                            }
                        }
                    }
                    long j3 = this.f3355b;
                    if (j3 != 0) {
                        d(0, j3);
                        this.f3355b = 0L;
                    }
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final void b(ObservableList observableList, int i2, Object obj, int i3, int i4, long j2) {
        long j3 = 1;
        while (i3 < i4) {
            if ((j2 & j3) == 0) {
                this.f3358e.a(this.f3354a.get(i3), observableList, i2, obj);
            }
            j3 <<= 1;
            i3++;
        }
    }

    public final void c(ObservableList observableList, int i2, Object obj, int i3) {
        if (i3 < 0) {
            b(observableList, i2, obj, 0, Math.min(64, this.f3354a.size()), this.f3355b);
            return;
        }
        long j2 = this.f3356c[i3];
        int i4 = (i3 + 1) * 64;
        int iMin = Math.min(this.f3354a.size(), i4 + 64);
        c(observableList, i2, obj, i3 - 1);
        b(observableList, i2, obj, i4, iMin, j2);
    }

    public final Object clone() {
        CallbackRegistry callbackRegistry;
        CloneNotSupportedException e2;
        int i2;
        synchronized (this) {
            try {
                callbackRegistry = (CallbackRegistry) super.clone();
                try {
                    callbackRegistry.f3355b = 0L;
                    callbackRegistry.f3356c = null;
                    callbackRegistry.f3357d = 0;
                    callbackRegistry.f3354a = new ArrayList();
                    int size = this.f3354a.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (i3 >= 64) {
                            long[] jArr = this.f3356c;
                            if (jArr != null && (i3 / 64) - 1 < jArr.length) {
                                if (((1 << (i3 % 64)) & jArr[i2]) != 0) {
                                }
                            }
                            callbackRegistry.f3354a.add(this.f3354a.get(i3));
                        } else if (((1 << i3) & this.f3355b) == 0) {
                            callbackRegistry.f3354a.add(this.f3354a.get(i3));
                        }
                    }
                } catch (CloneNotSupportedException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return callbackRegistry;
                }
            } catch (CloneNotSupportedException e4) {
                callbackRegistry = null;
                e2 = e4;
            }
        }
        return callbackRegistry;
    }

    public final void d(int i2, long j2) {
        long j3 = Long.MIN_VALUE;
        for (int i3 = i2 + 63; i3 >= i2; i3--) {
            if ((j2 & j3) != 0) {
                this.f3354a.remove(i3);
            }
            j3 >>>= 1;
        }
    }
}
