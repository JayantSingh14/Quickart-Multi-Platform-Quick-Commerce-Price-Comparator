package com.facebook.react.runtime.internal.bolts;

import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Executors {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f19309a = new UIThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f19310b = new ImmediateExecutor();

    @Metadata
    public static final class ImmediateExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            command.run();
        }
    }

    @Metadata
    public static final class UIThreadExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            UiThreadUtil.runOnUiThread(command);
        }
    }
}
