package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExperimentIds;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ExperimentIds {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract ExperimentIds a();

        public abstract Builder b(byte[] bArr);

        public abstract Builder c(byte[] bArr);
    }

    public static Builder a() {
        return new AutoValue_ExperimentIds.Builder();
    }

    public abstract byte[] b();

    public abstract byte[] c();
}
