package com.facebook.systrace;

import android.os.Trace;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SystraceMessage {

    @Metadata
    public static abstract class Builder {
        public abstract Builder a(int i2, String str);

        public abstract Builder b(Object obj, String str);

        public abstract void c();
    }

    @Metadata
    public static final class EndSectionBuilder extends Builder {
        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final Builder a(int i2, String str) {
            throw null;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final Builder b(Object obj, String str) {
            throw null;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final void c() {
            Trace.endSection();
        }
    }

    @Metadata
    public static final class StartSectionBuilder extends Builder {

        /* renamed from: a, reason: collision with root package name */
        public final String f20326a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f20327b;

        public StartSectionBuilder(String sectionName) {
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.f20326a = sectionName;
            this.f20327b = new ArrayList();
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final Builder a(int i2, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            String strValueOf = String.valueOf(i2);
            this.f20327b.add(key + ": " + strValueOf);
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final Builder b(Object value, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            String string = value.toString();
            this.f20327b.add(key + ": " + string);
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public final void c() {
            Systrace.a(this.f20326a + "");
        }
    }

    public static final Builder a(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        return new StartSectionBuilder(sectionName);
    }

    public static final Builder b() {
        return new EndSectionBuilder();
    }
}
