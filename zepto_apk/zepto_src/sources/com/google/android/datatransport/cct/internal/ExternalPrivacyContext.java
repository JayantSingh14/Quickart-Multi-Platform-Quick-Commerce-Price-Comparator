package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExternalPrivacyContext;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ExternalPrivacyContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract ExternalPrivacyContext a();

        public abstract Builder b(ExternalPRequestContext externalPRequestContext);
    }

    public static Builder a() {
        return new AutoValue_ExternalPrivacyContext.Builder();
    }

    public abstract ExternalPRequestContext b();
}
