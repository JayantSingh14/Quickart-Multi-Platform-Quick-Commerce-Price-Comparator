package com.chuckerteam.chucker.internal.support;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Okio;
import okio.RealBufferedSource;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SharableKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.content.Intent a(com.chuckerteam.chucker.internal.support.Sharable r3, android.app.Activity r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r2 = "intentTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "intentSubject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = "clipDataLabel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.io.File r0 = r4.getCacheDir()
            r1 = 0
            if (r0 != 0) goto L37
            java.lang.String r3 = "Failed to obtain a valid cache directory for file export"
            com.chuckerteam.chucker.internal.support.Logger.DefaultImpls.b(r3)
        L35:
            r3 = r1
            goto L6e
        L37:
            java.io.File r5 = com.chuckerteam.chucker.internal.support.FileFactory.a(r0, r5)
            if (r5 != 0) goto L43
            java.lang.String r3 = "Failed to create an export file"
            com.chuckerteam.chucker.internal.support.Logger.DefaultImpls.b(r3)
            goto L35
        L43:
            okio.Buffer r3 = r3.a(r4)
            okio.Sink r0 = okio.Okio.j(r5)
            okio.RealBufferedSink r0 = okio.Okio.c(r0)
            r0.g0(r3)     // Catch: java.lang.Throwable -> Laf
            r0.close()
            java.lang.String r3 = r4.getPackageName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = ".com.chuckerteam.chucker.provider"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            android.net.Uri r3 = androidx.core.content.FileProvider.d(r4, r3, r5)
        L6e:
            if (r3 != 0) goto L71
            return r1
        L71:
            androidx.core.app.ShareCompat$IntentBuilder r5 = new androidx.core.app.ShareCompat$IntentBuilder
            r5.<init>(r4)
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r4 = r4.getType(r3)
            android.content.Intent r0 = r5.f2714a
            r0.setType(r4)
            r5.f2715b = r6
            java.lang.String r4 = "android.intent.extra.SUBJECT"
            r0.putExtra(r4, r7)
            r5.f2716c = r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5.f2716c = r4
            r4.add(r3)
            android.content.Intent r4 = r5.a()
            java.lang.String r5 = "getIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.content.ClipData r3 = android.content.ClipData.newRawUri(r8, r3)
            r4.setClipData(r3)
            r3 = 1
            r4.addFlags(r3)
            android.content.Intent r3 = android.content.Intent.createChooser(r4, r6)
            return r3
        Laf:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.SharableKt.a(com.chuckerteam.chucker.internal.support.Sharable, android.app.Activity, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(com.chuckerteam.chucker.internal.support.Sharable r5, android.app.Activity r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$1
            if (r0 == 0) goto L13
            r0 = r9
            com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$1 r0 = (com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$1) r0
            int r1 = r0.f16811e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16811e = r1
            goto L18
        L13:
            com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$1 r0 = new com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f16810d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f16811e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.String r8 = r0.f16809c
            java.lang.String r7 = r0.f16808b
            android.app.Activity r6 = r0.f16807a
            kotlin.ResultKt.b(r9)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.scheduling.DefaultScheduler r9 = kotlinx.coroutines.Dispatchers.f54091a
            com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$content$1 r2 = new com.chuckerteam.chucker.internal.support.SharableKt$shareAsUtf8Text$content$1
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f16807a = r6
            r0.f16808b = r7
            r0.f16809c = r8
            r0.f16811e = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.e(r9, r2, r0)
            if (r9 != r1) goto L4f
            return r1
        L4f:
            java.lang.String r9 = (java.lang.String) r9
            androidx.core.app.ShareCompat$IntentBuilder r5 = new androidx.core.app.ShareCompat$IntentBuilder
            r5.<init>(r6)
            java.lang.String r6 = "text/plain"
            android.content.Intent r0 = r5.f2714a
            r0.setType(r6)
            r5.f2715b = r7
            java.lang.String r6 = "android.intent.extra.SUBJECT"
            r0.putExtra(r6, r8)
            java.lang.String r6 = "android.intent.extra.TEXT"
            r0.putExtra(r6, r9)
            android.content.Intent r6 = r5.a()
            java.lang.String r5 = r5.f2715b
            android.content.Intent r5 = android.content.Intent.createChooser(r6, r5)
            java.lang.String r6 = "createChooserIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.SharableKt.b(com.chuckerteam.chucker.internal.support.Sharable, android.app.Activity, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final String c(Sharable sharable, Context context) {
        Intrinsics.checkNotNullParameter(sharable, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        RealBufferedSource realBufferedSourceD = Okio.d(sharable.a(context));
        try {
            String strA1 = realBufferedSourceD.A1();
            realBufferedSourceD.close();
            return strA1;
        } finally {
        }
    }
}
