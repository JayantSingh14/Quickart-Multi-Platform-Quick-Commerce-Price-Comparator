package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceHolder f49150a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f49151b;

    public e(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.f49151b = surfaceTexture;
    }

    public void a(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.f49150a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.f49151b);
        }
    }

    public e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.f49150a = surfaceHolder;
    }
}
