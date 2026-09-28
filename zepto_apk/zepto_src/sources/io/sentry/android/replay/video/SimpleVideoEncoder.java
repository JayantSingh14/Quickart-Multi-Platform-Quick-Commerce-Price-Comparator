package io.sentry.android.replay.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Range;
import android.view.Surface;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@TargetApi(26)
/* loaded from: classes3.dex */
public final class SimpleVideoEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52644a;

    /* renamed from: b, reason: collision with root package name */
    public final MuxerConfig f52645b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f52646c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodec f52647d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f52648e;

    /* renamed from: f, reason: collision with root package name */
    public final MediaCodec.BufferInfo f52649f;

    /* renamed from: g, reason: collision with root package name */
    public final SimpleMp4FrameMuxer f52650g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f52651h;

    public SimpleVideoEncoder(SentryOptions options, MuxerConfig muxerConfig) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(muxerConfig, "muxerConfig");
        this.f52644a = options;
        this.f52645b = muxerConfig;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53530c;
        Lazy lazyA = LazyKt.a(lazyThreadSafetyMode, SimpleVideoEncoder$hasExynosCodec$2.f52652c);
        this.f52646c = lazyA;
        MediaCodec mediaCodecCreateByCodecName = ((Boolean) lazyA.getValue()).booleanValue() ? MediaCodec.createByCodecName("c2.android.avc.encoder") : MediaCodec.createEncoderByType("video/avc");
        Intrinsics.checkNotNullExpressionValue(mediaCodecCreateByCodecName, "if (hasExynosCodec) {\n  …onfig.mimeType)\n        }");
        this.f52647d = mediaCodecCreateByCodecName;
        this.f52648e = LazyKt.a(lazyThreadSafetyMode, new Function0<MediaFormat>() { // from class: io.sentry.android.replay.video.SimpleVideoEncoder$mediaFormat$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SimpleVideoEncoder simpleVideoEncoder = this.f52653c;
                MuxerConfig muxerConfig2 = simpleVideoEncoder.f52645b;
                SentryOptions sentryOptions = simpleVideoEncoder.f52644a;
                int iIntValue = muxerConfig2.f52637e;
                try {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = simpleVideoEncoder.f52647d.getCodecInfo().getCapabilitiesForType("video/avc").getVideoCapabilities();
                    if (!videoCapabilities.getBitrateRange().contains((Range<Integer>) Integer.valueOf(iIntValue))) {
                        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Encoder doesn't support the provided bitRate: " + iIntValue + ", the value will be clamped to the closest one", new Object[0]);
                        Object objClamp = videoCapabilities.getBitrateRange().clamp(Integer.valueOf(iIntValue));
                        Intrinsics.checkNotNullExpressionValue(objClamp, "videoCapabilities.bitrateRange.clamp(bitRate)");
                        iIntValue = ((Number) objClamp).intValue();
                    }
                } catch (Throwable th) {
                    sentryOptions.getLogger().b(SentryLevel.DEBUG, "Could not retrieve MediaCodec info", th);
                }
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", muxerConfig2.f52634b, muxerConfig2.f52635c);
                Intrinsics.checkNotNullExpressionValue(mediaFormatCreateVideoFormat, "createVideoFormat(\n     …recordingHeight\n        )");
                mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
                mediaFormatCreateVideoFormat.setInteger("bitrate", iIntValue);
                mediaFormatCreateVideoFormat.setFloat("frame-rate", muxerConfig2.f52636d);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 6);
                return mediaFormatCreateVideoFormat;
            }
        });
        this.f52649f = new MediaCodec.BufferInfo();
        String absolutePath = muxerConfig.f52633a.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "muxerConfig.file.absolutePath");
        this.f52650g = new SimpleMp4FrameMuxer(absolutePath, muxerConfig.f52636d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0150, code lost:
    
        throw new java.lang.RuntimeException(android.support.v4.media.b.g(r5, "encoderOutputBuffer ", " was null"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r13) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.video.SimpleVideoEncoder.a(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.graphics.Bitmap r6) {
        /*
            r5 = this;
            java.lang.String r0 = "image"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r2 = "xiaomi"
            r3 = 1
            boolean r2 = kotlin.text.StringsKt.n(r0, r2, r3)
            r4 = 0
            if (r2 != 0) goto L2d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "motorola"
            boolean r0 = kotlin.text.StringsKt.n(r0, r1, r3)
            if (r0 == 0) goto L22
            goto L2d
        L22:
            android.view.Surface r0 = r5.f52651h
            if (r0 == 0) goto L2b
            android.graphics.Canvas r0 = r0.lockHardwareCanvas()
            goto L35
        L2b:
            r0 = r4
            goto L35
        L2d:
            android.view.Surface r0 = r5.f52651h
            if (r0 == 0) goto L2b
            android.graphics.Canvas r0 = r0.lockCanvas(r4)
        L35:
            if (r0 == 0) goto L3b
            r1 = 0
            r0.drawBitmap(r6, r1, r1, r4)
        L3b:
            android.view.Surface r6 = r5.f52651h
            if (r6 == 0) goto L42
            r6.unlockCanvasAndPost(r0)
        L42:
            r6 = 0
            r5.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.video.SimpleVideoEncoder.b(android.graphics.Bitmap):void");
    }

    public final void c() {
        MediaCodec mediaCodec = this.f52647d;
        try {
            a(true);
            mediaCodec.stop();
            mediaCodec.release();
            Surface surface = this.f52651h;
            if (surface != null) {
                surface.release();
            }
            MediaMuxer mediaMuxer = this.f52650g.f52639b;
            mediaMuxer.stop();
            mediaMuxer.release();
        } catch (Throwable th) {
            this.f52644a.getLogger().b(SentryLevel.DEBUG, "Failed to properly release video encoder", th);
        }
    }
}
