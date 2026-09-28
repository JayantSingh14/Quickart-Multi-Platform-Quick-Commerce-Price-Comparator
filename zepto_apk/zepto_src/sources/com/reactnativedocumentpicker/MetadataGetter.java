package com.reactnativedocumentpicker;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class MetadataGetter {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f46355a;

    public MetadataGetter(LinkedHashMap uriMap) {
        Intrinsics.checkNotNullParameter(uriMap, "uriMap");
        this.f46355a = uriMap;
    }

    public static Object a(Cursor cursor, String str, Class cls) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        try {
            if (Intrinsics.b(cls, String.class)) {
                return cursor.getString(columnIndex);
            }
            if (Intrinsics.b(cls, Integer.TYPE)) {
                return Integer.valueOf(cursor.getInt(columnIndex));
            }
            if (Intrinsics.b(cls, Long.TYPE)) {
                return Long.valueOf(cursor.getLong(columnIndex));
            }
            if (Intrinsics.b(cls, Double.TYPE)) {
                return Double.valueOf(cursor.getDouble(columnIndex));
            }
            if (Intrinsics.b(cls, Float.TYPE)) {
                return Float.valueOf(cursor.getFloat(columnIndex));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(ContentResolver contentResolver, DocumentMetadataBuilder metadataBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(metadataBuilder, "metadataBuilder");
        ArrayList arrayListJ = CollectionsKt.J("mime_type", "_display_name", "_size");
        if (z) {
            arrayListJ.add("flags");
        }
        boolean z2 = false;
        Cursor cursorQuery = contentResolver.query(metadataBuilder.f46331a, (String[]) arrayListJ.toArray(new String[0]), null, null, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null || !cursor.moveToFirst()) {
                metadataBuilder.f46335e = "Could not read file metadata";
            } else {
                metadataBuilder.f46332b = (String) a(cursor, "_display_name", String.class);
                if (metadataBuilder.f46334d == null) {
                    metadataBuilder.f46334d = (String) a(cursor, "mime_type", String.class);
                }
                if (z) {
                    Integer num = (Integer) a(cursor, "flags", Integer.TYPE);
                    if (((num != null ? num.intValue() : 0) & 512) != 0) {
                        z2 = true;
                    }
                }
                metadataBuilder.f46339i = Boolean.valueOf(z2);
                metadataBuilder.f46333c = (Long) a(cursor, "_size", Long.TYPE);
            }
            CloseableKt.a(cursorQuery, null);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.facebook.react.bridge.ReactApplicationContext r11, java.util.List r12, com.reactnativedocumentpicker.PickOptions r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$1
            if (r0 == 0) goto L13
            r0 = r14
            com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$1 r0 = (com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$1) r0
            int r1 = r0.f46362c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46362c = r1
            goto L18
        L13:
            com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$1 r0 = new com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f46360a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f46362c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r14)
            goto L49
        L27:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2f:
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.scheduling.DefaultScheduler r14 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r14 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2 r4 = new com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2
            r9 = 0
            r6 = r10
            r7 = r11
            r5 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f46362c = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.e(r14, r4, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            java.lang.String r11 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativedocumentpicker.MetadataGetter.b(com.facebook.react.bridge.ReactApplicationContext, java.util.List, com.reactnativedocumentpicker.PickOptions, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
