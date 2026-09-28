package com.appsflyer.internal;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class AFh1nSDK extends AFh1rSDK {
    private final boolean copy;
    private final boolean copydefault;

    public AFh1nSDK() {
        this(null, null, null);
    }

    public AFh1nSDK(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        super(str, null, Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false));
        this.copy = bool != null ? bool.booleanValue() : true;
        this.copydefault = true;
    }
}
