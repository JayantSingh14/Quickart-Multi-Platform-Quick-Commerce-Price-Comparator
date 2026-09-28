package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.locks.ReentrantLock;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class Monitor {

    public static abstract class Guard {
    }

    public Monitor() {
        new ReentrantLock(false);
    }
}
