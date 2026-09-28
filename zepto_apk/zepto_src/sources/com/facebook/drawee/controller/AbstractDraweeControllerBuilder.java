package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.atomic.AtomicLong;

@Nullsafe
/* loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {

    /* renamed from: g, reason: collision with root package name */
    public static final ControllerListener f17262g = new BaseControllerListener<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void l(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public static final NullPointerException f17263h = new NullPointerException("No image request was specified!");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicLong f17264i = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public Object f17265a;

    /* renamed from: b, reason: collision with root package name */
    public ImageRequest f17266b;

    /* renamed from: c, reason: collision with root package name */
    public ImageRequest f17267c;

    /* renamed from: d, reason: collision with root package name */
    public ControllerListener f17268d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17269e;

    /* renamed from: f, reason: collision with root package name */
    public DraweeController f17270f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class CacheLevel {

        /* renamed from: a, reason: collision with root package name */
        public static final CacheLevel f17277a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ CacheLevel[] f17278b;

        static {
            CacheLevel cacheLevel = new CacheLevel("FULL_FETCH", 0);
            f17277a = cacheLevel;
            f17278b = new CacheLevel[]{cacheLevel, new CacheLevel("DISK_CACHE", 1), new CacheLevel("BITMAP_MEMORY_CACHE", 2)};
        }

        public static CacheLevel valueOf(String str) {
            return (CacheLevel) Enum.valueOf(CacheLevel.class, str);
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) f17278b.clone();
        }
    }

    public final AbstractDraweeController a() {
        ImageRequest imageRequest;
        if (this.f17266b == null && (imageRequest = this.f17267c) != null) {
            this.f17266b = imageRequest;
            this.f17267c = null;
        }
        FrescoSystrace.a();
        PipelineDraweeController pipelineDraweeControllerE = e();
        ControllerListener controllerListener = this.f17268d;
        if (controllerListener != null) {
            pipelineDraweeControllerE.f(controllerListener);
        }
        if (this.f17269e) {
            pipelineDraweeControllerE.f(f17262g);
        }
        FrescoSystrace.a();
        return pipelineDraweeControllerE;
    }

    public abstract AbstractDataSource b(PipelineDraweeController pipelineDraweeController, String str, Object obj, Object obj2, CacheLevel cacheLevel);

    public final Supplier c(final PipelineDraweeController pipelineDraweeController, final String str, final Object obj, final CacheLevel cacheLevel) {
        final Object obj2 = this.f17265a;
        return new Supplier<DataSource<Object>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            @Override // com.facebook.common.internal.Supplier
            public final Object get() {
                return AbstractDraweeControllerBuilder.this.b(pipelineDraweeController, str, obj, obj2, cacheLevel);
            }

            public final String toString() {
                Objects.ToStringHelper toStringHelperB = Objects.b(this);
                toStringHelperB.c(obj.toString(), "request");
                return toStringHelperB.toString();
            }
        };
    }

    public final void d() {
        this.f17265a = null;
        this.f17266b = null;
        this.f17267c = null;
        this.f17268d = null;
        this.f17269e = false;
        this.f17270f = null;
    }

    public abstract PipelineDraweeController e();
}
