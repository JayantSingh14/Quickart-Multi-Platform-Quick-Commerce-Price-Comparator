package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes.dex */
class Bucket<V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f18002a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18003b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList f18004c;

    /* renamed from: d, reason: collision with root package name */
    public int f18005d;

    public Bucket(int i2, int i3, int i4) {
        Preconditions.e(i2 > 0);
        Preconditions.e(i3 >= 0);
        Preconditions.e(i4 >= 0);
        this.f18002a = i2;
        this.f18003b = i3;
        this.f18004c = new LinkedList();
        this.f18005d = i4;
    }

    public void a(Object obj) {
        this.f18004c.add(obj);
    }

    public Object b() {
        return this.f18004c.poll();
    }
}
