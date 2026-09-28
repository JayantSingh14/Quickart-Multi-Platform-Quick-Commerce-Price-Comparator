package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.profileinstaller.DeviceProfileWriter;
import com.brentvatne.react.VideoManagerModule;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.modules.toast.ToastModule;
import in.juspay.hyperqr.QrBridge;
import java.io.Serializable;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Name;
import org.xbill.DNS.Zone;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f191a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f192b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f193c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f194d;

    public /* synthetic */ g(Object obj, int i2, Object obj2, int i3) {
        this.f191a = i3;
        this.f192b = obj;
        this.f193c = i2;
        this.f194d = obj2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.media3.exoplayer.drm.DrmSessionEventListener, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f193c;
        Object obj = this.f192b;
        ?? r3 = this.f194d;
        switch (this.f191a) {
            case 0:
                ComponentActivity$activityResultRegistry$1 this$0 = (ComponentActivity$activityResultRegistry$1) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a(i2, ((ActivityResultContract.SynchronousResult) r3).f230a);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1 this$02 = (ComponentActivity$activityResultRegistry$1) obj;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                IntentSender.SendIntentException e2 = (IntentSender.SendIntentException) r3;
                Intrinsics.checkNotNullParameter(e2, "$e");
                this$02.b(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e2));
                break;
            case 2:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) obj;
                int i3 = eventDispatcher.f6924a;
                r3.getClass();
                r3.G(i3, eventDispatcher.f6925b, i2);
                break;
            case 3:
                ((DeviceProfileWriter) obj).f11291c.a(i2, (Serializable) r3);
                break;
            case 4:
                VideoManagerModule.performOnPlayerView$lambda$0((VideoManagerModule) obj, i2, (Function1) r3);
                break;
            case 5:
                WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
                ((HeadlessJsTaskContext) obj).c((HeadlessJsTaskConfig) r3, i2);
                break;
            case 6:
                ToastModule.show$lambda$0((ToastModule) obj, (String) r3, i2);
                break;
            case 7:
                QrBridge.openQRScanner$lambda$5((QrBridge) obj, i2, (String) r3);
                break;
            default:
                ((Zone) obj).lambda$removeRRset$4((Name) r3, i2);
                break;
        }
    }

    public /* synthetic */ g(Object obj, Object obj2, int i2, int i3) {
        this.f191a = i3;
        this.f192b = obj;
        this.f194d = obj2;
        this.f193c = i2;
    }
}
