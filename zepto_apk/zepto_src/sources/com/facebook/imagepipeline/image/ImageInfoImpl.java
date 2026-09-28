package com.facebook.imagepipeline.image;

import com.facebook.infer.annotation.Nullsafe;
import java.util.HashMap;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public class ImageInfoImpl implements ImageInfo {

    /* renamed from: a, reason: collision with root package name */
    public final int f17967a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17968b;

    /* renamed from: c, reason: collision with root package name */
    public final QualityInfo f17969c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f17970d;

    public ImageInfoImpl(int i2, int i3, QualityInfo qualityInfo, HashMap map) {
        this.f17967a = i2;
        this.f17968b = i3;
        this.f17969c = qualityInfo;
        this.f17970d = map;
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata, com.facebook.fresco.middleware.HasExtraData
    public final Map getExtras() {
        return this.f17970d;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getHeight() {
        return this.f17968b;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getWidth() {
        return this.f17967a;
    }
}
