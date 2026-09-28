package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class ReactSoftExceptionLogger {

    @NotNull
    public static final ReactSoftExceptionLogger INSTANCE = new ReactSoftExceptionLogger();

    @NotNull
    private static final List<ReactSoftExceptionListener> listeners = new CopyOnWriteArrayList();

    @Metadata
    public static final class Categories {

        @NotNull
        public static final Categories INSTANCE = new Categories();

        @NotNull
        public static final String RVG_IS_VIEW_CLIPPED = "ReactViewGroup.isViewClipped";

        @NotNull
        public static final String RVG_ON_VIEW_REMOVED = "ReactViewGroup.onViewRemoved";

        @NotNull
        public static final String SOFT_ASSERTIONS = "SoftAssertions";

        private Categories() {
        }
    }

    @Metadata
    public interface ReactSoftExceptionListener {
        void logSoftException(@NotNull String str, @NotNull Throwable th);
    }

    private ReactSoftExceptionLogger() {
    }

    @JvmStatic
    public static final void addListener(@NotNull ReactSoftExceptionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<ReactSoftExceptionListener> list = listeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    @JvmStatic
    public static final void clearListeners() {
        listeners.clear();
    }

    @JvmStatic
    @DoNotStrip
    private static final void logNoThrowSoftExceptionWithMessage(String str, String str2) {
        logSoftException(str, new ReactNoCrashSoftException(str2));
    }

    @JvmStatic
    public static final void logSoftException(@NotNull String category, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(cause, "cause");
        List<ReactSoftExceptionListener> list = listeners;
        if (list.isEmpty()) {
            FLog.h(category, "Unhandled SoftException", cause);
            return;
        }
        Iterator<ReactSoftExceptionListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().logSoftException(category, cause);
        }
    }

    @JvmStatic
    public static final void logSoftExceptionVerbose(@NotNull String category, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(cause, "cause");
        logSoftException(category + CLConstants.SALT_DELIMETER + cause.getClass().getSimpleName() + ":" + cause.getMessage(), cause);
    }

    @JvmStatic
    public static final void removeListener(@NotNull ReactSoftExceptionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }
}
