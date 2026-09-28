package io.sentry.android.replay.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class SimpleVideoEncoder$hasExynosCodec$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleVideoEncoder$hasExynosCodec$2 f52652c = new SimpleVideoEncoder$hasExynosCodec$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z = false;
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        Intrinsics.checkNotNullExpressionValue(codecInfos, "MediaCodecList(MediaCode…)\n            .codecInfos");
        int length = codecInfos.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String name = codecInfos[i2].getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            if (StringsKt.n(name, "c2.exynos", false)) {
                z = true;
                break;
            }
            i2++;
        }
        return Boolean.valueOf(z);
    }
}
