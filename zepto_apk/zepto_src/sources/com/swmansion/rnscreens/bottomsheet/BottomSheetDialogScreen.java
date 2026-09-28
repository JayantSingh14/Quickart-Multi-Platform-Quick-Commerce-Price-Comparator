package com.swmansion.rnscreens.bottomsheet;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.swmansion.rnscreens.ScreenModalFragment;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: classes4.dex */
public final class BottomSheetDialogScreen extends BottomSheetDialog {
    public final WeakReference r;

    @Metadata
    public static final class Companion {
    }

    static {
        Reflection.a(BottomSheetDialogScreen.class).i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogScreen(Context context, ScreenModalFragment fragment) {
        super(context, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.o = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
        this.r = new WeakReference(fragment);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        Object obj = this.r.get();
        Intrinsics.c(obj);
        ((ScreenModalFragment) obj).k();
        throw null;
    }
}
