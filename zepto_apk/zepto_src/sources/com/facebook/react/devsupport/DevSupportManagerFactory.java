package com.facebook.react.devsupport;

import android.app.Application;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/* loaded from: classes.dex */
public interface DevSupportManagerFactory {
    DevSupportManager a(Application application, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z, int i2, SurfaceDelegateFactory surfaceDelegateFactory);
}
