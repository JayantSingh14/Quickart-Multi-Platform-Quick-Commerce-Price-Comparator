package com.bumptech.glide.request.target;

import android.support.v4.media.b;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Util;

@Deprecated
/* loaded from: classes3.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: b, reason: collision with root package name */
    public final int f16498b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final int f16499c = Integer.MIN_VALUE;

    @Override // com.bumptech.glide.request.target.Target
    public final void c(SingleRequest singleRequest) throws Throwable {
        int i2 = this.f16498b;
        int i3 = this.f16499c;
        if (!Util.h(i2, i3)) {
            throw new IllegalArgumentException(b.e(i2, i3, "Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ", " and height: ", ", either provide dimensions in the constructor or call override()"));
        }
        singleRequest.a(i2, i3);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(SingleRequest singleRequest) {
    }
}
