package com.facebook.imagepipeline.common;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ResizeOptions {

    /* renamed from: a, reason: collision with root package name */
    public final int f17787a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17788b;

    @Metadata
    public static final class Companion {
    }

    public ResizeOptions(int i2, int i3) {
        this.f17787a = i2;
        this.f17788b = i3;
        if (i2 <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i3 <= 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        return this.f17787a == resizeOptions.f17787a && this.f17788b == resizeOptions.f17788b;
    }

    public final int hashCode() {
        return ((this.f17787a + 31) * 31) + this.f17788b;
    }

    public final String toString() {
        String str = String.format(null, "%dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f17787a), Integer.valueOf(this.f17788b)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
