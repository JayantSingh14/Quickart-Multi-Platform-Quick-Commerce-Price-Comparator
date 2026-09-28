package com.facebook.fresco.ui.common;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata
/* loaded from: classes3.dex */
public final class ImagePerfState extends ImagePerfLoggingState {

    /* renamed from: a, reason: collision with root package name */
    public String f17478a;

    /* renamed from: b, reason: collision with root package name */
    public ImageRequest f17479b;

    /* renamed from: c, reason: collision with root package name */
    public Object f17480c;

    /* renamed from: d, reason: collision with root package name */
    public Object f17481d;

    /* renamed from: e, reason: collision with root package name */
    public VisibilityState f17482e;

    public final void a() {
        throw null;
    }

    public final ImagePerfData b() {
        String str = this.f17478a;
        ImageRequest imageRequest = this.f17479b;
        Object obj = this.f17480c;
        Object obj2 = this.f17481d;
        VisibilityState visibilityState = this.f17482e;
        List listE0 = CollectionsKt.e0(null);
        ImageRenderingInfra imageRenderingInfra = ImageRenderingInfra.f17483a;
        return new ImagePerfData(str, imageRequest, obj, obj2, visibilityState, listE0);
    }
}
