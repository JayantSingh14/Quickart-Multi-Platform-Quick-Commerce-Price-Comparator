package in.juspay.hyperqr;

import android.media.Image;
import android.util.Base64;
import android.util.Size;
import androidx.annotation.OptIn;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import in.juspay.hyper.core.JuspayLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class QRCodeAnalyzer implements ImageAnalysis.Analyzer {

    @NotNull
    private final Function1<String, Unit> onQrCodeDetected;

    @NotNull
    private final BarcodeScannerOptions options;

    @NotNull
    private final BarcodeScanner scanner;

    /* JADX WARN: Multi-variable type inference failed */
    public QRCodeAnalyzer(@NotNull Function1<? super String, Unit> onQrCodeDetected) {
        Intrinsics.checkNotNullParameter(onQrCodeDetected, "onQrCodeDetected");
        this.onQrCodeDetected = onQrCodeDetected;
        BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(256, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "Builder().setBarcodeForm…MAT_QR_CODE\n    ).build()");
        this.options = barcodeScannerOptionsBuild;
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
        this.scanner = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$1(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        JuspayLogger.e("FirebaseQrScanner", "QR Code detection failed", it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$2(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(imageProxy, "$imageProxy");
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    private final int degreesToFirebaseRotation(int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 90;
        if (i2 != 90) {
            i3 = 180;
            if (i2 != 180) {
                if (i2 == 270) {
                    return 270;
                }
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unsupported rotation degrees: "));
            }
        }
        return i3;
    }

    @OptIn
    public void analyze(@NotNull ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image == null) {
            imageProxy.close();
            return;
        }
        InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, degreesToFirebaseRotation(imageProxy.getImageInfo().getRotationDegrees()));
        Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(mediaImage, imageRotation)");
        Task taskE = this.scanner.process(inputImageFromMediaImage).e(new c(1, new Function1<List<Barcode>, Unit>() { // from class: in.juspay.hyperqr.QRCodeAnalyzer.analyze.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<Barcode>) obj);
                return Unit.f53572a;
            }

            public final void invoke(List<Barcode> list) {
                for (Barcode barcode : list) {
                    if (barcode.getValueType() == 7 && barcode.getRawValue() != null) {
                        Function1 function1 = QRCodeAnalyzer.this.onQrCodeDetected;
                        String rawValue = barcode.getRawValue();
                        Intrinsics.c(rawValue);
                        byte[] bytes = rawValue.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        String strEncodeToString = Base64.encodeToString(bytes, 2);
                        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(\n        …                        )");
                        function1.invoke(strEncodeToString);
                        return;
                    }
                }
            }
        }));
        taskE.c(new com.google.common.net.a(5));
        taskE.addOnCompleteListener(new d(imageProxy));
    }

    @NotNull
    public Size getDefaultTargetResolution() {
        return new Size(2560, 1440);
    }

    @NotNull
    public final BarcodeScannerOptions getOptions() {
        return this.options;
    }
}
