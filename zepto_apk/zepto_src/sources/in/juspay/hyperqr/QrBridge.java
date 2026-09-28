package in.juspay.hyperqr;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.google.mlkit.vision.common.InputImage;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.FragmentHooks;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.ResultAwaitingDuiHook;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.BinaryBitmap;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.MultiFormatReader;
import in.juspay.widget.qrscanner.com.google.zxing.RGBLuminanceSource;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.common.HybridBinarizer;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.QRCodeWriter;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeResult;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.CaptureManager;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.DecoratedBarcodeView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class QrBridge extends HyperBridge {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String GALLERY = "GALLERY";
    private static final int GALLERY_KITKAT_INTENT_CALLED = 118;

    @NotNull
    private static final String LOG_TAG = "QRBridge";

    @NotNull
    public static final String REQUEST_PERMISSION_PREFIX = "ReqPermi";
    private static final int SELECT_PHOTO = 117;

    @NotNull
    public static final String SHARE_IMAGE = "SHARE_IMAGE";
    private static final int SHARE_IMAGE_INTENT_CALLED = 119;

    @Nullable
    private DecoratedBarcodeView barcodeView;

    @Nullable
    private CaptureManager captureManager;

    @Nullable
    private CameraStreamScanner firebaseScanner;

    @Nullable
    private InputImageScanner imageScanner;
    private boolean isFlashOn;

    @NotNull
    private final Map<String, Object> listenerMap;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrBridge(@NotNull BridgeComponents bridgeComponents) {
        super(bridgeComponents);
        Intrinsics.checkNotNullParameter(bridgeComponents, "bridgeComponents");
        this.listenerMap = new HashMap();
    }

    private final Bitmap addLogoToQrCode(Bitmap bitmap, Bitmap bitmap2, JSONObject jSONObject) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(qrBitmap.wi… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        int width = bitmap.getWidth();
        int iOptInt = jSONObject.optInt("centerImagePercent", 0);
        if (iOptInt > 30) {
            iOptInt = 30;
        }
        int iOptInt2 = jSONObject.optInt("centerImageHorizontalPercent", 0);
        int i2 = iOptInt2 <= 30 ? iOptInt2 : 30;
        if (i2 <= 0) {
            i2 = iOptInt;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, (i2 * width) / 100, (width * iOptInt) / 100, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(logoB…Width, logoHeight, false)");
        float width2 = (bitmap.getWidth() - bitmapCreateScaledBitmap.getWidth()) / 2.0f;
        float height = (bitmap.getHeight() - bitmapCreateScaledBitmap.getHeight()) / 2.0f;
        float fOptInt = jSONObject.optInt("imagePadding", 0);
        Paint paint = new Paint();
        paint.setColor(-1);
        canvas.drawRect(width2 - fOptInt, height - fOptInt, bitmapCreateScaledBitmap.getWidth() + width2 + fOptInt, bitmapCreateScaledBitmap.getHeight() + height + fOptInt, paint);
        canvas.drawBitmap(bitmapCreateScaledBitmap, width2, height, (Paint) null);
        return bitmapCreateBitmap;
    }

    private final boolean checkFirebaseScanner() throws ClassNotFoundException {
        try {
            Class.forName("androidx.camera.core.CameraSelector");
            Class.forName("androidx.camera.core.ImageAnalysis");
            Class.forName("androidx.camera.core.ImageCapture");
            Class.forName("androidx.camera.core.ImageProxy");
            Class.forName("androidx.camera.core.Preview");
            Class.forName("androidx.camera.lifecycle.ProcessCameraProvider");
            Class.forName("androidx.camera.view.PreviewView");
            Class.forName("com.google.mlkit.vision.barcode.BarcodeScannerOptions");
            Class.forName("com.google.mlkit.vision.barcode.BarcodeScanning");
            Class.forName("com.google.mlkit.vision.barcode.common.Barcode");
            Class.forName("com.google.mlkit.vision.common.InputImage");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[Catch: Exception -> 0x003a, TRY_ENTER, TryCatch #1 {Exception -> 0x003a, blocks: (B:8:0x002d, B:11:0x0034, B:18:0x004f, B:21:0x0056, B:30:0x00a7), top: B:48:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7 A[Catch: Exception -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003a, blocks: (B:8:0x002d, B:11:0x0034, B:18:0x004f, B:21:0x0056, B:30:0x00a7), top: B:48:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void generateCustomQRCode$lambda$11(java.lang.String r9, in.juspay.hyperqr.QrBridge r10, java.lang.String r11, int r12, java.lang.String r13, int r14, java.lang.String r15) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hyperqr.QrBridge.generateCustomQRCode$lambda$11(java.lang.String, in.juspay.hyperqr.QrBridge, java.lang.String, int, java.lang.String, int, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateCustomQRCode$lambda$11$lambda$10(ImageView view, Bitmap bitmap, QrBridge this$0, String str) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setImageBitmap(bitmap);
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, MerchantConstants.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateQRCode$lambda$9(ImageView view, int i2, int i3, BitMatrix bitMatrix, QrBridge this$0, String str) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(bitMatrix, "$bitMatrix");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setImageBitmap(QrHelper.getBitMapFromBitMatrix(i2, i3, -16777216, bitMatrix));
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, MerchantConstants.SUCCESS);
    }

    private final ErrorCorrectionLevel getErrorCorrectionLevel(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != 72) {
            if (iHashCode != 81) {
                if (iHashCode != 76) {
                    if (iHashCode == 77 && str.equals("M")) {
                        return ErrorCorrectionLevel.M;
                    }
                } else if (str.equals("L")) {
                    return ErrorCorrectionLevel.L;
                }
            } else if (str.equals("Q")) {
                return ErrorCorrectionLevel.Q;
            }
        } else if (str.equals("H")) {
            return ErrorCorrectionLevel.H;
        }
        return ErrorCorrectionLevel.L;
    }

    private final Bitmap getLogoBitmap(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
                }
            } catch (Exception e2) {
                getBridgeComponents().getTrackerInterface().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while fetching custom logo", e2);
            }
        }
        return null;
    }

    private final boolean isPermissionGranted() {
        return ContextCompat.a(getBridgeComponents().getContext(), "android.permission.CAMERA") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String makeFailureData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", "true");
        jSONObject.put("data", str);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String makeSuccessData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", "false");
        jSONObject.put("data", str);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
        return string;
    }

    private final void onNullParam(String str, String str2) {
        JuspayLogger.d(LOG_TAG, "'" + str + "' is null, returning.");
        CallbackInvoker callbackInvoker = getBridgeComponents().getCallbackInvoker();
        byte[] bytes = android.support.v4.media.b.D("'", str, "' NOT PROVIDED").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String str3 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        callbackInvoker.invokeCallbackInDUIWebview(str2, str3);
    }

    private final void openQRScanner(String str, String str2) throws NumberFormatException {
        if (getBridgeComponents().getActivity() == null || TextUtils.isEmpty(str)) {
            JuspayLogger.e(LOG_TAG, "ERROR: Frame ID null!");
            return;
        }
        int i2 = Integer.parseInt(str);
        JuspayLogger.d(LOG_TAG, "Opening QR Scanner inside Frame with ID :" + i2);
        ExecutorManager.runOnMainThread(new androidx.activity.g(this, i2, str2, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRScanner$lambda$5(final QrBridge this$0, int i2, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getBridgeComponents().getActivity();
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(i2);
        if (viewGroup == null) {
            JuspayLogger.e(LOG_TAG, "Couldn't find view for frameId: " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, this$0.makeFailureData("bad_view_id"));
            return;
        }
        if (this$0.checkFirebaseScanner()) {
            JuspayLogger.d(LOG_TAG, "Using Firebase Scanner");
            Context context = this$0.getBridgeComponents().getContext();
            ComponentCallbacks2 activity2 = this$0.getBridgeComponents().getActivity();
            Intrinsics.d(activity2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            CameraStreamScanner cameraStreamScanner = new CameraStreamScanner(viewGroup, (LifecycleOwner) activity2, context, new Function1<String, Unit>() { // from class: in.juspay.hyperqr.QrBridge$openQRScanner$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.f53572a;
                }

                public final void invoke(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, this.this$0.makeSuccessData(it));
                }
            });
            this$0.firebaseScanner = cameraStreamScanner;
            cameraStreamScanner.scanWithCamera();
            return;
        }
        JuspayLogger.d(LOG_TAG, "Using Zxing Scanner");
        this$0.barcodeView = new DecoratedBarcodeView(this$0.getBridgeComponents().getActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        DecoratedBarcodeView decoratedBarcodeView = this$0.barcodeView;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setLayoutParams(layoutParams);
        }
        viewGroup.addView(this$0.barcodeView);
        CaptureManager captureManager = new CaptureManager(activity, this$0.barcodeView);
        this$0.captureManager = captureManager;
        captureManager.setBarcodeCallBack(new BarcodeCallback() { // from class: in.juspay.hyperqr.QrBridge$openQRScanner$1$2
            @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback
            public void barcodeResult(@NotNull BarcodeResult barcodeResult) {
                Intrinsics.checkNotNullParameter(barcodeResult, "barcodeResult");
                try {
                    JuspayLogger.d("QRBridge", "Scanned QR Result: " + barcodeResult);
                    CallbackInvoker callbackInvoker = this.this$0.getBridgeComponents().getCallbackInvoker();
                    String str2 = str;
                    QrBridge qrBridge = this.this$0;
                    String string = barcodeResult.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "barcodeResult.toString()");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    String strEncodeToString = Base64.encodeToString(bytes, 2);
                    Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(\n        …                        )");
                    callbackInvoker.invokeCallbackInDUIWebview(str2, qrBridge.makeSuccessData(strEncodeToString));
                } catch (Exception unused) {
                    CallbackInvoker callbackInvoker2 = this.this$0.getBridgeComponents().getCallbackInvoker();
                    String str3 = str;
                    byte[] bytes2 = "unknown_error".getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    String str4 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes2, 2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                    callbackInvoker2.invokeCallbackInDUIWebview(str3, str4);
                }
            }

            @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback
            public void possibleResultPoints(@NotNull List<? extends ResultPoint> list) {
                Intrinsics.checkNotNullParameter(list, "list");
            }
        });
        CaptureManager captureManager2 = this$0.captureManager;
        if (captureManager2 != null) {
            captureManager2.onResume();
        }
        CaptureManager captureManager3 = this$0.captureManager;
        if (captureManager3 != null) {
            captureManager3.decode();
        }
    }

    private final void readQRFromBitmap(Bitmap bitmap, String str) throws UnsupportedEncodingException {
        try {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr)));
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            DecodeHintType decodeHintType = DecodeHintType.TRY_HARDER;
            Boolean bool = Boolean.TRUE;
            String text = multiFormatReader.decode(binaryBitmap, MapsKt.h(new Pair(decodeHintType, bool), new Pair(DecodeHintType.ALSO_INVERTED, bool))).getText();
            JuspayLogger.d(LOG_TAG, "Scanned QR Result: " + text);
            CallbackInvoker callbackInvoker = getBridgeComponents().getCallbackInvoker();
            String strEncode = URLEncoder.encode(text, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(barcode, \"UTF-8\")");
            callbackInvoker.invokeCallbackInDUIWebview(str, makeSuccessData(StringsKt.K(strEncode, "+", "%20")));
        } catch (Exception e2) {
            CallbackInvoker callbackInvoker2 = getBridgeComponents().getCallbackInvoker();
            byte[] bytes = ("unknown_error::" + e2).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str2 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            callbackInvoker2.invokeCallbackInDUIWebview(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean scanQRFromGallery$lambda$1(final QrBridge this$0, final String str, int i2, int i3, Intent intent) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
        } catch (Exception e2) {
            JuspayLogger.d(LOG_TAG, "Exception in scanning the QR code :" + e2);
            return false;
        }
        if (intent == null) {
            CallbackInvoker callbackInvoker = this$0.getBridgeComponents().getCallbackInvoker();
            byte[] bytes = "NO IMAGE SELECTED".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str2 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            callbackInvoker.invokeCallbackInDUIWebview(str, str2);
            return false;
        }
        if (GALLERY_KITKAT_INTENT_CALLED != i2 && 117 != i2) {
            return false;
        }
        if (this$0.checkFirebaseScanner()) {
            try {
                Uri data = intent.getData();
                if (data != null) {
                    InputImage inputImageFromFilePath = InputImage.fromFilePath(this$0.getBridgeComponents().getContext(), data);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromFilePath, "fromFilePath(bridgeComponents.context, uri)");
                    InputImageScanner inputImageScanner = new InputImageScanner(new Function1<String, Unit>() { // from class: in.juspay.hyperqr.QrBridge$scanQRFromGallery$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.f53572a;
                        }

                        public final void invoke(@NotNull String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, this.this$0.makeSuccessData(it));
                        }
                    }, new Function1<String, Unit>() { // from class: in.juspay.hyperqr.QrBridge$scanQRFromGallery$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.f53572a;
                        }

                        public final void invoke(@NotNull String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, this.this$0.makeFailureData(it));
                        }
                    });
                    this$0.imageScanner = inputImageScanner;
                    inputImageScanner.scanImage(inputImageFromFilePath);
                } else {
                    this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str, this$0.makeFailureData("Selected image uri is null"));
                }
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        InputStream inputStreamOpenInputStream = null;
        try {
            Uri data2 = intent.getData();
            if (data2 != null) {
                inputStreamOpenInputStream = this$0.getBridgeComponents().getContext().getContentResolver().openInputStream(data2);
            }
        } catch (FileNotFoundException e4) {
            JuspayLogger.d(LOG_TAG, "Exception in scanning the QR code :" + e4);
        }
        Bitmap bMap = BitmapFactory.decodeStream(new BufferedInputStream(inputStreamOpenInputStream));
        Intrinsics.checkNotNullExpressionValue(bMap, "bMap");
        this$0.readQRFromBitmap(bMap, str);
        this$0.listenerMap.remove(GALLERY);
        return true;
        JuspayLogger.d(LOG_TAG, "Exception in scanning the QR code :" + e2);
        return false;
    }

    private final Bitmap screenShot(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap != null) {
            view.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Bitmap.createBitmap(width, height, config) must not be null");
        Intrinsics.f(illegalStateException, Intrinsics.class.getName());
        throw illegalStateException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shareImage$lambda$4(File imageFile, QrBridge this$0, int i2, int i3, Intent intent) {
        Intrinsics.checkNotNullParameter(imageFile, "$imageFile");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i2 != 119) {
            return false;
        }
        try {
            try {
                if (imageFile.exists()) {
                    imageFile.delete();
                }
            } catch (Exception e2) {
                JuspayLogger.d(LOG_TAG, "Failed to delete cached image: " + e2.getMessage());
            }
            return true;
        } finally {
            this$0.listenerMap.remove(SHARE_IMAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startQRScanner$lambda$6(QrBridge this$0, String str, String str2, Message it) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.isPermissionGranted()) {
            this$0.openQRScanner(str, str2);
            return false;
        }
        CallbackInvoker callbackInvoker = this$0.getBridgeComponents().getCallbackInvoker();
        byte[] bytes = "permission_denied".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String str3 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        callbackInvoker.invokeCallbackInDUIWebview(str2, str3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopScanning$lambda$8(QrBridge this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CameraStreamScanner cameraStreamScanner = this$0.firebaseScanner;
        if (cameraStreamScanner != null) {
            cameraStreamScanner.releaseCameraResources();
        }
        CaptureManager captureManager = this$0.captureManager;
        if (captureManager != null) {
            captureManager.onPause();
            captureManager.onDestroy();
            this$0.captureManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleFlash$lambda$12(QrBridge this$0, String callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (this$0.isFlashOn) {
            this$0.isFlashOn = false;
            DecoratedBarcodeView decoratedBarcodeView = this$0.barcodeView;
            if (decoratedBarcodeView != null) {
                decoratedBarcodeView.setTorchOff();
            }
        } else {
            this$0.isFlashOn = true;
            DecoratedBarcodeView decoratedBarcodeView2 = this$0.barcodeView;
            if (decoratedBarcodeView2 != null) {
                decoratedBarcodeView2.setTorchOn();
            }
        }
        this$0.getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"status\":" + this$0.isFlashOn + '}');
    }

    @JavascriptInterface
    public final boolean checkQRScannerLibrary() {
        try {
            BarcodeFormat barcodeFormat = BarcodeFormat.AZTEC;
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            int i2 = DecoratedBarcodeView.f49014e;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public final void generateCustomQRCode(@Nullable final String str, @Nullable final String str2, final int i2, final int i3, @Nullable final String str3, @Nullable final String str4) {
        if (str == null) {
            onNullParam("data", str4);
        } else if (str2 == null) {
            onNullParam("parent", str4);
        } else {
            System.out.println("selvam: reach1");
            ExecutorManager.runOnBackgroundThread(new Runnable() { // from class: in.juspay.hyperqr.h
                @Override // java.lang.Runnable
                public final void run() throws JSONException, NumberFormatException {
                    QrBridge.generateCustomQRCode$lambda$11(str2, this, str3, i3, str, i2, str4);
                }
            });
        }
    }

    @JavascriptInterface
    public final void generateQRCode(@Nullable String str, @Nullable String str2, int i2, int i3, @Nullable String str3) throws NumberFormatException {
        final String str4;
        final BitMatrix bitMatrixEncode;
        final int width;
        final int height;
        if (str == null) {
            onNullParam("data", str3);
            return;
        }
        if (str2 == null) {
            onNullParam("parent", str3);
            return;
        }
        try {
            int i4 = Integer.parseInt(str2);
            Activity activity = getBridgeComponents().getActivity();
            if (activity == null) {
                return;
            }
            View viewFindViewById = activity.findViewById(i4);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "activity.findViewById(id)");
            final ImageView imageView = (ImageView) viewFindViewById;
            try {
                bitMatrixEncode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i2, i2, MapsKt.g(new Pair(EncodeHintType.MARGIN, Integer.valueOf(i3))));
                Intrinsics.checkNotNullExpressionValue(bitMatrixEncode, "writer.encode(data, Barc… qrSize, qrSize, hintMap)");
                width = bitMatrixEncode.getWidth();
                height = bitMatrixEncode.getHeight();
                str4 = str3;
            } catch (Exception e2) {
                e = e2;
                str4 = str3;
            }
            try {
                ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hyperqr.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QrBridge qrBridge = this;
                        QrBridge.generateQRCode$lambda$9(imageView, width, height, bitMatrixEncode, qrBridge, str4);
                    }
                });
            } catch (Exception e3) {
                e = e3;
                getBridgeComponents().getTrackerInterface().trackAndLogException(LOG_TAG, "action", "system", Labels.System.JBRIDGE, "Exception while generating QR Code", e);
                getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str4, "FAILURE");
            }
        } catch (Exception e4) {
            e = e4;
            str4 = str3;
        }
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public boolean onActivityResult(int i2, int i3, @Nullable Intent intent) {
        for (Object obj : this.listenerMap.values()) {
            if ((obj instanceof ResultAwaitingDuiHook) && ((ResultAwaitingDuiHook) obj).onActivityResult(i2, i3, intent)) {
                getBridgeComponents().getTrackerInterface().trackAction("system", "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Result consumed by ResultAwaitingDuiHook ".concat(obj.getClass().getName()));
                return true;
            }
        }
        return false;
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public boolean onRequestPermissionResult(int i2, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Object obj = this.listenerMap.get("ReqPermi" + i2);
        if (!(obj instanceof Handler.Callback)) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = grantResults;
        ((Handler.Callback) obj).handleMessage(messageObtain);
        return true;
    }

    @Override // in.juspay.hyper.bridge.HyperBridge
    public void reset() {
        this.listenerMap.clear();
    }

    @JavascriptInterface
    public final void saveImage(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3) throws JSONException {
        Activity activity = getBridgeComponents().getActivity();
        if (activity == null) {
            return;
        }
        try {
            View viewFindViewById = activity.findViewById(i2);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "activity.findViewById(viewId)");
            String strInsertImage = MediaStore.Images.Media.insertImage(getBridgeComponents().getContext().getContentResolver(), screenShot(viewFindViewById), str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", "false");
            jSONObject.put("data", strInsertImage);
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(str3, jSONObject.toString());
        } catch (Exception e2) {
            JuspayLogger.d(LOG_TAG, "Exception in download qr :" + e2);
            CallbackInvoker callbackInvoker = getBridgeComponents().getCallbackInvoker();
            byte[] bytes = ("unknown_error::" + e2).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String str4 = String.format("{\"error\":\"true\",\"data\":\"%s\"}", Arrays.copyOf(new Object[]{Base64.encodeToString(bytes, 2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
            callbackInvoker.invokeCallbackInDUIWebview(str3, str4);
        }
    }

    @JavascriptInterface
    public final void scanQRFromGallery(@Nullable String str) {
        this.listenerMap.put(GALLERY, new e(this, str));
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        getBridgeComponents().getFragmentHooks().startActivityForResult(intent, GALLERY_KITKAT_INTENT_CALLED, null);
    }

    @JavascriptInterface
    public final void shareImage(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3) throws IOException {
        Activity activity = getBridgeComponents().getActivity();
        if (activity == null) {
            return;
        }
        try {
            View viewFindViewById = activity.findViewById(i2);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "activity.findViewById(viewId)");
            Bitmap bitmapScreenShot = screenShot(viewFindViewById);
            File file = new File(activity.getCacheDir(), (str3 == null ? "shared_image" : str3).concat(".jpg"));
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmapScreenShot.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                Uri uriD = FileProvider.d(activity, activity.getPackageName() + ".fileprovider", file);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/jpeg");
                intent.putExtra("android.intent.extra.STREAM", uriD);
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra("android.intent.extra.SUBJECT", str);
                intent.setClipData(ClipData.newUri(activity.getContentResolver(), str3 == null ? "ShareImage" : str3, uriD));
                intent.addFlags(1);
                FragmentHooks fragmentHooks = getBridgeComponents().getFragmentHooks();
                Intent intentCreateChooser = Intent.createChooser(intent, str3);
                Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(shareIntent, intentHeading)");
                fragmentHooks.startActivityForResult(intentCreateChooser, 119, null);
                this.listenerMap.put(SHARE_IMAGE, new e(file, this));
            } finally {
            }
        } catch (Exception e2) {
            JuspayLogger.d(LOG_TAG, "Error sharing image: " + e2.getMessage());
        }
    }

    @JavascriptInterface
    public final void startQRScanner(@Nullable final String str, @Nullable final String str2) throws NumberFormatException {
        if (str == null) {
            onNullParam("parentId", str2);
        } else if (isPermissionGranted()) {
            openQRScanner(str, str2);
        } else {
            getBridgeComponents().getFragmentHooks().requestPermission(new String[]{"android.permission.CAMERA"}, 101);
            this.listenerMap.put("ReqPermi101", new Handler.Callback() { // from class: in.juspay.hyperqr.f
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return QrBridge.startQRScanner$lambda$6(this.f48498a, str, str2, message);
                }
            });
        }
    }

    @JavascriptInterface
    public final void stopScanning() {
        InputImageScanner inputImageScanner = this.imageScanner;
        if (inputImageScanner != null) {
            inputImageScanner.releaseResources();
        }
        ExecutorManager.runOnMainThread(new a(this, 1));
    }

    @JavascriptInterface
    public final void toggleFlash(@NotNull String callback) {
        CameraStreamScanner cameraStreamScanner;
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if (this.barcodeView != null) {
                ExecutorManager.runOnMainThread(new in.juspay.hypernfc.b(2, this, callback));
                return;
            }
            if (!checkFirebaseScanner() || (cameraStreamScanner = this.firebaseScanner) == null) {
                return;
            }
            this.isFlashOn = cameraStreamScanner.toggleFlashlight();
            getBridgeComponents().getCallbackInvoker().invokeCallbackInDUIWebview(callback, "{\"status\":" + this.isFlashOn + '}');
        } catch (Exception e2) {
            JuspayLogger.d(LOG_TAG, "Exception in toggle flash: " + e2);
        }
    }
}
