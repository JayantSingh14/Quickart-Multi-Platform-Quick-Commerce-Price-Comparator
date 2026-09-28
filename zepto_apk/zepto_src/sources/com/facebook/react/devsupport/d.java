package com.facebook.react.devsupport;

import android.widget.TextView;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18925a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18926b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18927c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f18928d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f18929e;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ d(DevSupportManagerBase devSupportManagerBase, String str, StackFrame[] stackFrameArr, ErrorType errorType) {
        this.f18927c = devSupportManagerBase;
        this.f18926b = str;
        this.f18928d = stackFrameArr;
        this.f18929e = errorType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Integer num;
        switch (this.f18925a) {
            case 0:
                String str2 = this.f18926b;
                DevSupportManagerBase devSupportManagerBase = (DevSupportManagerBase) this.f18927c;
                devSupportManagerBase.u = str2;
                devSupportManagerBase.v = (StackFrame[]) this.f18928d;
                if (devSupportManagerBase.f18829l == null) {
                    RedBoxDialogSurfaceDelegate redBoxDialogSurfaceDelegate = new RedBoxDialogSurfaceDelegate(devSupportManagerBase);
                    devSupportManagerBase.f18829l = redBoxDialogSurfaceDelegate;
                    redBoxDialogSurfaceDelegate.e(NativeRedBoxSpec.NAME);
                }
                if (!devSupportManagerBase.f18829l.b()) {
                    devSupportManagerBase.f18829l.a();
                    break;
                }
                break;
            default:
                if (((Integer) this.f18927c) == null || (num = (Integer) this.f18928d) == null || num.intValue() <= 0) {
                    str = "";
                } else {
                    str = String.format(Locale.getDefault(), " %.1f%%", Arrays.copyOf(new Object[]{Float.valueOf((r0.intValue() / num.intValue()) * 100)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                }
                TextView textView = ((DefaultDevLoadingViewImplementation) this.f18929e).f18792b;
                if (textView != null) {
                    String str3 = this.f18926b;
                    if (str3 == null) {
                        str3 = "Loading";
                    }
                    textView.setText(str3 + str + "…");
                    break;
                }
                break;
        }
    }

    public /* synthetic */ d(Integer num, Integer num2, DefaultDevLoadingViewImplementation defaultDevLoadingViewImplementation, String str) {
        this.f18927c = num;
        this.f18928d = num2;
        this.f18929e = defaultDevLoadingViewImplementation;
        this.f18926b = str;
    }
}
