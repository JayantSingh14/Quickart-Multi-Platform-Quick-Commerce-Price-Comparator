package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;

/* loaded from: classes3.dex */
class PausedInDebuggerOverlayDialogManager implements PausedInDebuggerOverlayManager {

    /* renamed from: a, reason: collision with root package name */
    public final c f18864a;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f18865b;

    public PausedInDebuggerOverlayDialogManager(c cVar) {
        this.f18864a = cVar;
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public final void a(final String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.l
            @Override // java.lang.Runnable
            public final void run() {
                PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager = this.f18947a;
                Dialog dialog = pausedInDebuggerOverlayDialogManager.f18865b;
                if (dialog != null) {
                    dialog.dismiss();
                }
                Activity activityA = pausedInDebuggerOverlayDialogManager.f18864a.f18924a.f18823f.a();
                if (activityA == null || activityA.isFinishing()) {
                    activityA = null;
                }
                if (activityA == null) {
                    return;
                }
                View viewInflate = LayoutInflater.from(activityA).inflate(R.layout.paused_in_debugger_view, (ViewGroup) null);
                View viewFindViewById = viewInflate.findViewById(R.id.button);
                Assertions.c(viewFindViewById);
                final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener2 = pausedInDebuggerOverlayCommandListener;
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        pausedInDebuggerOverlayCommandListener2.onResume();
                    }
                });
                TextView textView = (TextView) viewInflate.findViewById(R.id.button_text);
                Assertions.c(textView);
                textView.setText(str);
                Dialog dialog2 = new Dialog(activityA, R.style.NoAnimationDialog);
                pausedInDebuggerOverlayDialogManager.f18865b = dialog2;
                dialog2.setContentView(viewInflate);
                pausedInDebuggerOverlayDialogManager.f18865b.setCancelable(false);
                Window window = pausedInDebuggerOverlayDialogManager.f18865b.getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.2f;
                    window.setAttributes(attributes);
                    window.addFlags(2);
                    window.setGravity(48);
                    window.setElevation(0.0f);
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.setBackgroundDrawableResource(R.drawable.paused_in_debugger_background);
                }
                pausedInDebuggerOverlayDialogManager.f18865b.show();
            }
        });
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public final void b() {
        UiThreadUtil.runOnUiThread(new m(this, 0));
    }
}
