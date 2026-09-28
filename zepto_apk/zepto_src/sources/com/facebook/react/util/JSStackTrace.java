package com.facebook.react.util;

import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class JSStackTrace {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f19925a = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(java.lang.String r7, com.facebook.react.bridge.ReadableArray r8) {
        /*
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "stack"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            java.lang.String r7 = ", stack:\n"
            r0.append(r7)
            int r7 = r8.size()
            r1 = 0
        L19:
            if (r1 >= r7) goto Lb5
            com.facebook.react.bridge.ReadableMap r2 = r8.getMap(r1)
            if (r2 != 0) goto L23
            goto Lb1
        L23:
            java.lang.String r3 = "methodName"
            java.lang.String r3 = r2.getString(r3)
            r0.append(r3)
            java.lang.String r3 = "@"
            r0.append(r3)
            java.lang.String r3 = "file"
            boolean r4 = r2.hasKey(r3)
            java.lang.String r5 = ":"
            if (r4 == 0) goto L65
            boolean r4 = r2.isNull(r3)
            if (r4 != 0) goto L65
            com.facebook.react.bridge.ReadableType r4 = r2.getType(r3)
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.String
            if (r4 != r6) goto L65
            java.lang.String r3 = r2.getString(r3)
            if (r3 == 0) goto L65
            java.util.regex.Pattern r4 = com.facebook.react.util.JSStackTrace.f19925a
            java.util.regex.Matcher r3 = r4.matcher(r3)
            boolean r4 = r3.find()
            if (r4 == 0) goto L65
            r4 = 1
            java.lang.String r3 = r3.group(r4)
            java.lang.String r3 = android.support.v4.media.b.k(r3, r5)
            goto L67
        L65:
            java.lang.String r3 = ""
        L67:
            r0.append(r3)
            java.lang.String r3 = "lineNumber"
            boolean r4 = r2.hasKey(r3)
            if (r4 == 0) goto L88
            boolean r4 = r2.isNull(r3)
            if (r4 != 0) goto L88
            com.facebook.react.bridge.ReadableType r4 = r2.getType(r3)
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Number
            if (r4 != r6) goto L88
            int r3 = r2.getInt(r3)
            r0.append(r3)
            goto L8c
        L88:
            r3 = -1
            r0.append(r3)
        L8c:
            java.lang.String r3 = "column"
            boolean r4 = r2.hasKey(r3)
            if (r4 == 0) goto Lac
            boolean r4 = r2.isNull(r3)
            if (r4 != 0) goto Lac
            com.facebook.react.bridge.ReadableType r4 = r2.getType(r3)
            com.facebook.react.bridge.ReadableType r6 = com.facebook.react.bridge.ReadableType.Number
            if (r4 != r6) goto Lac
            r0.append(r5)
            int r2 = r2.getInt(r3)
            r0.append(r2)
        Lac:
            java.lang.String r2 = "\n"
            r0.append(r2)
        Lb1:
            int r1 = r1 + 1
            goto L19
        Lb5:
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.util.JSStackTrace.a(java.lang.String, com.facebook.react.bridge.ReadableArray):java.lang.String");
    }
}
