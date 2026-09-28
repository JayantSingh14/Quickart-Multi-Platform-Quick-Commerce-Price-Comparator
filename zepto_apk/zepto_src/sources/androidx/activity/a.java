package androidx.activity;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f179a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f180b;

    public /* synthetic */ a(ComponentActivity componentActivity, int i2) {
        this.f179a = i2;
        this.f180b = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentActivity this$0 = this.f180b;
        switch (this.f179a) {
            case 0:
                int i2 = ComponentActivity.f122h;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.invalidateMenu();
                return;
            default:
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e2) {
                    if (!Intrinsics.b(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e2;
                    }
                    return;
                } catch (NullPointerException e3) {
                    if (!Intrinsics.b(e3.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e3;
                    }
                    return;
                }
        }
    }
}
