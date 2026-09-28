package com.facebook.react.module.model;

import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactModuleInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f19020a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19021b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19022c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19023d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19024e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19025f;

    @Metadata
    public static final class Companion {
        public static boolean a(Class clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return TurboModule.class.isAssignableFrom(clazz);
        }
    }

    public ReactModuleInfo(String name, String className, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(className, "className");
        this.f19020a = name;
        this.f19021b = className;
        this.f19022c = z;
        this.f19023d = z2;
        this.f19024e = z3;
        this.f19025f = z4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactModuleInfo(String name, String className, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this(name, className, z, z2, z3, z4);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(className, "className");
    }
}
