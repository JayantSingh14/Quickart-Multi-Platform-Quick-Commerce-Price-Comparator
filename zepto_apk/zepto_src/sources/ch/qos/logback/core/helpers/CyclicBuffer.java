package ch.qos.logback.core.helpers;

import android.support.v4.media.b;

/* loaded from: classes.dex */
public class CyclicBuffer<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f13480a;

    /* renamed from: b, reason: collision with root package name */
    public int f13481b;

    /* renamed from: c, reason: collision with root package name */
    public int f13482c;

    /* renamed from: d, reason: collision with root package name */
    public int f13483d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13484e;

    public CyclicBuffer(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(b.g(i2, "The maxSize argument (", ") is not a positive integer."));
        }
        this.f13484e = i2;
        this.f13480a = new Object[i2];
        this.f13481b = 0;
        this.f13482c = 0;
        this.f13483d = 0;
    }

    public final void a(Object obj) {
        Object[] objArr = this.f13480a;
        int i2 = this.f13482c;
        objArr[i2] = obj;
        int i3 = i2 + 1;
        this.f13482c = i3;
        int i4 = this.f13484e;
        if (i3 == i4) {
            this.f13482c = 0;
        }
        int i5 = this.f13483d;
        if (i5 < i4) {
            this.f13483d = i5 + 1;
            return;
        }
        int i6 = this.f13481b + 1;
        this.f13481b = i6;
        if (i6 == i4) {
            this.f13481b = 0;
        }
    }
}
