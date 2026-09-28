package in.juspay.hyperupi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Base64;
import android.util.Log;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hypersdk.core.r0;
import in.juspay.hyperupi.CLUtils;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;
import org.npci.upi.security.services.CLServices;
import org.npci.upi.security.services.ServiceConnectionStatusNotifier;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class CLUtils {

    @NotNull
    private static final String CL_UTILS = "cl_utils";
    private static boolean isServiceConnected;

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static CLServices npciClServices;

    @NotNull
    private final BridgeComponents bridgeComponents;

    @NotNull
    private final Context context;
    private boolean lock;

    @Nullable
    private CLServices orgNpciCLService;
    private int position;

    @Nullable
    private Provider provider;

    @Nullable
    private String random;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Object IO_LOCK = new Object();

    @NotNull
    private static final Queue<CLTask> clTaskQueue = new LinkedList();
    private static final String LOG_TAG = "CLUtils";

    @Metadata
    public interface CLTask {

        @Metadata
        public static final class DefaultImpls {
            public static boolean getRunOnMainThread(@NotNull CLTask cLTask) {
                return false;
            }
        }

        boolean getRunOnMainThread();

        @Nullable
        String runOnInit();
    }

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final byte[] aesEncrypt(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable String str) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(str, 2));
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "instance.doFinal(array)");
            return bArrDoFinal;
        }

        private Companion() {
        }
    }

    @Metadata
    /* renamed from: in.juspay.hyperupi.CLUtils$handleInit$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ServiceConnectionStatusNotifier {
        final /* synthetic */ CLTask $clTask;
        final /* synthetic */ boolean $triggerCallback;

        public AnonymousClass1(boolean z, CLTask cLTask) {
            this.$triggerCallback = z;
            this.$clTask = cLTask;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void serviceConnected$lambda$1(CLUtils this$0, boolean z, CLServices cLServices, CLTask clTask) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(clTask, "$clTask");
            this$0.findAndRemoveProvider();
            synchronized (CLUtils.IO_LOCK) {
                try {
                    if (this$0.setCLInstance(cLServices)) {
                        this$0.executeAndSendCLCallback(clTask, z, true);
                    } else {
                        this$0.executeAndSendCLCallback(clTask, z, false);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            while (CLUtils.clTaskQueue.peek() != null) {
                CLTask cLTask = (CLTask) CLUtils.clTaskQueue.poll();
                if (cLTask != null) {
                    this$0.executeAndSendCLCallback(cLTask, z, true);
                }
            }
        }

        @Override // org.npci.upi.security.services.ServiceConnectionStatusNotifier
        public void serviceConnected(@Nullable final CLServices cLServices) {
            CLUtils.this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "SERVICE_CONNECTED", "true");
            CLUtils.isServiceConnected = true;
            final CLUtils cLUtils = CLUtils.this;
            final boolean z = this.$triggerCallback;
            final CLTask cLTask = this.$clTask;
            ExecutorManager.runOnBackgroundThread(new Runnable() { // from class: in.juspay.hyperupi.f
                @Override // java.lang.Runnable
                public final void run() {
                    CLUtils.AnonymousClass1.serviceConnected$lambda$1(cLUtils, z, cLServices, cLTask);
                }
            });
        }

        @Override // org.npci.upi.security.services.ServiceConnectionStatusNotifier
        public void serviceDisconnected() {
            CLUtils.this.addProviderBack();
            CLUtils.this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "SERVICE_CONNECTED", "false");
            Log.e("Error Code : 843", "Description : NPCI Service Disconnected");
        }
    }

    public CLUtils(@NotNull BridgeComponents bridgeComponents) {
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.bridgeComponents = bridgeComponents;
        this.context = bridgeComponents.getContext();
        this.lock = true;
        this.position = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addProviderBack() {
        int i2 = this.position;
        if (i2 != -1) {
            Security.insertProviderAt(this.provider, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeAndSendCLCallback(final CLTask cLTask, final boolean z, final boolean z2) {
        if (cLTask.getRunOnMainThread()) {
            final int i2 = 0;
            ExecutorManager.runOnMainThread(new Runnable(this) { // from class: in.juspay.hyperupi.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CLUtils f48785b;

                {
                    this.f48785b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            CLUtils.executeAndSendCLCallback$lambda$0(this.f48785b, cLTask, z, z2);
                            break;
                        default:
                            CLUtils.executeAndSendCLCallback$lambda$1(this.f48785b, cLTask, z, z2);
                            break;
                    }
                }
            });
        } else {
            final int i3 = 1;
            ExecutorManager.runOnBackgroundThread(new Runnable(this) { // from class: in.juspay.hyperupi.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CLUtils f48785b;

                {
                    this.f48785b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i3) {
                        case 0:
                            CLUtils.executeAndSendCLCallback$lambda$0(this.f48785b, cLTask, z, z2);
                            break;
                        default:
                            CLUtils.executeAndSendCLCallback$lambda$1(this.f48785b, cLTask, z, z2);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAndSendCLCallback$lambda$0(CLUtils this$0, CLTask clTask, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clTask, "$clTask");
        this$0.sendCLCallback(clTask, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAndSendCLCallback$lambda$1(CLUtils this$0, CLTask clTask, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clTask, "$clTask");
        this$0.sendCLCallback(clTask, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findAndRemoveProvider() {
        if (this.provider == null) {
            Provider[] providers = Security.getProviders();
            Intrinsics.checkNotNullExpressionValue(providers, "getProviders()");
            int length = providers.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (Intrinsics.b(providers[i2].getName(), "SC")) {
                    this.position = i2;
                    break;
                }
                i2++;
            }
        }
        if (this.position != -1) {
            this.provider = Security.getProvider("SC");
            Security.removeProvider("SC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CLServices getCLInstance() {
        CLServices cLServices = npciClServices;
        if (cLServices != null) {
            return cLServices;
        }
        if (this.orgNpciCLService != null) {
            this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "Get CL Service Instance From Member", "null");
            return this.orgNpciCLService;
        }
        try {
            CLServices clServicesInstance = CLServices.getClServicesInstance();
            if (clServicesInstance != null) {
                return clServicesInstance;
            }
            this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "Get CL Service Instance", "null");
            return null;
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, CL_UTILS, "Exception in getCLInstance : getClServicesInstance function not found", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCallbackString(String str) {
        if (str != null) {
            return android.support.v4.media.b.D("window.callUICallback(\"", str, "\")");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCallbackStringWithResult(String str, String str2) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return android.support.v4.media.b.m("window.callUICallback(\"", str, "\", \"", Base64.encodeToString(bytes, 2), "\");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChallenge$lambda$6(final CLUtils this$0, final String str, final String str2, final String str3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$getChallenge$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str4 = str;
                final String str5 = str2;
                final String str6 = str3;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str4, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$getChallenge$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) throws JSONException {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        String challenge = performAction.getChallenge(str5, str6);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", str5);
                            jSONObject.put(CLConstants.SALT_FIELD_DEVICE_ID, str6);
                            jSONObject.put("challenge", challenge);
                        } catch (JSONException e2) {
                            TrackerInterface trackerInterface = cLUtils2.bridgeComponents.getTrackerInterface();
                            String LOG_TAG2 = CLUtils.LOG_TAG;
                            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in getChallenge", e2);
                        }
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "CHALLENGE", jSONObject);
                        Intrinsics.checkNotNullExpressionValue(challenge, "challenge");
                        return challenge;
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCredentials$lambda$15(final CLUtils this$0, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final CLRemoteResultReceiver remoteResultReceiver) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(remoteResultReceiver, "$remoteResultReceiver");
        this$0.handleInit(false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$getCredentials$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return true;
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                final String str10 = str;
                final CLUtils cLUtils2 = this.this$0;
                final String str11 = str2;
                final String str12 = str3;
                final String str13 = str4;
                final String str14 = str5;
                final String str15 = str6;
                final String str16 = str7;
                final String str17 = str8;
                final String str18 = str9;
                final CLRemoteResultReceiver cLRemoteResultReceiver = remoteResultReceiver;
                return CLUtils.performAction$default(cLUtils, cLInstance, str10, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$getCredentials$1$1$runOnInit$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        JsCallback jsCallback;
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "NPCI_CL", "OPENED");
                        try {
                            performAction.getCredential(str11, str12, str13, str14, str15, str16, str17, str18, cLRemoteResultReceiver);
                            return "";
                        } catch (Exception e2) {
                            TrackerInterface trackerInterface = cLUtils2.bridgeComponents.getTrackerInterface();
                            String LOG_TAG2 = CLUtils.LOG_TAG;
                            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in getCredentials", e2);
                            String callbackString = cLUtils2.getCallbackString(str10);
                            if (callbackString == null || (jsCallback = cLUtils2.bridgeComponents.getJsCallback()) == null) {
                                return "";
                            }
                            jsCallback.addJsToWebView(callbackString);
                            return "";
                        }
                    }
                }, 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUPILiteBalance$lambda$13(final CLUtils this$0, final String str, final String str2, final String str3, final String str4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$getUPILiteBalance$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str5 = str;
                final String str6 = str2;
                final String str7 = str3;
                final String str8 = str4;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str5, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$getUPILiteBalance$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        String balance = performAction.getUPILiteBalance(str6, str7, str8);
                        TrackerInterface trackerInterface = cLUtils2.bridgeComponents.getTrackerInterface();
                        Intrinsics.checkNotNullExpressionValue(balance, "balance");
                        trackerInterface.trackAction("system", "debug", Labels.System.UTIL, "LITE_BALANCE", balance);
                        return balance;
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    private final void handleInit(final boolean z, final CLTask cLTask) {
        try {
            CLServices.initService(this.context, new AnonymousClass1(z, cLTask));
        } catch (Exception e2) {
            this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "SERVICE_INITIATED", "true");
            Log.e("NPCICL", "handleInit Exception", e2);
            if (!"Service already initiated".equals(e2.getMessage())) {
                Log.e("NPCICL", "intialiseNPCICL", e2);
                executeAndSendCLCallback(cLTask, z, false);
            } else {
                if (isServiceConnected && getCLInstance() != null) {
                    executeAndSendCLCallback(cLTask, z, true);
                    return;
                }
                clTaskQueue.add(cLTask);
                final Runnable runnable = new Runnable() { // from class: in.juspay.hyperupi.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        CLUtils.handleInit$lambda$4(this.f48774a, cLTask, z);
                    }
                };
                new Timer().schedule(new TimerTask() { // from class: in.juspay.hyperupi.CLUtils.handleInit.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                }, 10000L);
            }
        }
    }

    public static /* synthetic */ void handleInit$default(CLUtils cLUtils, boolean z, CLTask cLTask, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        cLUtils.handleInit(z, cLTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleInit$lambda$4(CLUtils this$0, CLTask clTask, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clTask, "$clTask");
        synchronized (IO_LOCK) {
            try {
                if (this$0.lock) {
                    clTaskQueue.clear();
                    this$0.executeAndSendCLCallback(clTask, z, false);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isUpiLiteBound$lambda$9(final CLUtils this$0, final String str, final String str2, final String str3, final String str4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$isUpiLiteBound$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str5 = str;
                final String str6 = str2;
                final String str7 = str3;
                final String str8 = str4;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str5, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$isUpiLiteBound$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        String upiLiteBoundFlag = performAction.isUpiLiteBound(str6, str7, str8);
                        TrackerInterface trackerInterface = cLUtils2.bridgeComponents.getTrackerInterface();
                        Intrinsics.checkNotNullExpressionValue(upiLiteBoundFlag, "upiLiteBoundFlag");
                        trackerInterface.trackAction("system", "debug", Labels.System.UTIL, "UPI_BOUND", upiLiteBoundFlag);
                        return upiLiteBoundFlag;
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isUpiLiteSupported$lambda$8(final CLUtils this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$isUpiLiteSupported$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                try {
                    CLUtils cLUtils = this.this$0;
                    CLServices cLInstance = cLUtils.getCLInstance();
                    String str2 = str;
                    final CLUtils cLUtils2 = this.this$0;
                    return CLUtils.performAction$default(cLUtils, cLInstance, str2, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$isUpiLiteSupported$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final String invoke(@NotNull CLServices performAction) {
                            Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                            boolean zIsUpiLiteSupported = performAction.isUpiLiteSupported();
                            cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "UPI_SUPPORTED", Boolean.valueOf(zIsUpiLiteSupported));
                            return String.valueOf(zIsUpiLiteSupported);
                        }
                    }, 2, null);
                } catch (Exception e2) {
                    TrackerInterface trackerInterface = this.this$0.bridgeComponents.getTrackerInterface();
                    String LOG_TAG2 = CLUtils.LOG_TAG;
                    Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                    trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in isUpiLiteSupported", e2);
                    return this.this$0.getCallbackStringWithResult(str, "false");
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String performAction(CLServices cLServices, String str, Function1<? super String, String> function1, Function1<? super CLServices, String> function12) {
        String str2;
        return (cLServices == null || (str2 = (String) function1.invoke((String) function12.invoke(cLServices))) == null) ? getCallbackString(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String performAction$default(CLUtils cLUtils, CLServices cLServices, final String str, Function1 function1, Function1 function12, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1<String, String>() { // from class: in.juspay.hyperupi.CLUtils.performAction.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final String invoke(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return CLUtils.this.getCallbackStringWithResult(str, it);
                }
            };
        }
        return cLUtils.performAction(cLServices, str, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerApp$lambda$7(final CLUtils this$0, final String str, final String str2, final String str3, final String str4, final String str5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$registerApp$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str6 = str;
                final String str7 = str2;
                final String str8 = str3;
                final String str9 = str4;
                final String str10 = str5;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str6, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$registerApp$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) throws JSONException {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        boolean zRegisterApp = performAction.registerApp(str7, str8, str9, str10, cLUtils2.random);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appName", str7);
                            jSONObject.put("mobileNumber", str8);
                            jSONObject.put(CLConstants.SALT_FIELD_DEVICE_ID, str9);
                            jSONObject.put("hmac", str10);
                            jSONObject.put(CLConstants.CRED_SUB_TYPE_MANDATE_REGISTER, zRegisterApp);
                        } catch (JSONException e2) {
                            TrackerInterface trackerInterface = cLUtils2.bridgeComponents.getTrackerInterface();
                            String LOG_TAG2 = CLUtils.LOG_TAG;
                            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in registerApp", e2);
                        }
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "REGISTER_APP", jSONObject);
                        return String.valueOf(zRegisterApp);
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerUPILiteOnboarding$lambda$11(final CLUtils this$0, final String str, final String str2, final String str3, final String str4, final String str5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$registerUPILiteOnboarding$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str6 = str;
                final String str7 = str2;
                final String str8 = str3;
                final String str9 = str4;
                final String str10 = str5;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str6, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$registerUPILiteOnboarding$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        boolean zRegisterUPILiteOnboarding = performAction.registerUPILiteOnboarding(str7, str8, str9, str10);
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "LITE_ONBOARDING", Boolean.valueOf(zRegisterUPILiteOnboarding));
                        return String.valueOf(zRegisterUPILiteOnboarding);
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerUPILiteState$lambda$12(final CLUtils this$0, final String str, final String str2, final String str3, final String str4, final String str5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$registerUPILiteState$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str6 = str;
                final String str7 = str2;
                final String str8 = str3;
                final String str9 = str4;
                final String str10 = str5;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str6, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$registerUPILiteState$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        boolean zRegisterUPILiteState = performAction.registerUPILiteState(str7, str8, str9, str10);
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "LITE_STATE", Boolean.valueOf(zRegisterUPILiteState));
                        return String.valueOf(zRegisterUPILiteState);
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    private final void sendCLCallback(CLTask cLTask, boolean z, boolean z2) {
        JsCallback jsCallback;
        String strRunOnInit = cLTask.runOnInit();
        addProviderBack();
        if ((!z && z2) || strRunOnInit == null || (jsCallback = this.bridgeComponents.getJsCallback()) == null) {
            return;
        }
        jsCallback.addJsToWebView(strRunOnInit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setCLInstance(CLServices cLServices) {
        if (!validateIfCLInstanceIsNull(cLServices)) {
            return true;
        }
        try {
            if (!validateIfCLInstanceIsNull(CLServices.getClServicesInstance())) {
                return true;
            }
            CLServices cLServices2 = this.orgNpciCLService;
            if (cLServices2 == null) {
                return false;
            }
            Intrinsics.d(cLServices2, "null cannot be cast to non-null type org.npci.upi.security.services.CLServices");
            npciClServices = cLServices2;
            return true;
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, CL_UTILS, "Exception in setCLInstance : getClServicesInstance function not found", e2);
            return true;
        }
    }

    private final JSONArray toJSONArray(Object obj) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            jSONArray.put(wrap(Array.get(obj, i2)));
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unBindDevice$lambda$10(final CLUtils this$0, final String str, final String str2, final String str3, final String str4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$unBindDevice$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                String str5 = str;
                final String str6 = str2;
                final String str7 = str3;
                final String str8 = str4;
                final CLUtils cLUtils2 = this.this$0;
                return CLUtils.performAction$default(cLUtils, cLInstance, str5, null, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$unBindDevice$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        boolean zUnBindDevice = performAction.unBindDevice(str6, str7, str8);
                        cLUtils2.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "UPI_LITE_BOUND", Boolean.valueOf(zUnBindDevice));
                        return String.valueOf(zUnBindDevice);
                    }
                }, 2, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unbindNPCICL$lambda$14(final CLUtils this$0, final String callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        handleInit$default(this$0, false, new CLTask() { // from class: in.juspay.hyperupi.CLUtils$unbindNPCICL$1$1
            @Override // in.juspay.hyperupi.CLUtils.CLTask
            public boolean getRunOnMainThread() {
                return CLUtils.CLTask.DefaultImpls.getRunOnMainThread(this);
            }

            @Override // in.juspay.hyperupi.CLUtils.CLTask
            @Nullable
            public final String runOnInit() {
                CLUtils cLUtils = this.this$0;
                CLServices cLInstance = cLUtils.getCLInstance();
                final String str = callback;
                final CLUtils cLUtils2 = this.this$0;
                return cLUtils.performAction(cLInstance, str, new Function1<String, String>() { // from class: in.juspay.hyperupi.CLUtils$unbindNPCICL$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final String invoke(@NotNull String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return cLUtils2.getCallbackString(str);
                    }
                }, new Function1<CLServices, String>() { // from class: in.juspay.hyperupi.CLUtils$unbindNPCICL$1$1.2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final String invoke(@NotNull CLServices performAction) {
                        Intrinsics.checkNotNullParameter(performAction, "$this$performAction");
                        performAction.unbindService();
                        return "";
                    }
                });
            }
        }, 1, null);
    }

    private final boolean validateIfCLInstanceIsNull(CLServices cLServices) {
        this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "Set CL Service Instance", "true");
        if (cLServices == null) {
            this.bridgeComponents.getTrackerInterface().trackAction("system", "debug", Labels.System.UTIL, "Set CL Service Instance", "null");
            return true;
        }
        this.orgNpciCLService = cLServices;
        npciClServices = cLServices;
        this.lock = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object wrap(Object obj) {
        Package r0;
        String name;
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, CL_UTILS, "Exception in wrap", e2);
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj);
        }
        if (obj.getClass().isArray()) {
            return toJSONArray(obj);
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
            return obj;
        }
        if (obj.getClass().getPackage() != null && (r0 = obj.getClass().getPackage()) != null && (name = r0.getName()) != null && StringsKt.O(name, "java.", false)) {
            return obj.toString();
        }
        return null;
    }

    @NotNull
    public final String decodeNPCIXmlKeys(@Nullable String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(nPCIXmlKeys, Base64.NO_WRAP)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @NotNull
    public final String generateRandom() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        String randomStr = Base64.encodeToString(bArr, 2);
        this.random = randomStr;
        Intrinsics.checkNotNullExpressionValue(randomStr, "randomStr");
        return randomStr;
    }

    @Nullable
    public final String generateTrustCred(@Nullable String str, @Nullable String str2) {
        try {
            byte[] bArrDecode = Base64.decode(str2, 2);
            Companion companion = Companion;
            if (str == null) {
                str = "null";
            }
            return Base64.encodeToString(companion.aesEncrypt(sha256(str, this.random), bArrDecode, this.random), 2);
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, CL_UTILS, "Exception in generateTrustCred", e2);
            return null;
        }
    }

    public final void getChallenge(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        ExecutorManager.runOnBackgroundThread(new androidx.media3.exoplayer.source.h(this, str3, str, str2, 10));
    }

    @NotNull
    public final String getClVersion() {
        return "1.8";
    }

    public final void getCredentials(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable final String str9) {
        final Handler handler = new Handler();
        ExecutorManager.runOnMainThread(new r0(this, str9, str, str2, str3, str4, str5, str6, str7, str8, new CLRemoteResultReceiver(new ResultReceiver(handler) { // from class: in.juspay.hyperupi.CLUtils$getCredentials$remoteResultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i2, @Nullable Bundle bundle) throws JSONException {
                JsCallback jsCallback;
                super.onReceiveResult(i2, bundle);
                TrackerInterface trackerInterface = this.this$0.bridgeComponents.getTrackerInterface();
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append(' ');
                sb.append(bundle);
                sb.append('}');
                trackerInterface.trackAction("system", "debug", Labels.System.UTIL, "GET_CREDENTIALS_RESP", sb.toString());
                if (bundle != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str10 : bundle.keySet()) {
                        try {
                            jSONObject.put(str10, this.this$0.wrap(bundle.get(str10)));
                        } catch (JSONException e2) {
                            TrackerInterface trackerInterface2 = this.this$0.bridgeComponents.getTrackerInterface();
                            String LOG_TAG2 = CLUtils.LOG_TAG;
                            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
                            trackerInterface2.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in getCredentials", e2);
                        }
                    }
                    try {
                        jSONObject.put("resultCode", i2);
                    } catch (Exception e3) {
                        TrackerInterface trackerInterface3 = this.this$0.bridgeComponents.getTrackerInterface();
                        String LOG_TAG3 = CLUtils.LOG_TAG;
                        Intrinsics.checkNotNullExpressionValue(LOG_TAG3, "LOG_TAG");
                        trackerInterface3.trackAndLogException(LOG_TAG3, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "cl_utils", "Exception in getCredentials", e3);
                    }
                    CLUtils cLUtils = this.this$0;
                    String str11 = str9;
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
                    String callbackStringWithResult = cLUtils.getCallbackStringWithResult(str11, string);
                    if (callbackStringWithResult == null || (jsCallback = this.this$0.bridgeComponents.getJsCallback()) == null) {
                        return;
                    }
                    jsCallback.addJsToWebView(callbackStringWithResult);
                }
            }
        })));
    }

    public final int getPosition() {
        return this.position;
    }

    public final void getUPILiteBalance(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        ExecutorManager.runOnBackgroundThread(new a(this, str4, str, str2, str3, 1));
    }

    public final void isUpiLiteBound(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        ExecutorManager.runOnBackgroundThread(new a(this, str4, str, str2, str3, 2));
    }

    public final void isUpiLiteSupported(@Nullable String str) {
        ExecutorManager.runOnBackgroundThread(new b(this, str, 1));
    }

    @Nullable
    public final String populateHMAC(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        try {
            return Base64.encodeToString(Companion.aesEncrypt(sha256(str + '|' + str2 + '|' + str4, this.random), Base64.decode(str3, 2), this.random), 2);
        } catch (Exception e2) {
            TrackerInterface trackerInterface = this.bridgeComponents.getTrackerInterface();
            String LOG_TAG2 = LOG_TAG;
            Intrinsics.checkNotNullExpressionValue(LOG_TAG2, "LOG_TAG");
            trackerInterface.trackAndLogException(LOG_TAG2, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, CL_UTILS, "Exception in populateHMAC", e2);
            return null;
        }
    }

    public final void registerApp(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        ExecutorManager.runOnBackgroundThread(new d(this, str5, str, str2, str3, str4, 2));
    }

    public final void registerUPILiteOnboarding(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        ExecutorManager.runOnBackgroundThread(new d(this, str5, str, str2, str3, str4, 0));
    }

    public final void registerUPILiteState(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        ExecutorManager.runOnBackgroundThread(new d(this, str5, str, str2, str3, str4, 1));
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    @NotNull
    public final byte[] sha256(@NotNull String paramString, @Nullable String str) throws Exception {
        Intrinsics.checkNotNullParameter(paramString, "paramString");
        byte[] bArrDecode = Base64.decode(str, 2);
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        messageDigest.update(bArrDecode);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = paramString.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "md.digest(paramString.to…(StandardCharsets.UTF_8))");
        return bArrDigest;
    }

    public final void unBindDevice(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        ExecutorManager.runOnBackgroundThread(new a(this, str4, str, str2, str3, 0));
    }

    public final void unbindNPCICL(@NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ExecutorManager.runOnBackgroundThread(new b(this, callback, 0));
    }
}
