package com.facebook.react.bridge;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface LifecycleEventListener {
    void onHostDestroy();

    void onHostPause();

    void onHostResume();
}
