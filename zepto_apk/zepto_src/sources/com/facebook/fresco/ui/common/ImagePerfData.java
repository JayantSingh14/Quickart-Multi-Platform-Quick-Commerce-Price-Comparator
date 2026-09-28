package com.facebook.fresco.ui.common;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImagePerfData {

    /* renamed from: a, reason: collision with root package name */
    public final Object f17475a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17476b;

    /* renamed from: c, reason: collision with root package name */
    public final List f17477c;

    @Metadata
    public static final class Companion {
    }

    public ImagePerfData(String str, ImageRequest imageRequest, Object obj, Object obj2, VisibilityState visibilityState, List intermediateImageSetTimes) {
        ImageRenderingInfra infra = ImageRenderingInfra.f17483a;
        Intrinsics.checkNotNullParameter(infra, "infra");
        Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
        Intrinsics.checkNotNullParameter(intermediateImageSetTimes, "intermediateImageSetTimes");
        this.f17475a = obj;
        this.f17476b = obj2;
        this.f17477c = intermediateImageSetTimes;
    }
}
