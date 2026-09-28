package com.unistyles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class UnistylesModule$configurationChangeReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ UnistylesModule this$0;

    public UnistylesModule$configurationChangeReceiver$1(UnistylesModule unistylesModule) {
        this.this$0 = unistylesModule;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (this.this$0.isCxxReady) {
            if (Intrinsics.b(intent.getAction(), "android.intent.action.CONFIGURATION_CHANGED")) {
                new Handler(Looper.getMainLooper()).postDelayed(new com.swmansion.gesturehandler.react.b(this.this$0, 4), 10L);
            }
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration.orientation != this.this$0.platform.getOrientation()) {
                this.this$0.platform.setOrientation(configuration.orientation);
                this.this$0.onLayoutConfigChange();
            }
        }
    }
}
