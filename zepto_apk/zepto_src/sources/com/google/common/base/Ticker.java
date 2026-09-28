package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class Ticker {

    /* renamed from: com.google.common.base.Ticker$1, reason: invalid class name */
    public class AnonymousClass1 extends Ticker {
        @Override // com.google.common.base.Ticker
        public final long a() {
            return System.nanoTime();
        }
    }

    public abstract long a();
}
