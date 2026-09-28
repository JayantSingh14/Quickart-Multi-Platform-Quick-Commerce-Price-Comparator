package com.facebook.react.devsupport;

import com.facebook.soloader.SoLoader;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class DevSupportSoLoader {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f18841a;

    public static final synchronized void a() {
        if (f18841a) {
            return;
        }
        SoLoader.m("react_devsupportjni");
        f18841a = true;
    }
}
