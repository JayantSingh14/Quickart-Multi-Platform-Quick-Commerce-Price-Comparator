package com.facebook.react.common.mapbuffer;

import android.os.Trace;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MapBufferSoLoader {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f18730a;

    public static final void a() {
        if (f18730a) {
            return;
        }
        f18730a = true;
        Intrinsics.checkNotNullParameter("ReadableMapBufferSoLoader.staticInit::load:mapbufferjni", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReadableMapBufferSoLoader.staticInit::load:mapbufferjni"));
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_START);
        SoLoader.m("mapbufferjni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_END);
        Trace.endSection();
    }
}
