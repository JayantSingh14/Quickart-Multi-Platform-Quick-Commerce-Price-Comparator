package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ViewManagerDelegate<T extends View> {
    void a(View view, String str, Object obj);

    void b(View view, String str, ReadableArray readableArray);
}
