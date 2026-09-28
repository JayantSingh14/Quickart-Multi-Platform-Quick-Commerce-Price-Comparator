package com.facebook.fresco.ui.common;

import com.facebook.fresco.ui.common.ControllerListener2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {

    @Metadata
    public static final class Companion {
    }

    static {
        new BaseControllerListener2();
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void a(Object obj, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void b(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void c(String id, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void e(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void l(String id, Throwable th, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void r(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }
}
