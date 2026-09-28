package com.facebook.react.turbomodule.core.interfaces;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public interface TurboModuleWithJSIBindings {
    @DoNotStrip
    @NotNull
    BindingsInstallerHolder getBindingsInstaller();
}
