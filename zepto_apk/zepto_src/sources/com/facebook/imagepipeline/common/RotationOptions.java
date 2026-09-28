package com.facebook.imagepipeline.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RotationOptions {

    /* renamed from: c, reason: collision with root package name */
    public static final RotationOptions f17789c = new RotationOptions(-1, false);

    /* renamed from: d, reason: collision with root package name */
    public static final RotationOptions f17790d = new RotationOptions(-1, true);

    /* renamed from: a, reason: collision with root package name */
    public final int f17791a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17792b;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface Rotation {
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface RotationAngle {
    }

    public RotationOptions(int i2, boolean z) {
        this.f17791a = i2;
        this.f17792b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        return this.f17791a == rotationOptions.f17791a && this.f17792b == rotationOptions.f17792b;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.f17791a);
        Boolean boolValueOf = Boolean.valueOf(this.f17792b);
        return ((numValueOf.hashCode() + 31) * 31) + boolValueOf.hashCode();
    }

    public final String toString() {
        String str = String.format(null, "%d defer:%b", Arrays.copyOf(new Object[]{Integer.valueOf(this.f17791a), Boolean.valueOf(this.f17792b)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
