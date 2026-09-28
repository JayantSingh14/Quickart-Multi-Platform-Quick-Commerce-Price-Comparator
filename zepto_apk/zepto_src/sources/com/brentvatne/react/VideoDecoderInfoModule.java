package com.brentvatne.react;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.media.MediaFormat;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class VideoDecoderInfoModule extends ReactContextBaseJavaModule {

    @NotNull
    private static final String REACT_CLASS = "VideoDecoderInfoModule";

    @NotNull
    private static final String SECURITY_LEVEL_PROPERTY = "securityLevel";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    @Metadata
    public static final class Companion {
    }

    public VideoDecoderInfoModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @ReactMethod
    public final void getWidevineLevel(@NotNull Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        int i2 = 0;
        try {
            String propertyString = new MediaDrm(WIDEVINE_UUID).getPropertyString(SECURITY_LEVEL_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(propertyString, "getPropertyString(...)");
            switch (propertyString.hashCode()) {
                case 2405:
                    if (propertyString.equals("L1")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 2406:
                    if (!propertyString.equals("L2")) {
                        break;
                    } else {
                        i2 = 2;
                        break;
                    }
                case 2407:
                    if (!propertyString.equals("L3")) {
                        break;
                    } else {
                        i2 = 3;
                        break;
                    }
            }
        } catch (UnsupportedSchemeException e2) {
            e2.printStackTrace();
        }
        p.resolve(Integer.valueOf(i2));
    }

    @ReactMethod
    public final void isCodecSupported(@Nullable String str, double d2, double d3, @Nullable Promise promise) {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        MediaCodecList mediaCodecList = new MediaCodecList(0);
        Intrinsics.c(str);
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(str, (int) d2, (int) d3);
        Intrinsics.checkNotNullExpressionValue(mediaFormatCreateVideoFormat, "createVideoFormat(...)");
        String strFindDecoderForFormat = mediaCodecList.findDecoderForFormat(mediaFormatCreateVideoFormat);
        if (strFindDecoderForFormat == null) {
            if (promise != null) {
                promise.resolve("unsupported");
                return;
            }
            return;
        }
        if (i2 < 29) {
            if (promise != null) {
                promise.resolve("software");
                return;
            }
            return;
        }
        MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
        Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
        int length = codecInfos.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            MediaCodecInfo mediaCodecInfo = codecInfos[i3];
            if (StringsKt.t(mediaCodecInfo.getName(), strFindDecoderForFormat, true) && mediaCodecInfo.isHardwareAccelerated()) {
                z = true;
                break;
            }
            i3++;
        }
        if (promise != null) {
            promise.resolve(z ? "software" : "hardware");
        }
    }

    @ReactMethod
    public final void isHEVCSupported(@NotNull Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        isCodecSupported("video/hevc", 1920.0d, 1080.0d, p);
    }
}
