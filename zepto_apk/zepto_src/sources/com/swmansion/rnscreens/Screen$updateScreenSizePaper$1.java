package com.swmansion.rnscreens;

import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class Screen$updateScreenSizePaper$1 extends GuardedRunnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Screen f46986a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f46987b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46988c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Screen$updateScreenSizePaper$1(Screen screen, int i2, int i3, JSExceptionHandler jSExceptionHandler) {
        super(jSExceptionHandler);
        this.f46986a = screen;
        this.f46987b = i2;
        this.f46988c = i3;
    }

    @Override // com.facebook.react.bridge.GuardedRunnable
    public final void runGuarded() {
        Screen screen = this.f46986a;
        UIManagerModule uIManagerModule = (UIManagerModule) screen.getReactContext().f19479a.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.updateNodeSize(screen.getId(), this.f46987b, this.f46988c);
        }
    }
}
