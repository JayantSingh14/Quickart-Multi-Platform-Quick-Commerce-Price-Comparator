package com.facebook.react.internal;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.ChoreographerProvider;
import com.facebook.react.modules.core.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class AndroidChoreographerProvider implements ChoreographerProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidChoreographerProvider f18966a = new AndroidChoreographerProvider();

    @Metadata
    public static final class AndroidChoreographer implements ChoreographerProvider.Choreographer {

        /* renamed from: a, reason: collision with root package name */
        public final Choreographer f18967a;

        public AndroidChoreographer() {
            Choreographer choreographer = Choreographer.getInstance();
            Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance(...)");
            this.f18967a = choreographer;
        }

        @Override // com.facebook.react.internal.ChoreographerProvider.Choreographer
        public final void a(d callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f18967a.removeFrameCallback(callback);
        }

        @Override // com.facebook.react.internal.ChoreographerProvider.Choreographer
        public final void b(d callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f18967a.postFrameCallback(callback);
        }
    }

    @Override // com.facebook.react.internal.ChoreographerProvider
    public final ChoreographerProvider.Choreographer a() {
        UiThreadUtil.assertOnUiThread();
        return new AndroidChoreographer();
    }
}
