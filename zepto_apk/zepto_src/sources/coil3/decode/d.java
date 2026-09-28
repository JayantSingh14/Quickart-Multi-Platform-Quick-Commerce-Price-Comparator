package coil3.decode;

import android.content.res.AssetFileDescriptor;
import com.google.firebase.messaging.FirebaseMessaging;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13866a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13867b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f13866a = i2;
        this.f13867b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f13866a) {
            case 0:
                return StaticImageDecoderKt.toImageDecoderSourceOrNull$lambda$0((AssetFileDescriptor) this.f13867b);
            default:
                return ReactNativeFirebaseMessagingModule.lambda$getToken$6((FirebaseMessaging) this.f13867b);
        }
    }
}
