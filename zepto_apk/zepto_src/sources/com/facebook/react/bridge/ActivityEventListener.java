package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface ActivityEventListener {
    void onActivityResult(Activity activity, int i2, int i3, @Nullable Intent intent);

    void onNewIntent(Intent intent);

    default void onUserLeaveHint(Activity activity) {
    }
}
