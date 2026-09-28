package com.swmansion.rnscreens.ext;

import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FragmentExtKt {
    public static final ScreenStackFragment a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return (ScreenStackFragment) fragment;
    }
}
