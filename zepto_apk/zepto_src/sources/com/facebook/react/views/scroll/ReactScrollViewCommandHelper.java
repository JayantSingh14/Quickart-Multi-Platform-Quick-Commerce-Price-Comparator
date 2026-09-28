package com.facebook.react.views.scroll;

import android.support.v4.media.b;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class ReactScrollViewCommandHelper {

    @Metadata
    public static final class Companion {
        public static void a(ScrollCommandHandler scrollCommandHandler, FrameLayout frameLayout, ReadableArray readableArray) {
            scrollCommandHandler.scrollTo(frameLayout, new ScrollToCommandData(Math.round(PixelUtil.b((float) readableArray.getDouble(0))), Math.round(PixelUtil.b((float) readableArray.getDouble(1))), readableArray.getBoolean(2)));
        }
    }

    @Metadata
    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(Object obj);

        void scrollTo(Object obj, ScrollToCommandData scrollToCommandData);

        void scrollToEnd(Object obj, ScrollToEndCommandData scrollToEndCommandData);
    }

    @Metadata
    public static final class ScrollToCommandData {

        /* renamed from: a, reason: collision with root package name */
        public final int f20055a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20056b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f20057c;

        public ScrollToCommandData(int i2, int i3, boolean z) {
            this.f20055a = i2;
            this.f20056b = i3;
            this.f20057c = z;
        }
    }

    @Metadata
    public static final class ScrollToEndCommandData {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f20058a;

        public ScrollToEndCommandData(boolean z) {
            this.f20058a = z;
        }
    }

    public static final void a(ScrollCommandHandler viewManager, FrameLayout frameLayout, int i2, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        if (frameLayout == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (i2 == 1) {
            if (readableArray == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Companion.a(viewManager, frameLayout, readableArray);
        } else if (i2 == 2) {
            if (readableArray == null) {
                throw new IllegalStateException("Required value was null.");
            }
            viewManager.scrollToEnd(frameLayout, new ScrollToEndCommandData(readableArray.getBoolean(0)));
        } else {
            if (i2 == 3) {
                viewManager.flashScrollIndicators(frameLayout);
                return;
            }
            throw new IllegalArgumentException("Unsupported command " + i2 + " received by " + viewManager.getClass().getSimpleName() + CLConstants.DOT_SALT_DELIMETER);
        }
    }

    public static final void b(ScrollCommandHandler viewManager, FrameLayout frameLayout, String commandType, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        if (frameLayout == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iHashCode = commandType.hashCode();
        if (iHashCode != -402165208) {
            if (iHashCode != 28425985) {
                if (iHashCode == 2055114131 && commandType.equals("scrollToEnd")) {
                    if (readableArray == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    viewManager.scrollToEnd(frameLayout, new ScrollToEndCommandData(readableArray.getBoolean(0)));
                    return;
                }
            } else if (commandType.equals("flashScrollIndicators")) {
                viewManager.flashScrollIndicators(frameLayout);
                return;
            }
        } else if (commandType.equals("scrollTo")) {
            if (readableArray == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Companion.a(viewManager, frameLayout, readableArray);
            return;
        }
        throw new IllegalArgumentException(b.m("Unsupported command ", commandType, " received by ", viewManager.getClass().getSimpleName(), CLConstants.DOT_SALT_DELIMETER));
    }
}
