package com.facebook.react.modules.sound;

import android.media.AudioManager;
import com.facebook.fbreact.specs.NativeSoundManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "SoundManager")
@Metadata
/* loaded from: classes.dex */
public final class SoundManagerModule extends NativeSoundManagerSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "SoundManager";

    @Metadata
    public static final class Companion {
    }

    public SoundManagerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeSoundManagerSpec
    public void playTouchSound() {
        Object systemService = getReactApplicationContext().getSystemService("audio");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ((AudioManager) systemService).playSoundEffect(0);
    }
}
