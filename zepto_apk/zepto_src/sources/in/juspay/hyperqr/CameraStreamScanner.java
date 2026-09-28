package in.juspay.hyperqr;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class CameraStreamScanner {

    @NotNull
    private final Function1<String, Unit> callback;
    private Camera camera;
    private ExecutorService cameraExecutor;
    private ProcessCameraProvider cameraProvider;

    @NotNull
    private final ViewGroup container;

    @NotNull
    private final Context context;

    @NotNull
    private final LifecycleOwner owner;
    private PreviewView previewView;
    private RelativeLayout relativeLayout;

    /* JADX WARN: Multi-variable type inference failed */
    public CameraStreamScanner(@NotNull ViewGroup container, @NotNull LifecycleOwner owner, @NotNull Context context, @NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.container = container;
        this.owner = owner;
        this.context = context;
        this.callback = callback;
    }

    private final void createUI() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.cameraExecutor = executorServiceNewSingleThreadExecutor;
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        this.relativeLayout = relativeLayout;
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PreviewView previewView = new PreviewView(this.context);
        previewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        previewView.setVisibility(0);
        this.previewView = previewView;
        previewView.setImplementationMode(PreviewView.ImplementationMode.COMPATIBLE);
        ViewGroup viewGroup = this.container;
        RelativeLayout relativeLayout2 = this.relativeLayout;
        if (relativeLayout2 != null) {
            viewGroup.addView(relativeLayout2);
        } else {
            Intrinsics.h("relativeLayout");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseCameraResources$lambda$5(CameraStreamScanner this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProcessCameraProvider processCameraProvider = this$0.cameraProvider;
        if (processCameraProvider == null) {
            Intrinsics.h("cameraProvider");
            throw null;
        }
        processCameraProvider.unbindAll();
        ExecutorService executorService = this$0.cameraExecutor;
        if (executorService != null) {
            executorService.shutdown();
        } else {
            Intrinsics.h("cameraExecutor");
            throw null;
        }
    }

    private final void startCamera() {
        ListenableFuture processCameraProvider = ProcessCameraProvider.getInstance(this.context);
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(context)");
        processCameraProvider.q(new in.juspay.hypernfc.b(1, this, processCameraProvider), ContextCompat.c(this.context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCamera$lambda$4(final CameraStreamScanner this$0, ListenableFuture cameraProviderFuture) throws ExecutionException, InterruptedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraProviderFuture, "$cameraProviderFuture");
        V v = cameraProviderFuture.get();
        Intrinsics.checkNotNullExpressionValue(v, "cameraProviderFuture.get()");
        this$0.cameraProvider = (ProcessCameraProvider) v;
        Preview previewBuild = new Preview.Builder().build();
        PreviewView previewView = this$0.previewView;
        if (previewView == null) {
            Intrinsics.h("previewView");
            throw null;
        }
        previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "Builder().build().also {…ovider)\n                }");
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setTargetResolution(new Size(2560, 1440)).setBackpressureStrategy(0).build();
        QRCodeAnalyzer qRCodeAnalyzer = new QRCodeAnalyzer(new Function1<String, Unit>() { // from class: in.juspay.hyperqr.CameraStreamScanner$startCamera$1$imageAnalyzer$1$analyzer$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.f53572a;
            }

            public final void invoke(@NotNull String qrCode) {
                Intrinsics.checkNotNullParameter(qrCode, "qrCode");
                this.this$0.callback.invoke(qrCode);
                this.this$0.releaseCameraResources();
            }
        });
        ExecutorService executorService = this$0.cameraExecutor;
        if (executorService == null) {
            Intrinsics.h("cameraExecutor");
            throw null;
        }
        imageAnalysisBuild.setAnalyzer(executorService, qRCodeAnalyzer);
        Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "Builder().setTargetResol…alyzer)\n                }");
        CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
        try {
            ExecutorManager.runOnMainThread(new b(this$0, DEFAULT_BACK_CAMERA, previewBuild, imageAnalysisBuild, 0));
        } catch (Exception e2) {
            JuspayLogger.e("FirebaseQrScanner", "camera binding failed", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCamera$lambda$4$lambda$3(CameraStreamScanner this$0, CameraSelector cameraSelector, Preview preview, ImageAnalysis imageAnalyzer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraSelector, "$cameraSelector");
        Intrinsics.checkNotNullParameter(preview, "$preview");
        Intrinsics.checkNotNullParameter(imageAnalyzer, "$imageAnalyzer");
        ProcessCameraProvider processCameraProvider = this$0.cameraProvider;
        if (processCameraProvider == null) {
            Intrinsics.h("cameraProvider");
            throw null;
        }
        processCameraProvider.unbindAll();
        ProcessCameraProvider processCameraProvider2 = this$0.cameraProvider;
        if (processCameraProvider2 == null) {
            Intrinsics.h("cameraProvider");
            throw null;
        }
        Camera cameraBindToLifecycle = processCameraProvider2.bindToLifecycle(this$0.owner, cameraSelector, new UseCase[]{preview, imageAnalyzer});
        Intrinsics.checkNotNullExpressionValue(cameraBindToLifecycle, "cameraProvider.bindToLif…                        )");
        this$0.camera = cameraBindToLifecycle;
        RelativeLayout relativeLayout = this$0.relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.h("relativeLayout");
            throw null;
        }
        PreviewView previewView = this$0.previewView;
        if (previewView != null) {
            relativeLayout.addView((View) previewView, 0);
        } else {
            Intrinsics.h("previewView");
            throw null;
        }
    }

    public final void releaseCameraResources() {
        try {
            ExecutorManager.runOnMainThread(new a(this, 0));
        } catch (Exception e2) {
            JuspayLogger.e("FirebaseQrScanner", "camera resource release failed", e2);
        }
    }

    public final void scanWithCamera() {
        try {
            createUI();
            startCamera();
        } catch (Exception e2) {
            JuspayLogger.e("FirebaseQrScanner", "setting ui and starting camera failed", e2);
            releaseCameraResources();
        }
    }

    public final boolean toggleFlashlight() {
        Camera camera = this.camera;
        boolean z = false;
        if (camera == null) {
            return false;
        }
        if (camera == null) {
            Intrinsics.h("camera");
            throw null;
        }
        CameraControl cameraControl = camera.getCameraControl();
        Intrinsics.checkNotNullExpressionValue(cameraControl, "camera.cameraControl");
        Camera camera2 = this.camera;
        if (camera2 == null) {
            Intrinsics.h("camera");
            throw null;
        }
        Integer num = (Integer) camera2.getCameraInfo().getTorchState().d();
        if (num != null && num.intValue() == 1) {
            z = true;
        }
        cameraControl.enableTorch(!z);
        return !z;
    }
}
