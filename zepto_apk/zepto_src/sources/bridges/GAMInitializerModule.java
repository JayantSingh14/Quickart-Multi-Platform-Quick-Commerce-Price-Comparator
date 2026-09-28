package bridges;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.client.zzex;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class GAMInitializerModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String MODULE_NAME = "GAMInitializerModule";

    @NotNull
    private final ReactApplicationContext reactContext;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[AdapterStatus.State.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Metadata
    @DebugMetadata(c = "bridges.GAMInitializerModule$initialize$1", f = "GAMInitializerModule.kt", l = {}, m = "invokeSuspend")
    /* renamed from: bridges.GAMInitializerModule$initialize$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f13215b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Promise f13216c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.f13215b = aVar;
            this.f13216c = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GAMInitializerModule.this.new AnonymousClass1(this.f13215b, this.f13216c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            try {
                zzex.d().e(GAMInitializerModule.this.reactContext, this.f13215b);
            } catch (Exception e2) {
                this.f13216c.reject(e2);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GAMInitializerModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(Promise promise, InitializationStatus initializationStatus) {
        Intrinsics.checkNotNullParameter(initializationStatus, "initializationStatus");
        AdapterStatus adapterStatus = (AdapterStatus) initializationStatus.a().get("com.google.android.gms.ads.MobileAds");
        if (adapterStatus == null) {
            promise.reject(new Error("GAM could not be initialized"));
            return;
        }
        int iOrdinal = adapterStatus.a().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            promise.resolve("INITIALIZED");
        } else {
            String description = adapterStatus.getDescription();
            Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
            promise.reject(new Error(description));
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public final void initialize(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AppCoroutineManager.a(new AnonymousClass1(new a(promise), promise, null));
    }
}
