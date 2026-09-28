package androidx.media3.exoplayer.mediacodec;

import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
final class MediaCodecPerformancePointCoverageProvider {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f7328a;

    @RequiresApi
    public static final class Api29 {
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        
            androidx.media3.exoplayer.audio.a.i();
            r4 = androidx.media3.exoplayer.audio.a.e();
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        
            if (r5 >= r6.size()) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
        
            if (androidx.media3.exoplayer.audio.a.g(r6.get(r5)).covers(r4) == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
        
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
        
            r7 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
        
            if (r7 != 1) goto L20;
         */
        @androidx.annotation.DoNotInline
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int a(android.media.MediaCodecInfo.VideoCapabilities r3, int r4, int r5, double r6) {
            /*
                java.util.List r3 = androidx.media3.exoplayer.audio.a.h(r3)
                r0 = 0
                if (r3 == 0) goto Lc7
                boolean r1 = r3.isEmpty()
                if (r1 == 0) goto Lf
                goto Lc7
            Lf:
                androidx.media3.exoplayer.audio.a.i()
                int r6 = (int) r6
                android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = androidx.media3.exoplayer.audio.a.f(r4, r5, r6)
                r5 = r0
            L18:
                int r6 = r3.size()
                r7 = 2
                r1 = 1
                if (r5 >= r6) goto L33
                java.lang.Object r6 = r3.get(r5)
                android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r6 = androidx.media3.exoplayer.audio.a.g(r6)
                boolean r6 = androidx.media3.exoplayer.audio.a.p(r6, r4)
                if (r6 == 0) goto L30
                r3 = r7
                goto L34
            L30:
                int r5 = r5 + 1
                goto L18
            L33:
                r3 = r1
            L34:
                if (r3 != r1) goto Lc6
                java.lang.Boolean r4 = androidx.media3.exoplayer.mediacodec.MediaCodecPerformancePointCoverageProvider.f7328a
                if (r4 != 0) goto Lc6
                int r4 = androidx.media3.common.util.Util.f5744a
                r5 = 35
                if (r4 < r5) goto L43
            L40:
                r1 = r0
                goto Lbd
            L43:
                androidx.media3.common.Format$Builder r4 = new androidx.media3.common.Format$Builder     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                r4.<init>()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                java.lang.String r5 = "video/avc"
                java.lang.String r5 = androidx.media3.common.MimeTypes.p(r5)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                r4.f5237l = r5     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                androidx.media3.common.Format r5 = new androidx.media3.common.Format     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                r5.<init>(r4)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                java.lang.String r4 = r5.f5225m     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r4 == 0) goto Lbd
                androidx.media3.exoplayer.mediacodec.d r4 = androidx.media3.exoplayer.mediacodec.MediaCodecSelector.f7339a     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                java.util.List r4 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.h(r4, r5, r0, r0)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                r5 = r0
            L60:
                int r6 = r4.size()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r5 >= r6) goto Lbd
                java.lang.Object r6 = r4.get(r5)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r6 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r6     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f7323d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r6 == 0) goto Lba
                java.lang.Object r6 = r4.get(r5)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r6 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r6     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f7323d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r6 == 0) goto Lba
                java.lang.Object r6 = r4.get(r5)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r6 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r6     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f7323d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                java.util.List r6 = androidx.media3.exoplayer.audio.a.h(r6)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r6 == 0) goto Lba
                boolean r2 = r6.isEmpty()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r2 != 0) goto Lba
                androidx.media3.exoplayer.audio.a.i()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = androidx.media3.exoplayer.audio.a.e()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                r5 = r0
            L9e:
                int r2 = r6.size()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r5 >= r2) goto Lb6
                java.lang.Object r2 = r6.get(r5)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r2 = androidx.media3.exoplayer.audio.a.g(r2)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                boolean r2 = androidx.media3.exoplayer.audio.a.p(r2, r4)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> Lbd
                if (r2 == 0) goto Lb3
                goto Lb7
            Lb3:
                int r5 = r5 + 1
                goto L9e
            Lb6:
                r7 = r1
            Lb7:
                if (r7 != r1) goto L40
                goto Lbd
            Lba:
                int r5 = r5 + 1
                goto L60
            Lbd:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                androidx.media3.exoplayer.mediacodec.MediaCodecPerformancePointCoverageProvider.f7328a = r4
                if (r1 == 0) goto Lc6
                goto Lc7
            Lc6:
                return r3
            Lc7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecPerformancePointCoverageProvider.Api29.a(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
        }
    }
}
