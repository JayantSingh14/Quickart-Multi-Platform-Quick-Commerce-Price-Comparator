package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.MultiFormatReader;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.DecodeFormatManager;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.DecodeHintManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class DecoratedBarcodeView extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f49014e = 0;

    /* renamed from: a, reason: collision with root package name */
    private BarcodeView f49015a;

    /* renamed from: b, reason: collision with root package name */
    private ViewfinderView f49016b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f49017c;

    /* renamed from: d, reason: collision with root package name */
    private a f49018d;

    public interface a {
        void a();

        void b();
    }

    public class b implements BarcodeCallback {

        /* renamed from: a, reason: collision with root package name */
        private BarcodeCallback f49019a;

        public b(BarcodeCallback barcodeCallback) {
            this.f49019a = barcodeCallback;
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback
        public void barcodeResult(BarcodeResult barcodeResult) {
            this.f49019a.barcodeResult(barcodeResult);
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.BarcodeCallback
        public void possibleResultPoints(List<ResultPoint> list) {
            Iterator<ResultPoint> it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.f49016b.a(it.next());
            }
            this.f49019a.possibleResultPoints(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        a();
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f49015a.decodeContinuous(new b(barcodeCallback));
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.f49015a.decodeSingle(new b(barcodeCallback));
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.juspay_zxing_barcode_surface);
    }

    public TextView getStatusView() {
        return this.f49017c;
    }

    public ViewfinderView getViewFinder() {
        return this.f49016b;
    }

    public void initializeFromIntent(Intent intent) {
        int intExtra;
        Set<BarcodeFormat> decodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
        Map<DecodeHintType, ?> decodeHints = DecodeHintManager.parseDecodeHints(intent);
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d dVar = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            dVar.a(intExtra);
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new MultiFormatReader().setHints(decodeHints);
        this.f49015a.setCameraSettings(dVar);
        this.f49015a.setDecoderFactory(new f(decodeFormats, decodeHints, stringExtra2));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            setTorchOn();
            return true;
        }
        if (i2 == 25) {
            setTorchOff();
            return true;
        }
        if (i2 == 27 || i2 == 80) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void pause() {
        this.f49015a.pause();
    }

    public void pauseAndWait() throws InterruptedException {
        this.f49015a.pauseAndWait();
    }

    public void resume() {
        this.f49015a.resume();
    }

    public void setStatusText(String str) {
        TextView textView = this.f49017c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
        this.f49018d = aVar;
    }

    public void setTorchOff() {
        this.f49015a.setTorch(false);
        a aVar = this.f49018d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setTorchOn() {
        this.f49015a.setTorch(true);
        a aVar = this.f49018d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    private void a() {
        a((AttributeSet) null);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_juspay_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.juspay_zxing_barcode_surface);
        this.f49015a = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.a(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.juspay_zxing_viewfinder_view);
        this.f49016b = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.f49015a);
        TextView textView = (TextView) findViewById(R.id.juspay_zxing_status_view);
        textView.setText(R.string.zxing_msg_qrcode_status);
        this.f49017c = textView;
    }
}
