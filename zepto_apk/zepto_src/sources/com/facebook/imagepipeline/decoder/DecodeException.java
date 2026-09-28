package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DecodeException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final EncodedImage f17928a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeException(String str, EncodedImage encodedImage) {
        super(str);
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        this.f17928a = encodedImage;
    }
}
