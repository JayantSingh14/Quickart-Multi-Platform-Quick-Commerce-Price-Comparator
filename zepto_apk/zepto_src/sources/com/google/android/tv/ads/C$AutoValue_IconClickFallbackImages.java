package com.google.android.tv.ads;

import android.support.v4.media.b;
import java.util.AbstractCollection;
import java.util.List;

/* renamed from: com.google.android.tv.ads.$AutoValue_IconClickFallbackImages, reason: invalid class name */
/* loaded from: classes4.dex */
abstract class C$AutoValue_IconClickFallbackImages extends IconClickFallbackImages {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractCollection f42208a;

    /* JADX WARN: Multi-variable type inference failed */
    public C$AutoValue_IconClickFallbackImages(List list) {
        if (list == 0) {
            throw new NullPointerException("Null iconClickFallbackImageList");
        }
        this.f42208a = (AbstractCollection) list;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // com.google.android.tv.ads.IconClickFallbackImages
    public final List b() {
        return this.f42208a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IconClickFallbackImages) {
            return this.f42208a.equals(((IconClickFallbackImages) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return this.f42208a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return b.D("IconClickFallbackImages{iconClickFallbackImageList=", this.f42208a.toString(), "}");
    }
}
