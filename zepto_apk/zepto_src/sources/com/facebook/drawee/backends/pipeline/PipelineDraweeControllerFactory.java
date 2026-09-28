package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.xml.XmlDrawableFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class PipelineDraweeControllerFactory {

    /* renamed from: a, reason: collision with root package name */
    public Resources f17206a;

    /* renamed from: b, reason: collision with root package name */
    public DeferredReleaser f17207b;

    /* renamed from: c, reason: collision with root package name */
    public DrawableFactory f17208c;

    /* renamed from: d, reason: collision with root package name */
    public XmlDrawableFactory f17209d;

    /* renamed from: e, reason: collision with root package name */
    public UiThreadImmediateExecutorService f17210e;

    /* renamed from: f, reason: collision with root package name */
    public InstrumentedMemoryCache f17211f;

    /* renamed from: g, reason: collision with root package name */
    public Supplier f17212g;
}
