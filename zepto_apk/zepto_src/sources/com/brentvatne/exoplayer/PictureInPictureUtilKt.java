package com.brentvatne.exoplayer;

import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PictureInPictureUtilKt {
    public static final ComponentActivity a(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "<this>");
        for (ContextWrapper baseContext = themedReactContext; baseContext instanceof ContextWrapper; baseContext = baseContext.getBaseContext()) {
            if (baseContext instanceof ComponentActivity) {
                return (ComponentActivity) baseContext;
            }
        }
        throw new IllegalStateException("Picture in picture should be called in the context of an Activity");
    }
}
