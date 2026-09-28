package com.swmansion.rnscreens;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ScreenFragmentWrapper extends FragmentHolder, ScreenEventDispatcher {
    Screen k();

    boolean l();

    Activity m();

    List n();

    void o(ScreenContainer screenContainer);

    void p();

    void q(ScreenContainer screenContainer);

    ReactContext r();
}
