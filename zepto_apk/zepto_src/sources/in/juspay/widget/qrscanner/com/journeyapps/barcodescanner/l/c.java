package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.AmbientLightManager;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.camera.CameraConfigurationUtils;
import in.juspay.widget.qrscanner.com.google.zxing.client.android.camera.open.OpenCameraInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class c {
    private static final String n = "c";

    /* renamed from: a, reason: collision with root package name */
    private Camera f49121a;

    /* renamed from: b, reason: collision with root package name */
    private Camera.CameraInfo f49122b;

    /* renamed from: c, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a f49123c;

    /* renamed from: d, reason: collision with root package name */
    private AmbientLightManager f49124d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f49125e;

    /* renamed from: f, reason: collision with root package name */
    private String f49126f;

    /* renamed from: h, reason: collision with root package name */
    private h f49128h;

    /* renamed from: i, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i f49129i;

    /* renamed from: j, reason: collision with root package name */
    private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i f49130j;

    /* renamed from: l, reason: collision with root package name */
    private Context f49132l;

    /* renamed from: g, reason: collision with root package name */
    private d f49127g = new d();

    /* renamed from: k, reason: collision with root package name */
    private int f49131k = -1;

    /* renamed from: m, reason: collision with root package name */
    private final a f49133m = new a();

    public final class a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        private k f49134a;

        /* renamed from: b, reason: collision with root package name */
        private in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i f49135b;

        public a() {
        }

        public void a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
            this.f49135b = iVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar = this.f49135b;
            k kVar = this.f49134a;
            if (iVar == null || kVar == null) {
                Log.d(c.n, "Got preview callback, but no handler or resolution available");
                if (kVar != null) {
                    kVar.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                kVar.a(new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.j(bArr, iVar.f49078a, iVar.f49079b, camera.getParameters().getPreviewFormat(), c.this.e()));
            } catch (RuntimeException e2) {
                Log.e(c.n, "Camera preview failed", e2);
                kVar.a(e2);
            }
        }

        public void a(k kVar) {
            this.f49134a = kVar;
        }
    }

    public c(Context context) {
        this.f49132l = context;
    }

    private int b() {
        int iA = this.f49128h.a();
        int i2 = 0;
        if (iA != 0) {
            if (iA == 1) {
                i2 = 90;
            } else if (iA == 2) {
                i2 = 180;
            } else if (iA == 3) {
                i2 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f49122b;
        int i3 = cameraInfo.facing;
        int i4 = cameraInfo.orientation;
        int i5 = (i3 == 1 ? 360 - ((i4 + i2) % 360) : (i4 - i2) + 360) % 360;
        Log.i(n, "Camera Display Orientation: " + i5);
        return i5;
    }

    private Camera.Parameters f() {
        Camera.Parameters parameters = this.f49121a.getParameters();
        String str = this.f49126f;
        if (str == null) {
            this.f49126f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    private void k() {
        try {
            int iB = b();
            this.f49131k = iB;
            a(iB);
        } catch (Exception unused) {
            Log.w(n, "Failed to set rotation.");
        }
        try {
            a(false);
        } catch (Exception unused2) {
            try {
                a(true);
            } catch (Exception unused3) {
                Log.w(n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f49121a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f49130j = this.f49129i;
        } else {
            this.f49130j = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i(previewSize.width, previewSize.height);
        }
        this.f49133m.a(this.f49130j);
    }

    public void c() {
        Camera camera = this.f49121a;
        if (camera != null) {
            camera.release();
            this.f49121a = null;
        }
    }

    public void d() {
        if (this.f49121a == null) {
            throw new RuntimeException("Camera not open");
        }
        k();
    }

    public int e() {
        return this.f49131k;
    }

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i g() {
        if (this.f49130j == null) {
            return null;
        }
        return h() ? this.f49130j.a() : this.f49130j;
    }

    public boolean h() {
        int i2 = this.f49131k;
        if (i2 != -1) {
            return i2 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean i() {
        String flashMode;
        Camera.Parameters parameters = this.f49121a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void j() {
        Camera cameraOpen = OpenCameraInterface.open(this.f49127g.b());
        this.f49121a = cameraOpen;
        if (cameraOpen == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int cameraId = OpenCameraInterface.getCameraId(this.f49127g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f49122b = cameraInfo;
        Camera.getCameraInfo(cameraId, cameraInfo);
    }

    public void l() {
        Camera camera = this.f49121a;
        if (camera == null || this.f49125e) {
            return;
        }
        camera.startPreview();
        this.f49125e = true;
        this.f49123c = new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a(this.f49121a, this.f49127g);
        AmbientLightManager ambientLightManager = new AmbientLightManager(this.f49132l, this, this.f49127g);
        this.f49124d = ambientLightManager;
        ambientLightManager.start();
    }

    public void m() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a aVar = this.f49123c;
        if (aVar != null) {
            aVar.e();
            this.f49123c = null;
        }
        AmbientLightManager ambientLightManager = this.f49124d;
        if (ambientLightManager != null) {
            ambientLightManager.stop();
            this.f49124d = null;
        }
        Camera camera = this.f49121a;
        if (camera == null || !this.f49125e) {
            return;
        }
        camera.stopPreview();
        this.f49133m.a((k) null);
        this.f49125e = false;
    }

    private static List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i(previewSize.width, previewSize.height));
                return arrayList;
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i(size.width, size.height));
            }
        }
        return arrayList;
    }

    public void b(boolean z) {
        if (this.f49121a != null) {
            try {
                if (z != i()) {
                    in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a aVar = this.f49123c;
                    if (aVar != null) {
                        aVar.e();
                    }
                    Camera.Parameters parameters = this.f49121a.getParameters();
                    CameraConfigurationUtils.setTorch(parameters, z);
                    if (this.f49127g.f()) {
                        CameraConfigurationUtils.setBestExposure(parameters, z);
                    }
                    this.f49121a.setParameters(parameters);
                    in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.a aVar2 = this.f49123c;
                    if (aVar2 != null) {
                        aVar2.d();
                    }
                }
            } catch (RuntimeException e2) {
                Log.e(n, "Failed to set torch", e2);
            }
        }
    }

    private void a(int i2) {
        this.f49121a.setDisplayOrientation(i2);
    }

    public void a(d dVar) {
        this.f49127g = dVar;
    }

    public void a(e eVar) throws IOException {
        eVar.a(this.f49121a);
    }

    public void a(h hVar) {
        this.f49128h = hVar;
    }

    public void a(k kVar) {
        Camera camera = this.f49121a;
        if (camera == null || !this.f49125e) {
            return;
        }
        this.f49133m.a(kVar);
        camera.setOneShotPreviewCallback(this.f49133m);
    }

    private void a(boolean z) {
        Camera.Parameters parametersF = f();
        if (parametersF == null) {
            Log.w(n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = n;
        Log.i(str, "Initial camera parameters: " + parametersF.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        CameraConfigurationUtils.setFocus(parametersF, this.f49127g.a(), z);
        if (!z) {
            CameraConfigurationUtils.setTorch(parametersF, false);
            if (this.f49127g.h()) {
                CameraConfigurationUtils.setInvertColor(parametersF);
            }
            if (this.f49127g.e()) {
                CameraConfigurationUtils.setBarcodeSceneMode(parametersF);
            }
            if (this.f49127g.g()) {
                CameraConfigurationUtils.setVideoStabilization(parametersF);
                CameraConfigurationUtils.setFocusArea(parametersF);
                CameraConfigurationUtils.setMetering(parametersF);
            }
        }
        List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> listA = a(parametersF);
        if (listA.size() == 0) {
            this.f49129i = null;
        } else {
            in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVarA = this.f49128h.a(listA, h());
            this.f49129i = iVarA;
            parametersF.setPreviewSize(iVarA.f49078a, iVarA.f49079b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.setBestPreviewFPS(parametersF);
        }
        Log.i(str, "Final camera parameters: " + parametersF.flatten());
        this.f49121a.setParameters(parametersF);
    }
}
