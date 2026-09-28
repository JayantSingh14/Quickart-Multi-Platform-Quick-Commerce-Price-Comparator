package com.zeptoconsumerapp.modules.image;

import android.net.Uri;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FrescoCacheKeyFactory extends DefaultCacheKeyFactory {
    @Override // com.facebook.imagepipeline.cache.DefaultCacheKeyFactory
    public final Uri e(Uri sourceUri) {
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        String string = sourceUri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return Uri.parse(ImageUtils.a(string));
    }
}
