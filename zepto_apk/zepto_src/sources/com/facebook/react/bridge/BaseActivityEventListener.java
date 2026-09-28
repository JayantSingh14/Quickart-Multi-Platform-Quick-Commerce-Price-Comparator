package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class BaseActivityEventListener implements ActivityEventListener {
    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, @Nullable Intent intent) {
    }
}
