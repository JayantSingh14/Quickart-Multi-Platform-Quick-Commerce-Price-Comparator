package com.facebook.imageformat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImageFormat {

    /* renamed from: c, reason: collision with root package name */
    public static final ImageFormat f17694c = new ImageFormat("UNKNOWN", null);

    /* renamed from: a, reason: collision with root package name */
    public final String f17695a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17696b;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface FormatChecker {
    }

    public ImageFormat(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f17695a = name;
        this.f17696b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFormat)) {
            return false;
        }
        ImageFormat imageFormat = (ImageFormat) obj;
        return Intrinsics.b(this.f17695a, imageFormat.f17695a) && Intrinsics.b(this.f17696b, imageFormat.f17696b);
    }

    public final int hashCode() {
        int iHashCode = this.f17695a.hashCode() * 31;
        String str = this.f17696b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return this.f17695a;
    }
}
