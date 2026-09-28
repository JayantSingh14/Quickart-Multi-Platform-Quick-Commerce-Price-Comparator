package com.reactnativedocumentpicker;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class PickOptionsKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.reactnativedocumentpicker.PickOptions a(com.facebook.react.bridge.ReadableMap r10) {
        /*
            java.lang.String r0 = "readableMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "mode"
            java.lang.String r2 = r10.getString(r0)
            java.lang.String r0 = "type"
            boolean r1 = r10.hasKey(r0)
        */
        //  java.lang.String r3 = "*/*"
        /*
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L66
            boolean r1 = r10.isNull(r0)
            if (r1 != 0) goto L66
            com.facebook.react.bridge.ReadableArray r0 = r10.getArray(r0)
            if (r0 == 0) goto L61
            java.lang.String r1 = "readableArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.ArrayList r0 = r0.toArrayList()
            java.util.ArrayList r1 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.r(r0, r6)
            r1.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
        L3b:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L54
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = android.content.Intent.normalizeMimeType(r6)
            kotlin.jvm.internal.Intrinsics.c(r6)
            r1.add(r6)
            goto L3b
        L54:
            java.lang.String[] r0 = new java.lang.String[r5]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 != 0) goto L5f
            goto L61
        L5f:
            r3 = r0
            goto L6b
        L61:
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r5] = r3
            goto L5f
        L66:
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r5] = r3
            goto L5f
        L6b:
            java.lang.String r0 = "initialDirectoryUrl"
            boolean r1 = r10.hasKey(r0)
            if (r1 == 0) goto L78
            java.lang.String r0 = r10.getString(r0)
            goto L79
        L78:
            r0 = 0
        L79:
            java.lang.String r1 = "localOnly"
            boolean r6 = r10.hasKey(r1)
            if (r6 == 0) goto L8a
            boolean r1 = r10.getBoolean(r1)
            if (r1 == 0) goto L8a
            r1 = r5
            r5 = r4
            goto L8b
        L8a:
            r1 = r5
        L8b:
            java.lang.String r6 = "allowMultiSelection"
            boolean r7 = r10.hasKey(r6)
            if (r7 == 0) goto L9b
            boolean r6 = r10.getBoolean(r6)
            if (r6 == 0) goto L9b
            r6 = r4
            goto L9c
        L9b:
            r6 = r1
        L9c:
            java.lang.String r7 = "requestLongTermAccess"
            boolean r8 = r10.hasKey(r7)
            if (r8 == 0) goto Lac
            boolean r7 = r10.getBoolean(r7)
            if (r7 == 0) goto Lac
            r7 = r4
            goto Lad
        Lac:
            r7 = r1
        Lad:
            java.lang.String r8 = "allowVirtualFiles"
            boolean r9 = r10.hasKey(r8)
            if (r9 == 0) goto Lbd
            boolean r10 = r10.getBoolean(r8)
            if (r10 == 0) goto Lbd
            r8 = r4
            goto Lbe
        Lbd:
            r8 = r1
        Lbe:
            com.reactnativedocumentpicker.PickOptions r1 = new com.reactnativedocumentpicker.PickOptions
            r4 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativedocumentpicker.PickOptionsKt.a(com.facebook.react.bridge.ReadableMap):com.reactnativedocumentpicker.PickOptions");
    }
}
