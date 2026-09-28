package com.facebook.drawee.backends.pipeline.info;

import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfStateManager;
import com.facebook.fresco.ui.common.ImageLoadStatus;
import com.facebook.fresco.ui.common.ImagePerfNotifier;
import com.facebook.fresco.ui.common.ImagePerfState;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.infer.annotation.Nullsafe;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class ImagePerfMonitor implements ImagePerfNotifier {

    /* renamed from: a, reason: collision with root package name */
    public ImagePerfRequestListener f17213a;

    /* renamed from: b, reason: collision with root package name */
    public ImagePerfStateManager f17214b;

    /* renamed from: c, reason: collision with root package name */
    public ForwardingRequestListener f17215c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17216d;

    public final void a(ImagePerfState imagePerfState, ImageLoadStatus imageLoadStatus) {
        imagePerfState.getClass();
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
    }

    public final void b(boolean z) {
        this.f17216d = z;
        if (!z) {
            if (this.f17214b != null || this.f17215c != null) {
                throw null;
            }
            return;
        }
        if (this.f17214b == null) {
            this.f17214b = new ImagePerfStateManager(null, null, this);
        }
        if (this.f17213a == null) {
            this.f17213a = new ImagePerfRequestListener(null, null);
        }
        if (this.f17215c == null) {
            this.f17215c = new ForwardingRequestListener(this.f17213a);
        }
        if (this.f17214b != null || this.f17215c != null) {
            throw null;
        }
    }
}
