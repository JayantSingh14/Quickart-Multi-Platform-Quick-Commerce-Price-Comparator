package com.facebook.imageformat;

import coil3.decode.b;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ImageFormatChecker {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f17697d = LazyKt.a(LazyThreadSafetyMode.f53528a, new b(7));

    /* renamed from: c, reason: collision with root package name */
    public boolean f17700c;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultImageFormatChecker f17699b = new DefaultImageFormatChecker();

    /* renamed from: a, reason: collision with root package name */
    public int f17698a = this.f17699b.f17680a;

    @Metadata
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:102:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.Lazy] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.facebook.imageformat.ImageFormat a(java.io.InputStream r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 426
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageformat.ImageFormatChecker.Companion.a(java.io.InputStream):com.facebook.imageformat.ImageFormat");
        }
    }

    public static final ImageFormat a(InputStream is) {
        Intrinsics.checkNotNullParameter(is, "is");
        try {
            return Companion.a(is);
        } catch (IOException e2) {
            Throwables.b(e2);
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public static final ImageFormatChecker b() {
        return (ImageFormatChecker) f17697d.getValue();
    }

    public final void c() {
        this.f17700c = true;
    }
}
