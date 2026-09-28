package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.sidesheet.SheetCallback;
import com.google.android.material.sidesheet.SideSheetDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
interface Sheet<C extends SheetCallback> extends MaterialBackHandler {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface SheetEdge {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface SheetState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface StableSheetState {
    }

    void a(SideSheetDialog.AnonymousClass1 anonymousClass1);

    void f(int i2);

    int getState();
}
