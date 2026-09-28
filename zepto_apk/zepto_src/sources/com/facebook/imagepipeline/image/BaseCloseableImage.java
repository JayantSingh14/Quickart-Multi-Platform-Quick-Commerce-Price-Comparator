package com.facebook.imagepipeline.image;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseCloseableImage implements CloseableImage {

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f17945c = new HashSet(Arrays.asList("encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded", "non_fatal_decode_error", "original_url", "modified_url", "image_color_space"));

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f17946a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public ImageInfoImpl f17947b;

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final void N(Map map) {
        if (map == null) {
            return;
        }
        Iterator it = f17945c.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = map.get(str);
            if (obj != null) {
                this.f17946a.put(str, obj);
            }
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final void V(Object obj, String str) {
        Boolean bool = Boolean.FALSE;
        if (f17945c.contains("is_rounded")) {
            this.f17946a.put("is_rounded", bool);
        }
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata, com.facebook.fresco.middleware.HasExtraData
    public final Map getExtras() {
        return this.f17946a;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public QualityInfo q1() {
        return ImmutableQualityInfo.f17971d;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final ImageInfo t1() {
        if (this.f17947b == null) {
            int width = getWidth();
            int height = getHeight();
            B0();
            this.f17947b = new ImageInfoImpl(width, height, q1(), this.f17946a);
        }
        return this.f17947b;
    }
}
