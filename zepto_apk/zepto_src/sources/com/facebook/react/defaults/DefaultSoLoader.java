package com.facebook.react.defaults;

import com.facebook.soloader.SoLoader;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultSoLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f18756a = new Companion();

    @Metadata
    public static final class Companion {
        public final synchronized void a() {
            SoLoader.m("react_newarchdefaults");
            try {
                SoLoader.m("appmodules");
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }
}
