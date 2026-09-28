package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSource;
import okio.RealBufferedSource$inputStream$1;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BitmapFactoryDecoder implements Decoder {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_PARALLELISM = 4;

    @NotNull
    private final ExifOrientationStrategy exifOrientationStrategy;

    @NotNull
    private final Options options;

    @NotNull
    private final Semaphore parallelismLock;

    @NotNull
    private final ImageSource source;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class ExceptionCatchingSource extends ForwardingSource {

        @Nullable
        private Exception exception;

        public ExceptionCatchingSource(@NotNull Source source) {
            super(source);
        }

        @Nullable
        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(@NotNull Buffer buffer, long j2) throws Exception {
            try {
                return super.read(buffer, j2);
            } catch (Exception e2) {
                this.exception = e2;
                throw e2;
            }
        }
    }

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Decoder.Factory {

        @NotNull
        private final ExifOrientationStrategy exifOrientationStrategy;

        @NotNull
        private final Semaphore parallelismLock;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Override // coil3.decode.Decoder.Factory
        @NotNull
        public Decoder create(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(sourceFetchResult.getSource(), options, this.parallelismLock, this.exifOrientationStrategy);
        }

        public Factory(@NotNull Semaphore semaphore, @NotNull ExifOrientationStrategy exifOrientationStrategy) {
            this.parallelismLock = semaphore;
            this.exifOrientationStrategy = exifOrientationStrategy;
        }

        public /* synthetic */ Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? SemaphoreKt.a(4) : semaphore, (i2 & 2) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", l = {212, 40}, m = "decode")
    /* renamed from: coil3.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    public BitmapFactoryDecoder(@NotNull ImageSource imageSource, @NotNull Options options, @NotNull Semaphore semaphore, @NotNull ExifOrientationStrategy exifOrientationStrategy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationStrategy = exifOrientationStrategy;
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config bitmapConfig = ImageRequests_androidKt.getBitmapConfig(this.options);
        if (exifData.isFlipped() || ExifUtilsKt.isRotated(exifData)) {
            bitmapConfig = BitmapsKt.toSoftware(bitmapConfig);
        }
        if (ImageRequests_androidKt.getAllowRgb565(this.options) && bitmapConfig == Bitmap.Config.ARGB_8888 && Intrinsics.b(options.outMimeType, "image/jpeg")) {
            bitmapConfig = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && bitmapConfig != Bitmap.Config.HARDWARE) {
            bitmapConfig = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = bitmapConfig;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i3 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        long jM1computeDstSizesEdh43o = DecodeUtils.m1computeDstSizesEdh43o(i2, i3, this.options.getSize(), this.options.getScale(), ImageRequestsKt.getMaxBitmapSize(this.options));
        int iM51getFirstimpl = IntPair.m51getFirstimpl(jM1computeDstSizesEdh43o);
        int iM52getSecondimpl = IntPair.m52getSecondimpl(jM1computeDstSizesEdh43o);
        int iCalculateInSampleSize = DecodeUtils.calculateInSampleSize(i2, i3, iM51getFirstimpl, iM52getSecondimpl, this.options.getScale());
        options.inSampleSize = iCalculateInSampleSize;
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i2 / iCalculateInSampleSize, i3 / iCalculateInSampleSize, iM51getFirstimpl, iM52getSecondimpl, this.options.getScale());
        if (this.options.getPrecision() == Precision.INEXACT && dComputeSizeMultiplier > 1.0d) {
            dComputeSizeMultiplier = 1.0d;
        }
        boolean z = dComputeSizeMultiplier == 1.0d;
        options.inScaled = !z;
        if (z) {
            return;
        }
        if (dComputeSizeMultiplier > 1.0d) {
            options.inDensity = MathKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER / dComputeSizeMultiplier);
            options.inTargetDensity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            options.inDensity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            options.inTargetDensity = MathKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER * dComputeSizeMultiplier);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecodeResult decode$lambda$1$lambda$0(BitmapFactoryDecoder bitmapFactoryDecoder) {
        return bitmapFactoryDecoder.decode(new BitmapFactory.Options());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil3.decode.Decoder
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object decode(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.decode.DecodeResult> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil3.decode.BitmapFactoryDecoder.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = (coil3.decode.BitmapFactoryDecoder.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = new coil3.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2e
            goto L6f
        L2e:
            r8 = move-exception
            goto L7b
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r4 = r0.L$0
            coil3.decode.BitmapFactoryDecoder r4 = (coil3.decode.BitmapFactoryDecoder) r4
            kotlin.ResultKt.b(r8)
            r8 = r2
            goto L58
        L45:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.a(r0)
            if (r2 != r1) goto L57
            goto L6b
        L57:
            r4 = r7
        L58:
            coil3.decode.a r2 = new coil3.decode.a     // Catch: java.lang.Throwable -> L79
            r5 = 0
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L79
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L79
            r4 = 0
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L79
            r0.label = r3     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.a(r2, r0)     // Catch: java.lang.Throwable -> L79
            if (r0 != r1) goto L6c
        L6b:
            return r1
        L6c:
            r6 = r0
            r0 = r8
            r8 = r6
        L6f:
            coil3.decode.DecodeResult r8 = (coil3.decode.DecodeResult) r8     // Catch: java.lang.Throwable -> L2e
            r0.release()
            return r8
        L75:
            r6 = r0
            r0 = r8
            r8 = r6
            goto L7b
        L79:
            r0 = move-exception
            goto L75
        L7b:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.BitmapFactoryDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final DecodeResult decode(BitmapFactory.Options options) throws Exception {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        RealBufferedSource realBufferedSourceD = Okio.d(exceptionCatchingSource);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new RealBufferedSource$inputStream$1(realBufferedSourceD.peek()), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception == null) {
            options.inJustDecodeBounds = false;
            ExifUtils exifUtils = ExifUtils.INSTANCE;
            ExifData exifData = exifUtils.getExifData(options.outMimeType, realBufferedSourceD, this.exifOrientationStrategy);
            Exception exception2 = exceptionCatchingSource.getException();
            if (exception2 == null) {
                options.inMutable = false;
                if (Build.VERSION.SDK_INT >= 26 && ImageRequests_androidKt.getColorSpace(this.options) != null) {
                    options.inPreferredColorSpace = ImageRequests_androidKt.getColorSpace(this.options);
                }
                options.inPremultiplied = ImageRequests_androidKt.getPremultipliedAlpha(this.options);
                configureConfig(options, exifData);
                configureScale(options, exifData);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new RealBufferedSource$inputStream$1(realBufferedSourceD), null, options);
                    realBufferedSourceD.close();
                    Exception exception3 = exceptionCatchingSource.getException();
                    if (exception3 != null) {
                        throw exception3;
                    }
                    if (bitmapDecodeStream != null) {
                        bitmapDecodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
                        Image imageAsImage = Image_androidKt.asImage(new BitmapDrawable(this.options.getContext().getResources(), exifUtils.reverseTransformations(bitmapDecodeStream, exifData)));
                        if (options.inSampleSize <= 1 && !options.inScaled) {
                            z = false;
                        }
                        return new DecodeResult(imageAsImage, z);
                    }
                    throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the image source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                } finally {
                }
            } else {
                throw exception2;
            }
        } else {
            throw exception;
        }
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i2 & 4) != 0 ? SemaphoreKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER) : semaphore, (i2 & 8) != 0 ? ExifOrientationStrategy.RESPECT_PERFORMANCE : exifOrientationStrategy);
    }
}
