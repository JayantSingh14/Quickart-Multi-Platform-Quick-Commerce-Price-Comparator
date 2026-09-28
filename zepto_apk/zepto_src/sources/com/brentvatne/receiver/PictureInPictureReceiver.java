package com.brentvatne.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PictureInPictureReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final ReactExoplayerView f15644a;

    /* renamed from: b, reason: collision with root package name */
    public final ThemedReactContext f15645b;

    @Metadata
    public static final class Companion {
    }

    public PictureInPictureReceiver(ThemedReactContext context, ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15644a = view;
        this.f15645b = context;
    }

    public final void a() {
        try {
            this.f15645b.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    public final void b() {
        ContextCompat.e(this.f15645b, this, new IntentFilter("rnv_media_control"), 4);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && Intrinsics.b(intent.getAction(), "rnv_media_control")) {
            int intExtra = intent.getIntExtra("rnv_control_type", 0);
            ReactExoplayerView reactExoplayerView = this.f15644a;
            if (intExtra == 1) {
                reactExoplayerView.setPausedModifier(false);
            } else {
                if (intExtra != 2) {
                    return;
                }
                reactExoplayerView.setPausedModifier(true);
            }
        }
    }
}
