package com.facebook.react.fabric;

import android.os.Trace;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class FabricSoLoader {

    @NotNull
    public static final FabricSoLoader INSTANCE = new FabricSoLoader();
    private static volatile boolean didInit;

    private FabricSoLoader() {
    }

    @JvmStatic
    public static final void staticInit() {
        if (didInit) {
            return;
        }
        Intrinsics.checkNotNullParameter("FabricSoLoader.staticInit::load:fabricjni", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("FabricSoLoader.staticInit::load:fabricjni"));
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.m("fabricjni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        Trace.endSection();
        didInit = true;
    }
}
