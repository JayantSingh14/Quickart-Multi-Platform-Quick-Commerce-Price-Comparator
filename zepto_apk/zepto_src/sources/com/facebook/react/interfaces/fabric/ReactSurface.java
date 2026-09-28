package com.facebook.react.interfaces.fabric;

import android.view.ViewGroup;
import com.facebook.react.runtime.internal.bolts.Task;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ReactSurface {
    ViewGroup getView();

    Task start();

    Task stop();
}
