package com.facebook.react.runtime;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BridgelessReactStateTracker {

    /* renamed from: a, reason: collision with root package name */
    public final List f19236a = Collections.synchronizedList(new ArrayList());

    @Metadata
    public static final class Companion {
    }

    public final void a(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        FLog.q("BridgelessReact", state);
    }
}
