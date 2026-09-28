package com.facebook.common.media;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes3.dex */
public final class MediaUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f17088a = MapsKt.h(new Pair("mkv", "video/x-matroska"), new Pair("glb", "model/gltf-binary"));

    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, java.util.Map] */
    public static final String a(String path) {
        String strSubstring;
        Intrinsics.checkNotNullParameter(path, "path");
        int iB = StringsKt.B(path, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, 6);
        if (iB < 0 || iB == path.length() - 1) {
            strSubstring = null;
        } else {
            strSubstring = path.substring(iB + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        if (strSubstring != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strSubstring.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String mimeTypeFromExtension = (String) MimeTypeMapWrapper.f17091c.get(lowerCase);
                if (mimeTypeFromExtension == null) {
                    mimeTypeFromExtension = MimeTypeMapWrapper.f17089a.getMimeTypeFromExtension(lowerCase);
                }
                return mimeTypeFromExtension == null ? (String) f17088a.get(lowerCase) : mimeTypeFromExtension;
            }
        }
        return null;
    }

    public static final boolean b(String str) {
        if (str != null) {
            return StringsKt.O(str, "video/", false);
        }
        return false;
    }
}
