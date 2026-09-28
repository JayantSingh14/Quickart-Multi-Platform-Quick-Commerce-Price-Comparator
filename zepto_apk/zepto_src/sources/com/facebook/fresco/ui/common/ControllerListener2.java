package com.facebook.fresco.ui.common;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public interface ControllerListener2<INFO> {

    @Metadata
    public static final class Extras {

        /* renamed from: a, reason: collision with root package name */
        public Map f17462a;

        /* renamed from: b, reason: collision with root package name */
        public Map f17463b;

        /* renamed from: c, reason: collision with root package name */
        public Map f17464c;

        /* renamed from: d, reason: collision with root package name */
        public Map f17465d;

        /* renamed from: e, reason: collision with root package name */
        public Object f17466e;

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
        }
    }

    void a(Object obj, String str);

    void b(String str);

    void c(String str, Extras extras);

    void e(String str, Object obj, Extras extras);

    void l(String str, Throwable th, Extras extras);

    void r(String str, Object obj, Extras extras);
}
