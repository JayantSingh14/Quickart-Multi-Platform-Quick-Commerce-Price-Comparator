package com.facebook.imageutils;

import android.graphics.ColorSpace;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata
/* loaded from: classes3.dex */
public final class ImageMetaData {

    /* renamed from: a, reason: collision with root package name */
    public final ColorSpace f18394a;

    /* renamed from: b, reason: collision with root package name */
    public final Pair f18395b;

    public ImageMetaData(int i2, int i3, ColorSpace colorSpace) {
        this.f18394a = colorSpace;
        this.f18395b = (i2 == -1 || i3 == -1) ? null : new Pair(Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
