package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ImagePipelineExperiments {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultProducerFactoryMethod f17859a;

    /* renamed from: b, reason: collision with root package name */
    public final Supplier f17860b;

    /* renamed from: c, reason: collision with root package name */
    public final Supplier f17861c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17862d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17863e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17864f;

    /* renamed from: g, reason: collision with root package name */
    public final int f17865g;

    /* renamed from: h, reason: collision with root package name */
    public final PlatformDecoderOptions f17866h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f17867i;

    @Metadata
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Supplier f17868a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f17869b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f17870c;

        /* renamed from: d, reason: collision with root package name */
        public int f17871d;

        /* renamed from: e, reason: collision with root package name */
        public int f17872e;

        /* renamed from: f, reason: collision with root package name */
        public PlatformDecoderOptions f17873f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f17874g;
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
    }

    @Metadata
    public interface ProducerFactoryMethod {
    }

    public ImagePipelineExperiments(Builder builder) {
        builder.getClass();
        this.f17859a = new DefaultProducerFactoryMethod();
        Supplier BOOLEAN_FALSE = Suppliers.f17085b;
        Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        this.f17860b = BOOLEAN_FALSE;
        this.f17861c = builder.f17868a;
        this.f17862d = builder.f17869b;
        this.f17863e = builder.f17870c;
        this.f17864f = builder.f17871d;
        this.f17865g = builder.f17872e;
        this.f17866h = builder.f17873f;
        this.f17867i = builder.f17874g;
    }
}
