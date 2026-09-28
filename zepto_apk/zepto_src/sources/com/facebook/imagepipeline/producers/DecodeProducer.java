package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.media.b;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imageutils.BitmapUtil;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayPool f18117a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f18118b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageDecoder f18119c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressiveJpegConfig f18120d;

    /* renamed from: e, reason: collision with root package name */
    public final DownsampleMode f18121e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18122f;

    /* renamed from: g, reason: collision with root package name */
    public final Producer f18123g;

    /* renamed from: h, reason: collision with root package name */
    public final int f18124h;

    /* renamed from: i, reason: collision with root package name */
    public final CloseableReferenceFactory f18125i;

    /* renamed from: j, reason: collision with root package name */
    public final Supplier f18126j;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final int m(EncodedImage encodedImage) {
            Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
            return encodedImage.A();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final QualityInfo n() {
            ImmutableQualityInfo immutableQualityInfoD = ImmutableQualityInfo.d(0, false, false);
            Intrinsics.checkNotNullExpressionValue(immutableQualityInfoD, "of(...)");
            return immutableQualityInfoD;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final synchronized boolean s(EncodedImage encodedImage, int i2) {
            return BaseConsumer.e(i2) ? false : this.f18134h.f(encodedImage, i2);
        }
    }

    @Metadata
    public final class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {

        /* renamed from: k, reason: collision with root package name */
        public final ProgressiveJpegParser f18127k;

        /* renamed from: l, reason: collision with root package name */
        public final ProgressiveJpegConfig f18128l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, int i2) {
            super(decodeProducer, consumer, producerContext, i2);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            Intrinsics.checkNotNullParameter(progressiveJpegParser, "progressiveJpegParser");
            Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            this.f18127k = progressiveJpegParser;
            this.f18128l = progressiveJpegConfig;
            this.f18135i = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final int m(EncodedImage encodedImage) {
            Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
            return this.f18127k.f17941f;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final QualityInfo n() {
            ImmutableQualityInfo immutableQualityInfoB = this.f18128l.b(this.f18127k.f17940e);
            Intrinsics.checkNotNullExpressionValue(immutableQualityInfoB, "getQualityInfo(...)");
            return immutableQualityInfoB;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public final synchronized boolean s(EncodedImage encodedImage, int i2) {
            if (encodedImage == null) {
                return false;
            }
            try {
                boolean zF = this.f18134h.f(encodedImage, i2);
                if (BaseConsumer.e(i2) || BaseConsumer.k(i2, 8)) {
                    if (!BaseConsumer.k(i2, 4) && EncodedImage.V(encodedImage)) {
                        encodedImage.Z();
                        if (encodedImage.f17957b == DefaultImageFormats.f17681a) {
                            if (!this.f18127k.b(encodedImage)) {
                                return false;
                            }
                            int i3 = this.f18127k.f17940e;
                            int i4 = this.f18135i;
                            if (i3 <= i4) {
                                return false;
                            }
                            if (i3 < this.f18128l.a(i4) && !this.f18127k.f17942g) {
                                return false;
                            }
                            this.f18135i = i3;
                        }
                    }
                }
                return zF;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18129c;

        /* renamed from: d, reason: collision with root package name */
        public final String f18130d;

        /* renamed from: e, reason: collision with root package name */
        public final ProducerListener2 f18131e;

        /* renamed from: f, reason: collision with root package name */
        public final ImageDecodeOptions f18132f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f18133g;

        /* renamed from: h, reason: collision with root package name */
        public final JobScheduler f18134h;

        /* renamed from: i, reason: collision with root package name */
        public int f18135i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ DecodeProducer f18136j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressiveDecoder(final DecodeProducer decodeProducer, Consumer consumer, ProducerContext producerContext, final int i2) {
            super(consumer);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            this.f18136j = decodeProducer;
            this.f18129c = producerContext;
            this.f18130d = "ProgressiveDecoder";
            this.f18131e = producerContext.s();
            ImageDecodeOptions imageDecodeOptions = producerContext.D().f18353g;
            Intrinsics.checkNotNullExpressionValue(imageDecodeOptions, "getImageDecodeOptions(...)");
            this.f18132f = imageDecodeOptions;
            JobScheduler.JobRunnable jobRunnable = new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.a
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public final void a(EncodedImage encodedImage, int i3) throws IOException {
                    boolean z;
                    long j2;
                    ProducerListener2 producerListener2;
                    long j3;
                    QualityInfo qualityInfo;
                    String str;
                    DecodeProducer.ProgressiveDecoder progressiveDecoder;
                    long j4;
                    CloseableImage closeableImage;
                    DefaultCloseableReference defaultCloseableReference;
                    DecodeProducer.ProgressiveDecoder this$0 = this.f18341a;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    DecodeProducer this$1 = decodeProducer;
                    Intrinsics.checkNotNullParameter(this$1, "this$1");
                    if (encodedImage == null) {
                        return;
                    }
                    ImageRequest imageRequestD = this$0.f18129c.D();
                    encodedImage.Z();
                    String str2 = encodedImage.f17957b.f17695a;
                    ProducerContext producerContext2 = this$0.f18129c;
                    producerContext2.V(str2, "image_format");
                    Uri uri = imageRequestD.f18348b;
                    encodedImage.f17966k = uri != null ? uri.toString() : null;
                    DownsampleMode downsampleMode = imageRequestD.q;
                    if (downsampleMode == null) {
                        downsampleMode = this$1.f18121e;
                    }
                    boolean zK = BaseConsumer.k(i3, 16);
                    if ((downsampleMode == DownsampleMode.f17816a || (downsampleMode == DownsampleMode.f17817b && !zK)) && (this$1.f18122f || !UriUtil.f(imageRequestD.f18348b))) {
                        RotationOptions rotationOptions = imageRequestD.f18355i;
                        Intrinsics.checkNotNullExpressionValue(rotationOptions, "getRotationOptions(...)");
                        encodedImage.f17962g = DownsampleUtil.a(rotationOptions, imageRequestD.f18354h, encodedImage, i2);
                    }
                    producerContext2.c().b().getClass();
                    int i4 = this$0.f18135i;
                    encodedImage.Z();
                    if ((encodedImage.f17957b != DefaultImageFormats.f17681a && BaseConsumer.e(i3)) || this$0.f18133g || !EncodedImage.V(encodedImage)) {
                        return;
                    }
                    encodedImage.Z();
                    boolean zB = Intrinsics.b(encodedImage.f17957b, DefaultImageFormats.f17683c);
                    ProducerListener2 producerListener22 = this$0.f18131e;
                    if (zB) {
                        encodedImage.Z();
                        long j5 = encodedImage.f17960e;
                        encodedImage.Z();
                        long j6 = encodedImage.f17961f;
                        ImageDecodeOptions imageDecodeOptions2 = this$0.f18132f;
                        if (j5 * j6 * BitmapUtil.b(imageDecodeOptions2.f17777a) > 104857600) {
                            encodedImage.Z();
                            int i5 = encodedImage.f17960e;
                            encodedImage.Z();
                            StringBuilder sbT = b.t(i5, encodedImage.f17961f, "Image is too big to attempt decoding: w = ", ", h = ", ", pixel config = ");
                            sbT.append(imageDecodeOptions2.f17777a);
                            sbT.append(", max bitmap size = 104857600");
                            IllegalStateException illegalStateException = new IllegalStateException(sbT.toString());
                            producerListener22.k(producerContext2, "DecodeProducer", illegalStateException, null);
                            this$0.o(illegalStateException);
                            return;
                        }
                    }
                    encodedImage.Z();
                    ImageFormat imageFormat = encodedImage.f17957b;
                    Intrinsics.checkNotNullExpressionValue(imageFormat, "getImageFormat(...)");
                    String str3 = imageFormat.f17695a;
                    String str4 = zzck.UNKNOWN_CONTENT_TYPE;
                    encodedImage.Z();
                    int i6 = encodedImage.f17960e;
                    encodedImage.Z();
                    String str5 = i6 + "x" + encodedImage.f17961f;
                    String strValueOf = String.valueOf(encodedImage.f17962g);
                    boolean zD = BaseConsumer.d(i3);
                    boolean z2 = zD && !BaseConsumer.k(i3, 8);
                    boolean zK2 = BaseConsumer.k(i3, 4);
                    ResizeOptions resizeOptions = producerContext2.D().f18354h;
                    if (resizeOptions != null) {
                        str4 = resizeOptions.f17787a + "x" + resizeOptions.f17788b;
                    }
                    try {
                        JobScheduler jobScheduler = this$0.f18134h;
                        synchronized (jobScheduler) {
                            z = z2;
                            j2 = jobScheduler.f18194i - jobScheduler.f18193h;
                        }
                        String string = producerContext2.D().f18348b.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        int iA = (z || zK2) ? encodedImage.A() : this$0.m(encodedImage);
                        QualityInfo qualityInfoN = (z || zK2) ? ImmutableQualityInfo.f17971d : this$0.n();
                        producerListener22.c(producerContext2, "DecodeProducer");
                        try {
                            try {
                                Intrinsics.c(qualityInfoN);
                            } catch (Exception e2) {
                                e = e2;
                                producerListener2 = producerListener22;
                                j3 = j2;
                                qualityInfo = qualityInfoN;
                                str = str4;
                            }
                            try {
                                CloseableImage closeableImageP = this$0.p(encodedImage, iA, qualityInfoN);
                                try {
                                    int i7 = encodedImage.f17962g != 1 ? i3 | 16 : i3;
                                    producerListener22.i(producerContext2, "DecodeProducer", this$0.l(closeableImageP, j2, qualityInfoN, zD, str3, str5, str4, strValueOf));
                                    this$0.r(encodedImage, closeableImageP, i4);
                                    CloseableReference.LeakHandler leakHandler = this$0.f18136j.f18125i.f17793a;
                                    if (closeableImageP == null) {
                                        defaultCloseableReference = null;
                                    } else {
                                        ResourceReleaser resourceReleaser = CloseableReference.f17107e;
                                        leakHandler.b();
                                        boolean z3 = closeableImageP instanceof Bitmap;
                                        defaultCloseableReference = new DefaultCloseableReference(closeableImageP, resourceReleaser, leakHandler, null, true);
                                    }
                                    try {
                                        this$0.q(BaseConsumer.d(i7));
                                        this$0.f18138b.b(i7, defaultCloseableReference);
                                        encodedImage.close();
                                    } finally {
                                        CloseableReference.e(defaultCloseableReference);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    qualityInfo = qualityInfoN;
                                    str = str4;
                                    closeableImage = closeableImageP;
                                    producerListener2 = producerListener22;
                                    progressiveDecoder = this$0;
                                    j4 = j2;
                                    Intrinsics.c(qualityInfo);
                                    DecodeProducer.ProgressiveDecoder progressiveDecoder2 = progressiveDecoder;
                                    producerListener2.k(producerContext2, "DecodeProducer", e, progressiveDecoder2.l(closeableImage, j4, qualityInfo, zD, str3, str5, str, strValueOf));
                                    progressiveDecoder2.o(e);
                                    encodedImage.close();
                                }
                            } catch (Exception e4) {
                                e = e4;
                                j3 = j2;
                                qualityInfo = qualityInfoN;
                                str = str4;
                                producerListener2 = producerListener22;
                                progressiveDecoder = this$0;
                                j4 = j3;
                                closeableImage = null;
                                Intrinsics.c(qualityInfo);
                                DecodeProducer.ProgressiveDecoder progressiveDecoder22 = progressiveDecoder;
                                producerListener2.k(producerContext2, "DecodeProducer", e, progressiveDecoder22.l(closeableImage, j4, qualityInfo, zD, str3, str5, str, strValueOf));
                                progressiveDecoder22.o(e);
                                encodedImage.close();
                            }
                        } catch (DecodeException e5) {
                            producerListener2 = producerListener22;
                            j3 = j2;
                            qualityInfo = qualityInfoN;
                            str = str4;
                            try {
                                EncodedImage encodedImage2 = e5.f17928a;
                                try {
                                    progressiveDecoder = this$0;
                                } catch (Exception e6) {
                                    e = e6;
                                    progressiveDecoder = this$0;
                                    j4 = j3;
                                    closeableImage = null;
                                    Intrinsics.c(qualityInfo);
                                    DecodeProducer.ProgressiveDecoder progressiveDecoder222 = progressiveDecoder;
                                    producerListener2.k(producerContext2, "DecodeProducer", e, progressiveDecoder222.l(closeableImage, j4, qualityInfo, zD, str3, str5, str, strValueOf));
                                    progressiveDecoder222.o(e);
                                    encodedImage.close();
                                }
                                try {
                                    j4 = j3;
                                } catch (Exception e7) {
                                    e = e7;
                                    j4 = j3;
                                    closeableImage = null;
                                    Intrinsics.c(qualityInfo);
                                    DecodeProducer.ProgressiveDecoder progressiveDecoder2222 = progressiveDecoder;
                                    producerListener2.k(producerContext2, "DecodeProducer", e, progressiveDecoder2222.l(closeableImage, j4, qualityInfo, zD, str3, str5, str, strValueOf));
                                    progressiveDecoder2222.o(e);
                                    encodedImage.close();
                                }
                                try {
                                    FLog.s(this$0.f18130d, "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e5.getMessage(), string, encodedImage2.l(), Integer.valueOf(encodedImage2.A()));
                                    throw e5;
                                } catch (Exception e8) {
                                    e = e8;
                                    closeableImage = null;
                                    Intrinsics.c(qualityInfo);
                                    DecodeProducer.ProgressiveDecoder progressiveDecoder22222 = progressiveDecoder;
                                    producerListener2.k(producerContext2, "DecodeProducer", e, progressiveDecoder22222.l(closeableImage, j4, qualityInfo, zD, str3, str5, str, strValueOf));
                                    progressiveDecoder22222.o(e);
                                    encodedImage.close();
                                }
                            } catch (Exception e9) {
                                e = e9;
                                progressiveDecoder = this$0;
                            }
                        }
                    } catch (Throwable th) {
                        encodedImage.close();
                        throw th;
                    }
                }
            };
            Executor executor = decodeProducer.f18118b;
            imageDecodeOptions.getClass();
            this.f18134h = new JobScheduler(executor, jobRunnable);
            producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void a() {
                    ProgressiveDecoder progressiveDecoder = ProgressiveDecoder.this;
                    if (progressiveDecoder.f18129c.x()) {
                        progressiveDecoder.f18134h.d();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public final void b() {
                }
            });
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void f() {
            q(true);
            this.f18138b.a();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            o(t);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            EncodedImage encodedImage = (EncodedImage) obj;
            FrescoSystrace.a();
            boolean zD = BaseConsumer.d(i2);
            ProducerContext producerContext = this.f18129c;
            if (zD) {
                if (encodedImage == null) {
                    Intrinsics.b(producerContext.T("cached_value_found"), Boolean.TRUE);
                    producerContext.c().b().getClass();
                    o(new ExceptionWithNoStacktrace("Encoded image is null."));
                    return;
                } else if (!encodedImage.T()) {
                    o(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                    return;
                }
            }
            if (s(encodedImage, i2)) {
                boolean zK = BaseConsumer.k(i2, 4);
                if (zD || zK || producerContext.x()) {
                    this.f18134h.d();
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void i(float f2) {
            super.i(f2 * 0.99f);
        }

        public final ImmutableMap l(CloseableImage closeableImage, long j2, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            Map extras;
            Object obj;
            String string = null;
            if (!this.f18131e.e(this.f18129c, "DecodeProducer")) {
                return null;
            }
            String strValueOf = String.valueOf(j2);
            String strValueOf2 = String.valueOf(qualityInfo.b());
            String strValueOf3 = String.valueOf(z);
            if (closeableImage != null && (extras = closeableImage.getExtras()) != null && (obj = extras.get("non_fatal_decode_error")) != null) {
                string = obj.toString();
            }
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                String str5 = string;
                HashMap map = new HashMap(7);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", str2);
                map.put("imageFormat", str);
                map.put("requestedImageSize", str3);
                map.put("sampleSize", str4);
                if (str5 != null) {
                    map.put("non_fatal_decode_error", str5);
                }
                return new ImmutableMap(map);
            }
            String str6 = string;
            Bitmap bitmapV1 = ((CloseableStaticBitmap) closeableImage).v1();
            Intrinsics.checkNotNullExpressionValue(bitmapV1, "getUnderlyingBitmap(...)");
            String str7 = bitmapV1.getWidth() + "x" + bitmapV1.getHeight();
            HashMap map2 = new HashMap(8);
            map2.put("bitmapSize", str7);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", str2);
            map2.put("imageFormat", str);
            map2.put("requestedImageSize", str3);
            map2.put("sampleSize", str4);
            int byteCount = bitmapV1.getByteCount();
            StringBuilder sb = new StringBuilder();
            sb.append(byteCount);
            map2.put("byteCount", sb.toString());
            if (str6 != null) {
                map2.put("non_fatal_decode_error", str6);
            }
            return new ImmutableMap(map2);
        }

        public abstract int m(EncodedImage encodedImage);

        public abstract QualityInfo n();

        public final void o(Throwable th) {
            q(true);
            this.f18138b.onFailure(th);
        }

        public final CloseableImage p(EncodedImage encodedImage, int i2, QualityInfo qualityInfo) {
            ImageDecodeOptions imageDecodeOptions = this.f18132f;
            DecodeProducer decodeProducer = this.f18136j;
            decodeProducer.getClass();
            return decodeProducer.f18119c.a(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }

        public final void q(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.f18133g) {
                        this.f18138b.c(1.0f);
                        this.f18133g = true;
                        Unit unit = Unit.f53572a;
                        this.f18134h.a();
                    }
                }
            }
        }

        public final void r(EncodedImage encodedImage, CloseableImage closeableImage, int i2) throws IOException {
            encodedImage.Z();
            Integer numValueOf = Integer.valueOf(encodedImage.f17960e);
            ProducerContext producerContext = this.f18129c;
            producerContext.V(numValueOf, "encoded_width");
            encodedImage.Z();
            producerContext.V(Integer.valueOf(encodedImage.f17961f), "encoded_height");
            producerContext.V(Integer.valueOf(encodedImage.A()), "encoded_size");
            encodedImage.Z();
            producerContext.V(encodedImage.f17965j, "image_color_space");
            if (closeableImage instanceof CloseableBitmap) {
                producerContext.V(String.valueOf(((CloseableBitmap) closeableImage).v1().getConfig()), "bitmap_config");
            }
            if (closeableImage != null) {
                closeableImage.N(producerContext.getExtras());
            }
            producerContext.V(Integer.valueOf(i2), "last_scan_num");
        }

        public boolean s(EncodedImage encodedImage, int i2) {
            return this.f18134h.f(encodedImage, i2);
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean z, Producer inputProducer, int i2, CloseableReferenceFactory closeableReferenceFactory) {
        Supplier recoverFromDecoderOOM = Suppliers.f17085b;
        Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
        Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
        Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        Intrinsics.checkNotNullParameter(recoverFromDecoderOOM, "recoverFromDecoderOOM");
        this.f18117a = byteArrayPool;
        this.f18118b = executor;
        this.f18119c = imageDecoder;
        this.f18120d = progressiveJpegConfig;
        this.f18121e = downsampleMode;
        this.f18122f = z;
        this.f18123g = inputProducer;
        this.f18124h = i2;
        this.f18125i = closeableReferenceFactory;
        this.f18126j = recoverFromDecoderOOM;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        DecodeProducer decodeProducer;
        ProducerContext producerContext2;
        Consumer networkImagesProgressiveDecoder;
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerContext, "context");
        FrescoSystrace.a();
        ImageRequest imageRequestD = producerContext.D();
        if (UriUtil.f(imageRequestD.f18348b) || ImageRequestBuilder.c(imageRequestD.f18348b)) {
            decodeProducer = this;
            producerContext2 = producerContext;
            networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(decodeProducer, consumer, producerContext2, new ProgressiveJpegParser(this.f18117a), this.f18120d, this.f18124h);
        } else {
            int i2 = this.f18124h;
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(this, consumer, producerContext, i2);
            decodeProducer = this;
            producerContext2 = producerContext;
        }
        decodeProducer.f18123g.b(networkImagesProgressiveDecoder, producerContext2);
    }
}
