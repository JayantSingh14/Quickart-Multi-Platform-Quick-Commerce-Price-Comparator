package com.chuckerteam.chucker.internal.support;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.BitmapUtilsKt$calculateLuminance$2", f = "BitmapUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class BitmapUtilsKt$calculateLuminance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f16747a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapUtilsKt$calculateLuminance$2(Bitmap bitmap, Continuation continuation) {
        super(2, continuation);
        this.f16747a = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BitmapUtilsKt$calculateLuminance$2(this.f16747a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((BitmapUtilsKt$calculateLuminance$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        Paint paint = BitmapUtilsKt.f16746a;
        Bitmap bitmap = this.f16747a;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        bitmapCreateBitmap.eraseColor(-65281);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, new Matrix(), BitmapUtilsKt.f16746a);
        Palette.Builder builder = new Palette.Builder(bitmapCreateBitmap);
        ArrayList arrayList = builder.f11041f;
        arrayList.clear();
        arrayList.add(new a());
        Palette paletteA = builder.a();
        Intrinsics.checkNotNullExpressionValue(paletteA, "generate(...)");
        Palette.Swatch swatch = paletteA.f11035d;
        if (swatch != null) {
            return Double.valueOf(ColorUtils.f(swatch.f11045d));
        }
        return null;
    }
}
