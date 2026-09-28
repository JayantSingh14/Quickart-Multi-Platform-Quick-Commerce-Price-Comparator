package com.facebook.react.devsupport;

import android.os.Build;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class WindowOverlayCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18918a;

    static {
        f18918a = Build.VERSION.SDK_INT < 26 ? 2006 : 2038;
    }
}
