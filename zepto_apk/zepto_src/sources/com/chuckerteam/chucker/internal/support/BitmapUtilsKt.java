package com.chuckerteam.chucker.internal.support;

import android.graphics.Bitmap;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BitmapUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Paint f16746a = new Paint(2);

    public static final Object a(Bitmap bitmap, Continuation continuation) {
        return BuildersKt.e(Dispatchers.f54091a, new BitmapUtilsKt$calculateLuminance$2(bitmap, null), continuation);
    }
}
