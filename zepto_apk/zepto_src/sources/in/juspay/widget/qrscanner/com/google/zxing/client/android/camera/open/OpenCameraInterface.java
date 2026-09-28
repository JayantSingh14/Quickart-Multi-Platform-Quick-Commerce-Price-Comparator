package in.juspay.widget.qrscanner.com.google.zxing.client.android.camera.open;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes4.dex */
public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f48862a = "in.juspay.widget.qrscanner.com.google.zxing.client.android.camera.open.OpenCameraInterface";

    private OpenCameraInterface() {
    }

    public static int getCameraId(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f48862a, "No cameras!");
            return -1;
        }
        boolean z = i2 >= 0;
        if (!z) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        return i2 < numberOfCameras ? i2 : z ? -1 : 0;
    }

    public static Camera open(int i2) {
        int cameraId = getCameraId(i2);
        if (cameraId == -1) {
            return null;
        }
        return Camera.open(cameraId);
    }
}
