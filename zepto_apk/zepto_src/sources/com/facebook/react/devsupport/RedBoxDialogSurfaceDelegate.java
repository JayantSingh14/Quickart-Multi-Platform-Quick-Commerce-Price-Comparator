package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.RedBoxContentView;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.util.Objects;

/* loaded from: classes3.dex */
class RedBoxDialogSurfaceDelegate implements SurfaceDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final DoubleTapReloadRecognizer f18887a = new DoubleTapReloadRecognizer();

    /* renamed from: b, reason: collision with root package name */
    public final DevSupportManager f18888b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f18889c;

    /* renamed from: d, reason: collision with root package name */
    public RedBoxContentView f18890d;

    /* renamed from: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate$1, reason: invalid class name */
    class AnonymousClass1 extends Dialog {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f18891b = 0;

        public AnonymousClass1(Activity activity, int i2) {
            super(activity, i2);
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle bundle) {
            Objects.requireNonNull(getWindow());
            getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
            ViewCompat.H(RedBoxDialogSurfaceDelegate.this.f18890d, new o());
        }

        @Override // android.app.Dialog, android.view.KeyEvent.Callback
        public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
            RedBoxDialogSurfaceDelegate redBoxDialogSurfaceDelegate = RedBoxDialogSurfaceDelegate.this;
            if (i2 == 82) {
                redBoxDialogSurfaceDelegate.f18888b.A();
                return true;
            }
            if (redBoxDialogSurfaceDelegate.f18887a.a(i2, getCurrentFocus())) {
                redBoxDialogSurfaceDelegate.f18888b.w();
            }
            return super.onKeyUp(i2, keyEvent);
        }
    }

    public RedBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        this.f18888b = devSupportManager;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void a() {
        DevSupportManager devSupportManager = this.f18888b;
        String strE = devSupportManager.e();
        Activity activityV = devSupportManager.v();
        if (activityV == null || activityV.isFinishing()) {
            final ReactContext reactContextU = devSupportManager.u();
            if (reactContextU != null) {
                final m mVar = new m(this, 1);
                reactContextU.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.facebook.react.devsupport.RedBoxDialogSurfaceDelegate.2
                    @Override // com.facebook.react.bridge.LifecycleEventListener
                    public final void onHostDestroy() {
                    }

                    @Override // com.facebook.react.bridge.LifecycleEventListener
                    public final void onHostPause() {
                    }

                    @Override // com.facebook.react.bridge.LifecycleEventListener
                    public final void onHostResume() {
                        mVar.run();
                        reactContextU.removeLifecycleEventListener(this);
                    }
                });
                return;
            } else {
                if (strE == null) {
                    strE = "N/A";
                }
                FLog.g("ReactNative", "Unable to launch redbox because react activity and react context is not available, here is the error that redbox would've displayed: ".concat(strE));
                return;
            }
        }
        RedBoxContentView redBoxContentView = this.f18890d;
        if (redBoxContentView == null || redBoxContentView.getContext() != activityV) {
            e(NativeRedBoxSpec.NAME);
        }
        RedBoxContentView redBoxContentView2 = this.f18890d;
        String strE2 = redBoxContentView2.f18869b.e();
        StackFrame[] stackFrameArrT = redBoxContentView2.f18869b.t();
        redBoxContentView2.f18869b.getClass();
        Pair pairK = redBoxContentView2.f18869b.k(Pair.create(strE2, stackFrameArrT));
        redBoxContentView2.f18870c.setAdapter((ListAdapter) new RedBoxContentView.StackAdapter((String) pairK.first, (StackFrame[]) pairK.second));
        RedBoxHandler redBoxHandlerR = redBoxContentView2.f18869b.r();
        if (redBoxHandlerR != null) {
            redBoxHandlerR.b();
            RedBoxHandler redBoxHandler = redBoxContentView2.f18868a;
            if (redBoxHandler != null && redBoxHandler.a()) {
                redBoxContentView2.f18875h = false;
                TextView textView = redBoxContentView2.f18872e;
                Assertions.c(textView);
                textView.setVisibility(8);
                ProgressBar progressBar = redBoxContentView2.f18873f;
                Assertions.c(progressBar);
                progressBar.setVisibility(8);
                View view = redBoxContentView2.f18874g;
                Assertions.c(view);
                view.setVisibility(8);
                Button button = redBoxContentView2.f18871d;
                Assertions.c(button);
                button.setVisibility(0);
                Button button2 = redBoxContentView2.f18871d;
                Assertions.c(button2);
                button2.setEnabled(true);
            }
        }
        if (this.f18889c == null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(activityV, R.style.Theme_Catalyst_RedBox);
            this.f18889c = anonymousClass1;
            anonymousClass1.requestWindowFeature(1);
            this.f18889c.setContentView(this.f18890d);
        }
        this.f18889c.show();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final boolean b() {
        Dialog dialog = this.f18889c;
        return dialog != null && dialog.isShowing();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void c() {
        Dialog dialog = this.f18889c;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException e2) {
                FLog.h("ReactNative", "RedBoxDialogSurfaceDelegate: error while dismissing dialog: ", e2);
            }
            this.f18890d = null;
            this.f18889c = null;
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final boolean d() {
        return this.f18890d != null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void e(String str) {
        DevSupportManager devSupportManager = this.f18888b;
        RedBoxHandler redBoxHandlerR = devSupportManager.r();
        Activity activityV = devSupportManager.v();
        if (activityV == null || activityV.isFinishing()) {
            String strE = devSupportManager.e();
            if (strE == null) {
                strE = "N/A";
            }
            FLog.g("ReactNative", "Unable to launch redbox because react activity are not available, here is the error that redbox would've displayed: ".concat(strE));
            return;
        }
        final RedBoxContentView redBoxContentView = new RedBoxContentView(activityV);
        redBoxContentView.f18875h = false;
        redBoxContentView.f18876i = new RedBoxContentView.AnonymousClass1();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedBoxContentView redBoxContentView2 = RedBoxContentView.this;
                RedBoxHandler redBoxHandler = redBoxContentView2.f18868a;
                if (redBoxHandler == null || !redBoxHandler.a() || redBoxContentView2.f18875h) {
                    return;
                }
                redBoxContentView2.f18875h = true;
                TextView textView = redBoxContentView2.f18872e;
                Assertions.c(textView);
                textView.setText("Reporting...");
                TextView textView2 = redBoxContentView2.f18872e;
                Assertions.c(textView2);
                textView2.setVisibility(0);
                ProgressBar progressBar = redBoxContentView2.f18873f;
                Assertions.c(progressBar);
                progressBar.setVisibility(0);
                View view2 = redBoxContentView2.f18874g;
                Assertions.c(view2);
                view2.setVisibility(0);
                Button button = redBoxContentView2.f18871d;
                Assertions.c(button);
                button.setEnabled(false);
                Assertions.c(redBoxContentView2.f18869b.e());
                Assertions.c(redBoxContentView2.f18869b.t());
                redBoxContentView2.f18869b.m();
                RedBoxHandler redBoxHandler2 = redBoxContentView2.f18868a;
                view.getContext();
                Assertions.c(redBoxContentView2.f18876i);
                redBoxHandler2.c();
            }
        };
        redBoxContentView.f18877j = onClickListener;
        this.f18890d = redBoxContentView;
        redBoxContentView.f18869b = devSupportManager;
        redBoxContentView.f18868a = redBoxHandlerR;
        LayoutInflater.from(redBoxContentView.getContext()).inflate(R.layout.redbox_view, redBoxContentView);
        ListView listView = (ListView) redBoxContentView.findViewById(R.id.rn_redbox_stack);
        redBoxContentView.f18870c = listView;
        listView.setOnItemClickListener(redBoxContentView);
        ((Button) redBoxContentView.findViewById(R.id.rn_redbox_reload_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DevSupportManager devSupportManager2 = RedBoxContentView.this.f18869b;
                Assertions.c(devSupportManager2);
                devSupportManager2.w();
            }
        });
        ((Button) redBoxContentView.findViewById(R.id.rn_redbox_dismiss_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DevSupportManager devSupportManager2 = RedBoxContentView.this.f18869b;
                Assertions.c(devSupportManager2);
                devSupportManager2.j();
            }
        });
        RedBoxHandler redBoxHandler = redBoxContentView.f18868a;
        if (redBoxHandler == null || !redBoxHandler.a()) {
            return;
        }
        redBoxContentView.f18873f = (ProgressBar) redBoxContentView.findViewById(R.id.rn_redbox_loading_indicator);
        redBoxContentView.f18874g = redBoxContentView.findViewById(R.id.rn_redbox_line_separator);
        TextView textView = (TextView) redBoxContentView.findViewById(R.id.rn_redbox_report_label);
        redBoxContentView.f18872e = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        redBoxContentView.f18872e.setHighlightColor(0);
        Button button = (Button) redBoxContentView.findViewById(R.id.rn_redbox_report_button);
        redBoxContentView.f18871d = button;
        button.setOnClickListener(onClickListener);
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public final void f() {
        this.f18890d = null;
    }
}
