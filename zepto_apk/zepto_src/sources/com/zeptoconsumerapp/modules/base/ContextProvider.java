package com.zeptoconsumerapp.modules.base;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class ContextProvider {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f47615b = new Companion();

    /* renamed from: c, reason: collision with root package name */
    public static volatile ContextProvider f47616c;

    /* renamed from: a, reason: collision with root package name */
    public Context f47617a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public final ContextProvider a() {
            ContextProvider contextProvider;
            ContextProvider contextProvider2 = ContextProvider.f47616c;
            if (contextProvider2 != null) {
                return contextProvider2;
            }
            synchronized (this) {
                contextProvider = ContextProvider.f47616c;
                if (contextProvider == null) {
                    contextProvider = new ContextProvider();
                    ContextProvider.f47616c = contextProvider;
                }
            }
            return contextProvider;
        }
    }

    public final Context a() {
        Context context = this.f47617a;
        if (context != null) {
            return context;
        }
        Intrinsics.h("appContext");
        throw null;
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f47617a = context;
    }
}
