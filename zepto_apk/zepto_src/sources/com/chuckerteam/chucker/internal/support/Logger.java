package com.chuckerteam.chucker.internal.support;

import android.util.Log;
import com.chuckerteam.chucker.api.Chucker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public interface Logger {

    @Metadata
    public static final class Companion implements Logger {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f16778a = new Companion();

        public final void a(String message, Throwable th) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(message, "message");
            Log.e("Chucker", message, th);
        }

        public final void b(String message, Exception exc) {
            Intrinsics.checkNotNullParameter(message, "message");
            Chucker.f16595a.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            Log.w("Chucker", message, exc);
        }
    }

    @Metadata
    public static final class DefaultImpls {
        public static void a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            Chucker.f16595a.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            Log.i("Chucker", message, null);
        }
    }
}
