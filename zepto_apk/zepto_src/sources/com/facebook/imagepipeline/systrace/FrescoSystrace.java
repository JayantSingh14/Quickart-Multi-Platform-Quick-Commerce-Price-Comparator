package com.facebook.imagepipeline.systrace;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class FrescoSystrace {

    /* renamed from: a, reason: collision with root package name */
    public static DefaultFrescoSystrace f18383a;

    @Metadata
    public interface ArgsBuilder {
    }

    @Metadata
    public static final class NoOpArgsBuilder implements ArgsBuilder {
    }

    @Metadata
    public interface Systrace {
    }

    static {
        new NoOpArgsBuilder();
    }

    public static Systrace a() {
        DefaultFrescoSystrace defaultFrescoSystrace;
        DefaultFrescoSystrace defaultFrescoSystrace2 = f18383a;
        if (defaultFrescoSystrace2 != null) {
            return defaultFrescoSystrace2;
        }
        synchronized (FrescoSystrace.class) {
            defaultFrescoSystrace = new DefaultFrescoSystrace();
            f18383a = defaultFrescoSystrace;
        }
        return defaultFrescoSystrace;
    }
}
