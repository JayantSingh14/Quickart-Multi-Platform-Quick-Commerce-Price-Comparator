package coil3.decode;

import android.graphics.ImageDecoder;
import android.system.ErrnoException;
import androidx.annotation.RequiresApi;
import coil3.ImageLoader;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StaticImageDecoder implements Decoder {

    @NotNull
    private final AutoCloseable closeable;

    @NotNull
    private final Options options;

    @NotNull
    private final Semaphore parallelismLock;

    @NotNull
    private final ImageDecoder.Source source;

    @Metadata
    public static final class Factory implements Decoder.Factory {

        @NotNull
        private final Semaphore parallelismLock;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // coil3.decode.Decoder.Factory
        @Nullable
        public Decoder create(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader) throws ErrnoException {
            ImageDecoder.Source imageDecoderSourceOrNull = StaticImageDecoderKt.toImageDecoderSourceOrNull(sourceFetchResult.getSource(), options, false);
            if (imageDecoderSourceOrNull == null) {
                return null;
            }
            return new StaticImageDecoder(imageDecoderSourceOrNull, sourceFetchResult.getSource(), options, this.parallelismLock);
        }

        public Factory(@NotNull Semaphore semaphore) {
            this.parallelismLock = semaphore;
        }

        public /* synthetic */ Factory(Semaphore semaphore, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? SemaphoreKt.a(4) : semaphore);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.decode.StaticImageDecoder", f = "StaticImageDecoder.kt", l = {157}, m = "decode")
    /* renamed from: coil3.decode.StaticImageDecoder$decode$1, reason: invalid class name */
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
            return StaticImageDecoder.this.decode(this);
        }
    }

    public StaticImageDecoder(@NotNull ImageDecoder.Source source, @NotNull AutoCloseable autoCloseable, @NotNull Options options, @NotNull Semaphore semaphore) {
        this.source = source;
        this.closeable = autoCloseable;
        this.options = options;
        this.parallelismLock = semaphore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setAllocator(BitmapsKt.isHardware(ImageRequests_androidKt.getBitmapConfig(this.options)) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(!ImageRequests_androidKt.getAllowRgb565(this.options) ? 1 : 0);
        if (ImageRequests_androidKt.getColorSpace(this.options) != null) {
            imageDecoder.setTargetColorSpace(ImageRequests_androidKt.getColorSpace(this.options));
        }
        imageDecoder.setUnpremultipliedRequired(!ImageRequests_androidKt.getPremultipliedAlpha(this.options));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil3.decode.Decoder
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object decode(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil3.decode.DecodeResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil3.decode.StaticImageDecoder.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            coil3.decode.StaticImageDecoder$decode$1 r0 = (coil3.decode.StaticImageDecoder.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.decode.StaticImageDecoder$decode$1 r0 = new coil3.decode.StaticImageDecoder$decode$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Semaphore r1 = (kotlinx.coroutines.sync.Semaphore) r1
            java.lang.Object r0 = r0.L$0
            coil3.decode.StaticImageDecoder r0 = (coil3.decode.StaticImageDecoder) r0
            kotlin.ResultKt.b(r8)
            goto L4b
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.parallelismLock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r0 = r8.a(r0)
            if (r0 != r1) goto L49
            return r1
        L49:
            r0 = r7
            r1 = r8
        L4b:
            java.lang.AutoCloseable r8 = r0.closeable     // Catch: java.lang.Throwable -> L71
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch: java.lang.Throwable -> L73
            r2.<init>()     // Catch: java.lang.Throwable -> L73
            android.graphics.ImageDecoder$Source r4 = r0.source     // Catch: java.lang.Throwable -> L73
            coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1 r5 = new coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1     // Catch: java.lang.Throwable -> L73
            r5.<init>()     // Catch: java.lang.Throwable -> L73
            android.graphics.Bitmap r0 = androidx.core.view.i.b(r4, r5)     // Catch: java.lang.Throwable -> L73
            coil3.decode.DecodeResult r4 = new coil3.decode.DecodeResult     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r6 = 0
            coil3.BitmapImage r0 = coil3.Image_androidKt.asImage$default(r0, r5, r3, r6)     // Catch: java.lang.Throwable -> L73
            boolean r2 = r2.f53798a     // Catch: java.lang.Throwable -> L73
            r4.<init>(r0, r2)     // Catch: java.lang.Throwable -> L73
            kotlin.jdk7.AutoCloseableKt.a(r8, r6)     // Catch: java.lang.Throwable -> L71
            r1.release()
            return r4
        L71:
            r8 = move-exception
            goto L7a
        L73:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L75
        L75:
            r2 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r8, r0)     // Catch: java.lang.Throwable -> L71
            throw r2     // Catch: java.lang.Throwable -> L71
        L7a:
            r1.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.StaticImageDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
