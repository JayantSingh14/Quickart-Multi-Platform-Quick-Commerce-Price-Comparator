package coil3.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.BitmapImage;
import coil3.Image;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.transform.Transformation;
import coil3.util.BitmapsKt;
import coil3.util.DrawableUtils;
import coil3.util.Logger;
import coil3.util.Utils_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EngineInterceptorKt {

    @Metadata
    @DebugMetadata(c = "coil3.intercept.EngineInterceptorKt", f = "EngineInterceptor.kt", l = {54}, m = "transform")
    /* renamed from: coil3.intercept.EngineInterceptorKt$transform$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptorKt.transform(null, null, null, null, null, this);
        }
    }

    private static final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> list, Logger logger) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = BitmapsKt.getSafeConfig(bitmap);
            if (ArraysKt.h(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            if (logger != null) {
                Logger.Level level = Logger.Level.Info;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(EngineInterceptor.TAG, level, "Converting bitmap with config " + safeConfig + " to apply transformations: " + list + ClassUtils.PACKAGE_SEPARATOR_CHAR, null);
                }
            }
        } else if (logger != null) {
            Logger.Level level2 = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level2) <= 0) {
                logger.log(EngineInterceptor.TAG, level2, "Converting drawable of type " + Reflection.a(drawable.getClass()).k() + " to apply transformations: " + list + ClassUtils.PACKAGE_SEPARATOR_CHAR, null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, ImageRequests_androidKt.getBitmapConfig(options), options.getSize(), options.getScale(), options.getPrecision() == Precision.INEXACT);
    }

    public static final void prepareToDraw(@NotNull Image image) {
        Bitmap bitmap;
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null || (bitmap = bitmapImage.getBitmap()) == null) {
            return;
        }
        bitmap.prepareToDraw();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00e4 -> B:32:0x00e9). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object transform(@org.jetbrains.annotations.NotNull coil3.intercept.EngineInterceptor.ExecuteResult r18, @org.jetbrains.annotations.NotNull coil3.request.ImageRequest r19, @org.jetbrains.annotations.NotNull coil3.request.Options r20, @org.jetbrains.annotations.NotNull coil3.EventListener r21, @org.jetbrains.annotations.Nullable coil3.util.Logger r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.intercept.EngineInterceptor.ExecuteResult> r23) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptorKt.transform(coil3.intercept.EngineInterceptor$ExecuteResult, coil3.request.ImageRequest, coil3.request.Options, coil3.EventListener, coil3.util.Logger, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
