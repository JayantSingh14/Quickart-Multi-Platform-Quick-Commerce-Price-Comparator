package com.facebook.react.modules.core;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface PermissionAwareActivity {
    void d(String[] strArr, int i2, PermissionListener permissionListener);

    boolean shouldShowRequestPermissionRationale(String str);
}
