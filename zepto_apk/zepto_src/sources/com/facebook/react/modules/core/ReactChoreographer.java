package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.ChoreographerProvider;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactChoreographer {

    /* renamed from: f, reason: collision with root package name */
    public static ReactChoreographer f19063f;

    /* renamed from: a, reason: collision with root package name */
    public ChoreographerProvider.Choreographer f19064a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque[] f19065b;

    /* renamed from: c, reason: collision with root package name */
    public int f19066c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19067d;

    /* renamed from: e, reason: collision with root package name */
    public final d f19068e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class CallbackType {

        /* renamed from: b, reason: collision with root package name */
        public static final CallbackType f19069b;

        /* renamed from: c, reason: collision with root package name */
        public static final CallbackType f19070c;

        /* renamed from: d, reason: collision with root package name */
        public static final CallbackType f19071d;

        /* renamed from: e, reason: collision with root package name */
        public static final CallbackType f19072e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ CallbackType[] f19073f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f19074g;

        /* renamed from: a, reason: collision with root package name */
        public final int f19075a;

        static {
            CallbackType callbackType = new CallbackType("PERF_MARKERS", 0, 0);
            CallbackType callbackType2 = new CallbackType("DISPATCH_UI", 1, 1);
            f19069b = callbackType2;
            CallbackType callbackType3 = new CallbackType("NATIVE_ANIMATED_MODULE", 2, 2);
            f19070c = callbackType3;
            CallbackType callbackType4 = new CallbackType("TIMERS_EVENTS", 3, 3);
            f19071d = callbackType4;
            CallbackType callbackType5 = new CallbackType("IDLE_EVENT", 4, 4);
            f19072e = callbackType5;
            CallbackType[] callbackTypeArr = {callbackType, callbackType2, callbackType3, callbackType4, callbackType5};
            f19073f = callbackTypeArr;
            f19074g = EnumEntriesKt.a(callbackTypeArr);
        }

        public CallbackType(String str, int i2, int i3) {
            this.f19075a = i3;
        }

        public static CallbackType valueOf(String str) {
            return (CallbackType) Enum.valueOf(CallbackType.class, str);
        }

        public static CallbackType[] values() {
            return (CallbackType[]) f19073f.clone();
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static ReactChoreographer a() {
            ReactChoreographer reactChoreographer = ReactChoreographer.f19063f;
            if (reactChoreographer != null) {
                return reactChoreographer;
            }
            throw new IllegalStateException("ReactChoreographer needs to be initialized.");
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.facebook.react.modules.core.d] */
    public ReactChoreographer(ChoreographerProvider choreographerProvider) {
        int iB = ((AbstractCollection) CallbackType.f19074g).b();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[iB];
        for (int i2 = 0; i2 < iB; i2++) {
            arrayDequeArr[i2] = new ArrayDeque();
        }
        this.f19065b = arrayDequeArr;
        this.f19068e = new Choreographer.FrameCallback() { // from class: com.facebook.react.modules.core.d
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                ReactChoreographer reactChoreographer = this.f19079a;
                synchronized (reactChoreographer.f19065b) {
                    try {
                        reactChoreographer.f19067d = false;
                        int length = reactChoreographer.f19065b.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            ArrayDeque arrayDeque = reactChoreographer.f19065b[i3];
                            int size = arrayDeque.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                Choreographer.FrameCallback frameCallback = (Choreographer.FrameCallback) arrayDeque.pollFirst();
                                if (frameCallback != null) {
                                    frameCallback.doFrame(j2);
                                    reactChoreographer.f19066c--;
                                } else {
                                    FLog.g("ReactNative", "Tried to execute non-existent frame callback");
                                }
                            }
                        }
                        reactChoreographer.a();
                        Unit unit = Unit.f53572a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        UiThreadUtil.runOnUiThread(new androidx.media3.common.util.c(1, this, choreographerProvider));
    }

    public final void a() {
        Assertions.a(this.f19066c >= 0);
        if (this.f19066c == 0 && this.f19067d) {
            ChoreographerProvider.Choreographer choreographer = this.f19064a;
            if (choreographer != null) {
                choreographer.a(this.f19068e);
            }
            this.f19067d = false;
        }
    }

    public final void b(CallbackType type, Choreographer.FrameCallback callback) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f19065b) {
            this.f19065b[type.f19075a].addLast(callback);
            int i2 = this.f19066c + 1;
            this.f19066c = i2;
            Assertions.a(i2 > 0);
            if (!this.f19067d) {
                ChoreographerProvider.Choreographer choreographer = this.f19064a;
                if (choreographer == null) {
                    UiThreadUtil.runOnUiThread(new androidx.lifecycle.a(this, 4));
                } else {
                    choreographer.b(this.f19068e);
                    this.f19067d = true;
                }
            }
            Unit unit = Unit.f53572a;
        }
    }

    public final void c(CallbackType type, Choreographer.FrameCallback frameCallback) {
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.f19065b) {
            try {
                if (this.f19065b[type.f19075a].removeFirstOccurrence(frameCallback)) {
                    this.f19066c--;
                    a();
                } else {
                    FLog.g("ReactNative", "Tried to remove non-existent frame callback");
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
