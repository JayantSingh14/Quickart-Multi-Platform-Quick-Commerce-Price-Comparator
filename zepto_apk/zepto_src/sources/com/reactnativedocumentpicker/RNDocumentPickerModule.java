package com.reactnativedocumentpicker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.reactnativedocumentpicker.IsKnownTypeImpl;
import com.truecaller.android.sdk.common.TrueException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class RNDocumentPickerModule extends NativeDocumentPickerSpec implements LifecycleEventListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String E_INVALID_DATA_RETURNED = "INVALID_DATA_RETURNED";

    @NotNull
    private static final String E_OTHER_PRESENTING_ERROR = "OTHER_PRESENTING_ERROR";
    private static final int PICK_DIR_REQUEST_CODE = 42;
    private static final int PICK_FILES_REQUEST_CODE = 41;

    @NotNull
    private static final String PRESENTER_IS_NULL = "NULL_PRESENTER";
    private static final int SAVE_DOC_REQUEST_CODE = 43;

    @NotNull
    private static final String UNABLE_TO_OPEN_FILE_TYPE = "UNABLE_TO_OPEN_FILE_TYPE";

    @NotNull
    private final ActivityEventListener activityEventListener;

    @Nullable
    private PickOptions currentPickOptions;

    @Nullable
    private Uri currentUriOfFileBeingExported;

    @NotNull
    private final CoroutineScope fileCopyingCoroutine;

    @NotNull
    private final FileOperations fileOps;

    @NotNull
    private final MetadataGetter metadataGetter;

    @NotNull
    private final Map<String, Uri> pickedFilesUriMap;

    @NotNull
    private final PromiseWrapper promiseWrapper;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$keepLocalCopy$1", f = "RNDocumentPickerModule.kt", l = {188}, m = "invokeSuspend")
    /* renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$keepLocalCopy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f46381a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReadableArray f46383c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f46384d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Promise f46385e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReadableArray readableArray, String str, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.f46383c = readableArray;
            this.f46384d = str;
            this.f46385e = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RNDocumentPickerModule.this.new AnonymousClass1(this.f46383c, this.f46384d, this.f46385e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CopyDestination copyDestination;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f46381a;
            if (i2 == 0) {
                ResultKt.b(obj);
                RNDocumentPickerModule rNDocumentPickerModule = RNDocumentPickerModule.this;
                FileOperations fileOperations = rNDocumentPickerModule.fileOps;
                ReactApplicationContext reactApplicationContext = rNDocumentPickerModule.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                CopyDestination.f46325b.getClass();
                String path = this.f46384d;
                Intrinsics.checkNotNullParameter(path, "path");
                CopyDestination[] copyDestinationArrValues = CopyDestination.values();
                int length = copyDestinationArrValues.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        copyDestination = null;
                        break;
                    }
                    copyDestination = copyDestinationArrValues[i3];
                    if (copyDestination.f46330a.equals(path)) {
                        break;
                    }
                    i3++;
                }
                if (copyDestination == null) {
                    copyDestination = CopyDestination.f46326c;
                }
                this.f46381a = 1;
                obj = fileOperations.b(reactApplicationContext, this.f46383c, copyDestination, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.f46385e.resolve((ReadableArray) obj);
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$processFilePickerResult$1", f = "RNDocumentPickerModule.kt", l = {322}, m = "invokeSuspend")
    /* renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$processFilePickerResult$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f46386a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f46388c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00891(List list, Continuation continuation) {
            super(2, continuation);
            this.f46388c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RNDocumentPickerModule.this.new C00891(this.f46388c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00891) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f46386a;
            RNDocumentPickerModule rNDocumentPickerModule = RNDocumentPickerModule.this;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    PickOptions pickOptions = rNDocumentPickerModule.currentPickOptions;
                    if (pickOptions == null) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    MetadataGetter metadataGetter = rNDocumentPickerModule.metadataGetter;
                    ReactApplicationContext reactApplicationContext = rNDocumentPickerModule.getReactApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                    List list = this.f46388c;
                    this.f46386a = 1;
                    obj = metadataGetter.b(reactApplicationContext, list, pickOptions, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                rNDocumentPickerModule.promiseWrapper.b((ReadableArray) obj);
            } catch (Exception e2) {
                PromiseWrapper promiseWrapper = rNDocumentPickerModule.promiseWrapper;
                promiseWrapper.getClass();
                promiseWrapper.a(promiseWrapper.f46379b, e2.getLocalizedMessage() != null ? e2.getLocalizedMessage() : e2.getMessage() != null ? e2.getMessage() : "unknown error", e2);
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$writeDocuments$1", f = "RNDocumentPickerModule.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$writeDocuments$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f46389a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RNDocumentPickerModule f46390b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Promise f46391c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00901(ReadableMap readableMap, RNDocumentPickerModule rNDocumentPickerModule, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.f46389a = readableMap;
            this.f46390b = rNDocumentPickerModule;
            this.f46391c = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C00901(this.f46389a, this.f46390b, this.f46391c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00901) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Promise promise = this.f46391c;
            ReadableMap readableMap = this.f46389a;
            RNDocumentPickerModule rNDocumentPickerModule = this.f46390b;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            try {
                String string = readableMap.hasKey("uri") ? readableMap.getString("uri") : null;
                FileOperations fileOperations = rNDocumentPickerModule.fileOps;
                Uri uri = rNDocumentPickerModule.currentUriOfFileBeingExported;
                ReactApplicationContext reactApplicationContext = rNDocumentPickerModule.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentMetadataBuilder documentMetadataBuilderC = fileOperations.c(uri, string, reactApplicationContext);
                MetadataGetter metadataGetter = rNDocumentPickerModule.metadataGetter;
                ContentResolver contentResolver = rNDocumentPickerModule.getReactApplicationContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
                metadataGetter.getClass();
                MetadataGetter.c(contentResolver, documentMetadataBuilderC, false);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                writableArrayCreateArray.pushMap(documentMetadataBuilderC.a());
                promise.resolve(writableArrayCreateArray);
            } catch (Exception e2) {
                promise.reject(e2);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNDocumentPickerModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.promiseWrapper = new PromiseWrapper();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.pickedFilesUriMap = linkedHashMap;
        this.metadataGetter = new MetadataGetter(linkedHashMap);
        this.fileOps = new FileOperations(linkedHashMap);
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        this.fileCopyingCoroutine = CoroutineScopeKt.a(DefaultIoScheduler.f55150b);
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() { // from class: com.reactnativedocumentpicker.RNDocumentPickerModule$activityEventListener$1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (i2 == 41 || i2 == 42 || i2 == 43) {
                    RNDocumentPickerModule rNDocumentPickerModule = this.f46380a;
                    if (i3 != -1) {
                        if (i3 == 0) {
                            rNDocumentPickerModule.promiseWrapper.a("OPERATION_CANCELED", "user canceled the document picker", null);
                            return;
                        }
                        rNDocumentPickerModule.promiseWrapper.a("UNEXPECTED_ACTIVITY_RESULT", "Unknown activity result: " + i3, null);
                        return;
                    }
                    if (intent == null) {
                        rNDocumentPickerModule.promiseWrapper.a("INVALID_DATA_RETURNED", "Data from document picker is null", null);
                        return;
                    }
                    switch (i2) {
                        case 41:
                            rNDocumentPickerModule.processFilePickerResult(intent);
                            break;
                        case 42:
                            rNDocumentPickerModule.processDirectoryPickerResult(intent);
                            break;
                        case 43:
                            rNDocumentPickerModule.processSaveAsResult(intent);
                            break;
                        default:
                            rNDocumentPickerModule.promiseWrapper.a("UNEXPECTED_ACTIVITY_RESULT", "Unknown activity result: " + i3, null);
                            break;
                    }
                }
            }
        };
        this.activityEventListener = baseActivityEventListener;
        reactContext.addActivityEventListener(baseActivityEventListener);
        reactContext.addLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public final void processDirectoryPickerResult(Intent intent) {
        Uri data = intent.getData();
        PickOptions pickOptions = this.currentPickOptions;
        if (data == null || pickOptions == null) {
            this.promiseWrapper.a(E_INVALID_DATA_RETURNED, "Data from document picker is null", null);
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", data.toString());
        if (pickOptions.f46376f) {
            try {
                getReactApplicationContext().getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 3);
                String string = data.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String strEncodeToString = Base64.encodeToString(bytes, 0);
                writableMapCreateMap.putString("bookmarkStatus", APayConstants.SUCCESS);
                writableMapCreateMap.putString("bookmark", strEncodeToString);
            } catch (Exception e2) {
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null && (localizedMessage = e2.getMessage()) == null) {
                    localizedMessage = "Unknown error with takePersistableUriPermission";
                }
                writableMapCreateMap.putString("bookmarkStatus", "error");
                writableMapCreateMap.putString("bookmarkError", localizedMessage);
            }
        }
        this.promiseWrapper.b(writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSaveAsResult(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            this.promiseWrapper.a(E_INVALID_DATA_RETURNED, "Data from document picker is null", null);
            return;
        }
        this.pickedFilesUriMap.put(data.toString(), data);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", data.toString());
        this.promiseWrapper.b(writableMapCreateMap);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().removeActivityEventListener(this.activityEventListener);
        super.invalidate();
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @NotNull
    public WritableMap isKnownType(@NotNull String kind, @NotNull String value) {
        boolean z;
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.b(kind, "mimeType")) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(value);
            z = extensionFromMimeType != null;
            if (extensionFromMimeType == null) {
                value = null;
            }
            return IsKnownTypeImpl.Companion.a(extensionFromMimeType, value, z);
        }
        if (!Intrinsics.b(kind, "extension")) {
            return IsKnownTypeImpl.Companion.a(null, null, false);
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(value);
        z = mimeTypeFromExtension != null;
        if (mimeTypeFromExtension == null) {
            value = null;
        }
        return IsKnownTypeImpl.Companion.a(value, mimeTypeFromExtension, z);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void keepLocalCopy(@NotNull ReadableMap options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ReadableArray array = options.getArray("files");
        String string = options.getString("destination");
        if (string != null && array != null) {
            BuildersKt.c(this.fileCopyingCoroutine, null, new AnonymousClass1(array, string, promise, null), 3);
            return;
        }
        promise.reject("keepLocalCopy", "You did not provide the correct options. Expected 'files' and 'destination', got: " + options.toHashMap().keySet());
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        CoroutineScopeKt.b(this.fileCopyingCoroutine, ExceptionsKt.a("host destroyed", null));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void pick(@NotNull ReadableMap opts, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(opts, "opts");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Companion.getClass();
            Intrinsics.checkNotNullParameter(promise, "promise");
            promise.reject(PRESENTER_IS_NULL, PRESENTER_IS_NULL);
        } else if (this.promiseWrapper.c(promise, "pick")) {
            PickOptions pickOptionsA = PickOptionsKt.a(opts);
            this.currentPickOptions = pickOptionsA;
            try {
                currentActivity.startActivityForResult(IntentFactory.a(pickOptionsA), 41);
            } catch (ActivityNotFoundException e2) {
                promise.reject(UNABLE_TO_OPEN_FILE_TYPE, e2);
            } catch (Exception e3) {
                promise.reject(E_OTHER_PRESENTING_ERROR, e3);
            }
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void pickDirectory(@NotNull ReadableMap opts, @NotNull Promise promise) {
        String str;
        Intrinsics.checkNotNullParameter(opts, "opts");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Companion.getClass();
            Intrinsics.checkNotNullParameter(promise, "promise");
            promise.reject(PRESENTER_IS_NULL, PRESENTER_IS_NULL);
            return;
        }
        if (this.promiseWrapper.c(promise, "pickDirectory")) {
            PickOptions pickOptionsA = PickOptionsKt.a(opts);
            this.currentPickOptions = pickOptionsA;
            try {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                if (Build.VERSION.SDK_INT >= 26 && (str = pickOptionsA.f46373c) != null) {
                    intent.putExtra("android.provider.extra.INITIAL_URI", str);
                }
                currentActivity.startActivityForResult(intent, 42);
            } catch (ActivityNotFoundException e2) {
                promise.reject(UNABLE_TO_OPEN_FILE_TYPE, e2);
            } catch (Exception e3) {
                promise.reject(E_OTHER_PRESENTING_ERROR, e3);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    public final void processFilePickerResult(@NotNull Intent intent) {
        ?? H;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Uri data = intent.getData();
        ClipData clipData = intent.getClipData();
        if (clipData == null || clipData.getItemCount() <= 0) {
            H = data != null ? CollectionsKt.H(data) : EmptyList.f53609a;
        } else {
            IntRange intRangeF = RangesKt.f(0, clipData.getItemCount());
            H = new ArrayList(CollectionsKt.r(intRangeF, 10));
            Iterator<Integer> it = intRangeF.iterator();
            while (((IntProgressionIterator) it).f53843c) {
                H.add(clipData.getItemAt(((IntIterator) it).a()).getUri());
            }
        }
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        BuildersKt.c(CoroutineScopeKt.a(DefaultIoScheduler.f55150b), null, new C00891(H, null), 3);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void releaseLongTermAccess(@NotNull ReadableArray uris, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        int size = uris.size();
        for (int i2 = 0; i2 < size; i2++) {
            String string = uris.getString(i2);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("uri", string);
            try {
                contentResolver.releasePersistableUriPermission(Uri.parse(string), 3);
                writableMapCreateMap.putString(CLConstants.OTP_STATUS, APayConstants.SUCCESS);
            } catch (Exception e2) {
                writableMapCreateMap.putString(CLConstants.OTP_STATUS, "error");
                String message = e2.getMessage();
                if (message == null) {
                    message = TrueException.TYPE_UNKNOWN_MESSAGE;
                }
                writableMapCreateMap.putString("errorMessage", message);
            }
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        promise.resolve(writableArrayCreateArray);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void releaseSecureAccess(@NotNull ReadableArray uris, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void saveDocument(@NotNull ReadableMap options, @NotNull Promise promise) {
        String type;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Companion.getClass();
            Intrinsics.checkNotNullParameter(promise, "promise");
            promise.reject(PRESENTER_IS_NULL, PRESENTER_IS_NULL);
            return;
        }
        if (this.promiseWrapper.c(promise, "saveDocuments")) {
            try {
                ReadableArray array = options.getArray("sourceUris");
                Intrinsics.c(array);
                Uri uri = Uri.parse(array.getString(0));
                this.currentUriOfFileBeingExported = uri;
                if (options.hasKey("mimeType")) {
                    type = options.getString("mimeType");
                } else {
                    type = getReactApplicationContext().getContentResolver().getType(uri);
                    if (type == null) {
                        throw new IllegalStateException("MIME type could not be determined from the URI");
                    }
                }
                String string = options.hasKey("fileName") ? options.getString("fileName") : null;
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(type);
                if (string != null) {
                    intent.putExtra("android.intent.extra.TITLE", string);
                }
                if (Build.VERSION.SDK_INT >= 26 && options.hasKey("initialUri")) {
                    intent.putExtra("android.provider.extra.INITIAL_URI", options.getString("initialUri"));
                }
                currentActivity.startActivityForResult(intent, 43);
            } catch (ActivityNotFoundException e2) {
                promise.reject(UNABLE_TO_OPEN_FILE_TYPE, e2);
            } catch (Exception e3) {
                promise.reject(E_OTHER_PRESENTING_ERROR, e3);
            }
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void writeDocuments(@NotNull ReadableMap options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt.c(this.fileCopyingCoroutine, null, new C00901(options, this, promise, null), 3);
    }
}
