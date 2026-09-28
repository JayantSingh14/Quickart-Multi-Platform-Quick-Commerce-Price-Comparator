package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.atomic.AtomicInteger;

@Nullsafe
/* loaded from: classes.dex */
public interface ReactRoot {
    void b();

    void c();

    Bundle getAppProperties();

    int getHeightMeasureSpec();

    String getJSModuleName();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    AtomicInteger getState();

    String getSurfaceID();

    int getUIManagerType();

    int getWidthMeasureSpec();

    void setRootViewTag(int i2);

    void setShouldLogContentAppeared(boolean z);
}
