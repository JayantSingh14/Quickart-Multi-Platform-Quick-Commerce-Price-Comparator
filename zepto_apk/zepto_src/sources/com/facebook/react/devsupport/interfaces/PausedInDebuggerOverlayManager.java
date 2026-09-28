package com.facebook.react.devsupport.interfaces;

import com.facebook.react.devsupport.interfaces.DevSupportManager;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface PausedInDebuggerOverlayManager {
    void a(String str, DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener);

    void b();
}
