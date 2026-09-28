package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MainPackageConfig {

    /* renamed from: a, reason: collision with root package name */
    public final ImagePipelineConfig f19359a;

    public MainPackageConfig(ImagePipelineConfig frescoConfig) {
        Intrinsics.checkNotNullParameter(frescoConfig, "frescoConfig");
        this.f19359a = frescoConfig;
    }
}
