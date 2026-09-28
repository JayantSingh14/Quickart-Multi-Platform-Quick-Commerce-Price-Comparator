package com.appsflyer.internal;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class AFh1hSDK extends AFh1nSDK {
    public AFh1hSDK() {
        this(null, null);
    }

    @Override // com.appsflyer.internal.AFh1rSDK
    public final boolean component2() {
        return false;
    }

    @Override // com.appsflyer.internal.AFh1rSDK
    public final boolean component4() {
        return false;
    }

    @Override // com.appsflyer.internal.AFh1rSDK
    public final boolean getRevenue() {
        return false;
    }

    public AFh1hSDK(@Nullable String str, @Nullable Boolean bool) {
        super(str, Boolean.FALSE, bool);
    }
}
