package com.facebook.imagepipeline.xml;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.DefaultCloseableXml;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class XmlFormatDecoder implements ImageDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f18390a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f18391b;

    @Metadata
    public static final class Companion {
    }

    public XmlFormatDecoder(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f18390a = resources;
        this.f18391b = new ConcurrentHashMap();
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage a(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions options) {
        String str;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            str = encodedImage.f17966k;
        } catch (Throwable th) {
            FLog.h("XmlFormatDecoder", "Cannot decode xml", th);
        }
        if (str == null) {
            throw new IllegalStateException("No source in encoded image");
        }
        Drawable drawableC = ResourcesCompat.c(this.f18390a, b(str), null);
        if (drawableC != null) {
            DefaultCloseableXml defaultCloseableXml = new DefaultCloseableXml();
            defaultCloseableXml.f17954d = drawableC;
            return defaultCloseableXml;
        }
        return null;
    }

    public final int b(String str) {
        Integer intOrNull;
        ConcurrentHashMap concurrentHashMap = this.f18391b;
        Object obj = concurrentHashMap.get(str);
        if (obj == null) {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            if (!"res".equals(UriUtil.b(uri)) && !"android.resource".equals(UriUtil.b(uri))) {
                throw new IllegalStateException(("Unsupported uri " + uri).toString());
            }
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
            String str2 = (String) CollectionsKt.G(pathSegments);
            if (str2 == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) {
                throw new IllegalStateException(("Unable to read resource ID from " + uri.getPath()).toString());
            }
            concurrentHashMap.put(str, intOrNull);
            obj = intOrNull;
        }
        return ((Number) obj).intValue();
    }
}
