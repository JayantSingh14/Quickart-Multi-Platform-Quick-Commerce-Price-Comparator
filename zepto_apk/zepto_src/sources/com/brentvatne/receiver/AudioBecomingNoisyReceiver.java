package com.brentvatne.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.brentvatne.receiver.BecomingNoisyListener;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class AudioBecomingNoisyReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public BecomingNoisyListener f15641a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f15642b;

    public AudioBecomingNoisyReceiver(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15641a = BecomingNoisyListener.Companion.f15643a;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f15642b = applicationContext;
    }

    public final void a() {
        this.f15641a = BecomingNoisyListener.Companion.f15643a;
        try {
            this.f15642b.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    public final void b(ReactExoplayerView listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f15641a = listener;
        ContextCompat.e(this.f15642b, this, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"), 4);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            return;
        }
        this.f15641a.h();
    }
}
