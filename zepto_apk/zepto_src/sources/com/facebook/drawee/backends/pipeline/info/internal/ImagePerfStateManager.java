package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ImageLoadStatus;
import com.facebook.fresco.ui.common.ImagePerfNotifierHolder;
import com.facebook.fresco.ui.common.ImagePerfState;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.fresco.ui.common.VisibilityAware;
import com.facebook.fresco.ui.common.VisibilityState;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class ImagePerfStateManager extends BaseControllerListener2<ImageInfo> implements ImagePerfNotifierHolder, OnDrawControllerListener<ImageInfo>, Closeable, VisibilityAware, VisibilityCallback, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final AwakeTimeSinceBootClock f17219a;

    /* renamed from: b, reason: collision with root package name */
    public final ImagePerfState f17220b;

    /* renamed from: c, reason: collision with root package name */
    public final ImagePerfMonitor f17221c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17222d = true;

    public ImagePerfStateManager(AwakeTimeSinceBootClock awakeTimeSinceBootClock, ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.f17219a = awakeTimeSinceBootClock;
        this.f17220b = imagePerfState;
        this.f17221c = imagePerfMonitor;
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void a(Object obj, String str) {
        this.f17219a.now();
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.getClass();
        imagePerfState.f17478a = str;
        imagePerfState.f17481d = (ImageInfo) obj;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17469b;
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.f17221c.a(imagePerfState, imageLoadStatus);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void c(String str, ControllerListener2.Extras extras) {
        this.f17219a.now();
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.getClass();
        imagePerfState.f17478a = str;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17472e;
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.f17221c.a(imagePerfState, imageLoadStatus);
        if (this.f17222d) {
            imagePerfState.f17482e = VisibilityState.f17488c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.f17479b = null;
        imagePerfState.f17480c = null;
        imagePerfState.f17481d = null;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17468a;
        imagePerfState.f17482e = VisibilityState.f17486a;
        imagePerfState.a();
        throw null;
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void e(String str, Object obj, ControllerListener2.Extras extras) {
        this.f17219a.now();
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.a();
        imagePerfState.f17478a = str;
        imagePerfState.f17480c = obj;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17468a;
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.f17221c.a(imagePerfState, imageLoadStatus);
        if (this.f17222d) {
            imagePerfState.f17482e = VisibilityState.f17487b;
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void l(String str, Throwable th, ControllerListener2.Extras extras) {
        this.f17219a.now();
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.getClass();
        imagePerfState.f17478a = str;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17471d;
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.f17221c.a(imagePerfState, imageLoadStatus);
        imagePerfState.f17482e = VisibilityState.f17488c;
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void r(String str, Object obj, ControllerListener2.Extras extras) {
        this.f17219a.now();
        ImagePerfState imagePerfState = this.f17220b;
        imagePerfState.getClass();
        imagePerfState.f17478a = str;
        imagePerfState.f17481d = (ImageInfo) obj;
        ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17470c;
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.f17221c.a(imagePerfState, imageLoadStatus);
    }
}
