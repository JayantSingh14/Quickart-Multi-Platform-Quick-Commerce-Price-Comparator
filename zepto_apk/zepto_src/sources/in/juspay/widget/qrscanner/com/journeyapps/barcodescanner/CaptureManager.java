package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.client.android.R;
import in.juspay.widget.qrscanner.com.google.zxing.ResultMetadataType;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.InactivityTimer;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class CaptureManager {

    /* renamed from: l, reason: collision with root package name */
    private static final String f48996l = "CaptureManager";

    /* renamed from: m, reason: collision with root package name */
    private static int f48997m = 250;
    public static final /* synthetic */ int n = 0;

    /* renamed from: a, reason: collision with root package name */
    private Activity f48998a;

    /* renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f48999b;

    /* renamed from: e, reason: collision with root package name */
    private InactivityTimer f49002e;

    /* renamed from: f, reason: collision with root package name */
    private BeepManager f49003f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f49004g;

    /* renamed from: j, reason: collision with root package name */
    private final a.f f49007j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f49008k;

    /* renamed from: c, reason: collision with root package name */
    private int f49000c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f49001d = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f49005h = false;

    /* renamed from: i, reason: collision with root package name */
    private BarcodeCallback f49006i = null;

    public class a implements a.f {
        public a() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void b() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void d() {
            if (CaptureManager.this.f49005h) {
                Log.d(CaptureManager.f48996l, "Camera closed; finishing activity");
                CaptureManager.this.d();
            }
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a(Exception exc) {
            CaptureManager.this.c();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(CaptureManager.f48996l, "Finishing due to inactivity");
            CaptureManager.this.d();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CaptureManager.this.g();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            CaptureManager.this.d();
        }
    }

    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CaptureManager.this.d();
        }
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        a aVar = new a();
        this.f49007j = aVar;
        this.f49008k = false;
        this.f48998a = activity;
        this.f48999b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(aVar);
        this.f49004g = new Handler();
        this.f49002e = new InactivityTimer(activity, new b());
        this.f49003f = new BeepManager(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f48998a.finish();
    }

    @TargetApi(23)
    private void f() {
        if (ContextCompat.a(this.f48998a, "android.permission.CAMERA") == 0) {
            this.f48999b.resume();
        } else {
            if (this.f49008k) {
                return;
            }
            ActivityCompat.i(this.f48998a, new String[]{"android.permission.CAMERA"}, f48997m);
            this.f49008k = true;
        }
    }

    public static int getCameraPermissionReqCode() {
        return f48997m;
    }

    public static Intent resultIntent(BarcodeResult barcodeResult, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", barcodeResult.toString());
        intent.putExtra("SCAN_RESULT", barcodeResult.getBarcodeFormat().toString());
        byte[] rawBytes = barcodeResult.getRawBytes();
        if (rawBytes != null && rawBytes.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", rawBytes);
        }
        Map<ResultMetadataType, Object> resultMetadata = barcodeResult.getResultMetadata();
        if (resultMetadata != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (resultMetadata.containsKey(resultMetadataType)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", resultMetadata.get(resultMetadataType).toString());
            }
            Number number = (Number) resultMetadata.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i2, (byte[]) it.next());
                    i2++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    public static void setCameraPermissionReqCode(int i2) {
        f48997m = i2;
    }

    public void b() {
        if (this.f48999b.getBarcodeView().isCameraClosed()) {
            d();
        } else {
            this.f49005h = true;
        }
        this.f48999b.pause();
        this.f49002e.cancel();
    }

    public void c() {
        if (this.f48998a.isFinishing() || this.f49001d || this.f49005h) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f48998a);
        builder.setTitle(this.f48998a.getString(R.string.zxing_app_name));
        builder.setMessage(this.f48998a.getString(R.string.zxing_msg_camera_framework_bug));
        builder.setPositiveButton(R.string.zxing_button_ok, new d());
        builder.setOnCancelListener(new e());
        builder.show();
    }

    public void decode() {
        this.f48999b.decodeSingle(this.f49006i);
    }

    public void e() {
        if (this.f49000c == -1) {
            int rotation = this.f48998a.getWindowManager().getDefaultDisplay().getRotation();
            int i2 = this.f48998a.getResources().getConfiguration().orientation;
            int i3 = 0;
            if (i2 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i3 = 8;
                }
            } else if (i2 == 1) {
                i3 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f49000c = i3;
        }
        this.f48998a.setRequestedOrientation(this.f49000c);
    }

    public void g() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("TIMEOUT", true);
        this.f48998a.setResult(0, intent);
        b();
    }

    public void initializeFromIntent(Intent intent, Bundle bundle) {
        this.f48998a.getWindow().addFlags(128);
        if (bundle != null) {
            this.f49000c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                e();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f48999b.initializeFromIntent(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f49003f.setBeepEnabled(false);
            }
            if (intent.hasExtra("TIMEOUT")) {
                this.f49004g.postDelayed(new c(), intent.getLongExtra("TIMEOUT", 0L));
            }
            intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false);
        }
    }

    public void onDestroy() {
        this.f49001d = true;
        this.f49002e.cancel();
        this.f49004g.removeCallbacksAndMessages(null);
    }

    public void onPause() {
        this.f49002e.cancel();
        this.f48999b.pauseAndWait();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == f48997m) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                c();
            } else {
                this.f48999b.resume();
            }
        }
    }

    public void onResume() {
        f();
        this.f49002e.start();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f49000c);
    }

    public void setBarcodeCallBack(BarcodeCallback barcodeCallback) {
        this.f49006i = barcodeCallback;
    }
}
