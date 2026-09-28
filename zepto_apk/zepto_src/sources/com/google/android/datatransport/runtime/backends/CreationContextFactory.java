package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes.dex */
class CreationContextFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20784a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f20785b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f20786c;

    public CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.f20784a = context;
        this.f20785b = clock;
        this.f20786c = clock2;
    }
}
