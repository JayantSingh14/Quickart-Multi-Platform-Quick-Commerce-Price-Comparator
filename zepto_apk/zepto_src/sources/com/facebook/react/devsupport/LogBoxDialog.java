package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LogBoxDialog extends Dialog {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f18855b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final View f18856a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogBoxDialog(Activity context, View view) {
        super(context, R.style.Theme_Catalyst_LogBox);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f18856a = view;
        requestWindowFeature(1);
        if (view != null) {
            setContentView(view);
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        View view = this.f18856a;
        if (view != null) {
            final i iVar = new i();
            ViewCompat.H(view, new OnApplyWindowInsetsListener() { // from class: com.facebook.react.devsupport.j
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat b(View p0, WindowInsetsCompat p1) {
                    int i2 = LogBoxDialog.f18855b;
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    return (WindowInsetsCompat) iVar.invoke(p0, p1);
                }
            });
        }
    }
}
