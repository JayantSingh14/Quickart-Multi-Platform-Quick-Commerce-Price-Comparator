package io.sentry.android.replay;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReplayLifecycle {

    /* renamed from: a, reason: collision with root package name */
    public volatile ReplayState f52456a = ReplayState.INITIAL;

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52457a;

        static {
            int[] iArr = new int[ReplayState.values().length];
            try {
                iArr[ReplayState.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReplayState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReplayState.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReplayState.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReplayState.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReplayState.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f52457a = iArr;
        }
    }

    public final boolean a(ReplayState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        switch (WhenMappings.f52457a[this.f52456a.ordinal()]) {
            case 1:
                return newState == ReplayState.STARTED || newState == ReplayState.CLOSED;
            case 2:
                return newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 3:
                return newState == ReplayState.PAUSED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 4:
                return newState == ReplayState.RESUMED || newState == ReplayState.STOPPED || newState == ReplayState.CLOSED;
            case 5:
                return newState == ReplayState.STARTED || newState == ReplayState.CLOSED;
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
