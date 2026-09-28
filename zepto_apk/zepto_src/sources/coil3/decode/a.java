package coil3.decode;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.PointF;
import coil3.decode.Decoder;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import com.chuckerteam.chucker.api.Chucker;
import com.chuckerteam.chucker.internal.support.NotificationHelper;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.zeptoconsumerapp.AutoLogin.SharedAuthenticatorService;
import com.zeptoconsumerapp.ShakeDetector.ShakeDetectorModule;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.time.AbstractLongTimeSource;
import okhttp3.Call;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13863b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f13862a = i2;
        this.f13863b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj = this.f13863b;
        switch (this.f13862a) {
            case 0:
                return BitmapFactoryDecoder.decode$lambda$1$lambda$0((BitmapFactoryDecoder) obj);
            case 1:
                return OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$4((Function0) obj);
            case 2:
                return OkHttpNetworkFetcher.asNetworkClient((Call.Factory) obj);
            case 3:
                return CollectionsKt.H((Pair) obj);
            case 4:
                return CollectionsKt.H((Decoder.Factory) obj);
            case 5:
                return ((Context) obj).getSharedPreferences("chucker_preferences", 0);
            case 6:
                Context context = ((NotificationHelper) obj).f16781a;
                return PendingIntent.getActivity(context, 1138, Chucker.a(context), 201326592);
            case 7:
                PointF pointF = GestureHandlerOrchestrator.f46732m;
                NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) obj;
                nativeViewGestureHandler.d();
                nativeViewGestureHandler.a(false);
                nativeViewGestureHandler.j();
                return Unit.f53572a;
            case 8:
                return SharedAuthenticatorService.authenticator_delegate$lambda$0((SharedAuthenticatorService) obj);
            case 9:
                return ShakeDetectorModule.register$lambda$0((ShakeDetectorModule) obj);
            case 10:
                return ((ArrayList) obj).iterator();
            case 11:
                return (Type) obj;
            default:
                return Long.valueOf(((AbstractLongTimeSource) obj).a());
        }
    }
}
