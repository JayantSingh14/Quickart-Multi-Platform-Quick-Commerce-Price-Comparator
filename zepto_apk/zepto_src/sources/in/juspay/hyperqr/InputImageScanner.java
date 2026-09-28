package in.juspay.hyperqr;

import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import in.juspay.hyper.core.JuspayLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class InputImageScanner {

    @NotNull
    private final Function1<String, Unit> failureCallback;
    private BarcodeScanner scanner;

    @NotNull
    private final Function1<String, Unit> successCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public InputImageScanner(@NotNull Function1<? super String, Unit> successCallback, @NotNull Function1<? super String, Unit> failureCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        this.successCallback = successCallback;
        this.failureCallback = failureCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scanImage$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scanImage$lambda$1(InputImageScanner this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.failureCallback.invoke("exception on scanning image " + it);
        JuspayLogger.e("FirebaseQrScanner", "exception on scanning gallery image", it);
    }

    public final void releaseResources() {
        BarcodeScanner barcodeScanner = this.scanner;
        if (barcodeScanner != null) {
            barcodeScanner.close();
        } else {
            Intrinsics.h("scanner");
            throw null;
        }
    }

    public final void scanImage(@NotNull InputImage inputImage) {
        Intrinsics.checkNotNullParameter(inputImage, "inputImage");
        BarcodeScanner client = BarcodeScanning.getClient(new BarcodeScannerOptions.Builder().setBarcodeFormats(256, new int[]{4096}).build());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(\n            B…      ).build()\n        )");
        this.scanner = client;
        if (client == null) {
            Intrinsics.h("scanner");
            throw null;
        }
        client.process(inputImage).e(new c(0, new Function1<List<Barcode>, Unit>() { // from class: in.juspay.hyperqr.InputImageScanner.scanImage.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws UnsupportedEncodingException {
                invoke((List<Barcode>) obj);
                return Unit.f53572a;
            }

            public final void invoke(List<Barcode> list) throws UnsupportedEncodingException {
                for (Barcode barcode : list) {
                    if (barcode.getValueType() == 7 && barcode.getRawValue() != null) {
                        Function1 function1 = InputImageScanner.this.successCallback;
                        String strEncode = URLEncoder.encode(barcode.getRawValue(), "UTF-8");
                        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(barcode.rawValue, \"UTF-8\")");
                        function1.invoke(StringsKt.K(strEncode, "+", "%20"));
                        return;
                    }
                }
                InputImageScanner.this.failureCallback.invoke("Could not able to find any qr in image");
            }
        })).c(new d(this));
    }
}
