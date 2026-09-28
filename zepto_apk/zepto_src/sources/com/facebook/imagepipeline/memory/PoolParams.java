package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class PoolParams {

    /* renamed from: a, reason: collision with root package name */
    public final int f18057a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18058b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseIntArray f18059c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18060d;

    public PoolParams(int i2, int i3, SparseIntArray sparseIntArray, int i4) {
        Preconditions.e(i2 >= 0 && i3 >= i2);
        this.f18058b = i2;
        this.f18057a = i3;
        this.f18059c = sparseIntArray;
        this.f18060d = i4;
    }
}
