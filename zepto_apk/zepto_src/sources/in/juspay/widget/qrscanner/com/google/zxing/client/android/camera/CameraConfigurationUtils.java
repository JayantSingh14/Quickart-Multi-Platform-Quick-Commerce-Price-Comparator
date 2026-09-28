package in.juspay.widget.qrscanner.com.google.zxing.client.android.camera;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.support.v4.media.b;
import android.util.Log;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l.d;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class CameraConfigurationUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f48861a = Pattern.compile(";");

    private CameraConfigurationUtils() {
    }

    private static Integer a(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i("CameraConfiguration", "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w("CameraConfiguration", "Invalid zoom ratios!");
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
            double dAbs = Math.abs(zoomRatios.get(i3).intValue() - d3);
            if (dAbs < d4) {
                i2 = i3;
                d4 = dAbs;
            }
        }
        Log.i("CameraConfiguration", "Chose zoom ratio of " + (zoomRatios.get(i2).intValue() / 100.0d));
        return Integer.valueOf(i2);
    }

    public static String collectStats(Camera.Parameters parameters) {
        return collectStats(parameters.flatten());
    }

    public static void setBarcodeSceneMode(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String strA = a("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strA != null) {
            parameters.setSceneMode(strA);
        }
    }

    public static void setBestExposure(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int iRound = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * iRound;
                int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == iMax) {
                    Log.i("CameraConfiguration", "Exposure compensation already set to " + iMax + " / " + f2);
                    return;
                }
                Log.i("CameraConfiguration", "Setting exposure compensation to " + iMax + " / " + f2);
                parameters.setExposureCompensation(iMax);
                return;
            }
        }
        Log.i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters) {
        setBestPreviewFPS(parameters, 10, 20);
    }

    public static void setFocus(Camera.Parameters parameters, d.a aVar, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strA = (z || aVar == d.a.AUTO) ? a("focus mode", supportedFocusModes, "auto") : aVar == d.a.CONTINUOUS ? a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : aVar == d.a.INFINITY ? a("focus mode", supportedFocusModes, "infinity") : aVar == d.a.MACRO ? a("focus mode", supportedFocusModes, "macro") : null;
        if (!z && strA == null) {
            strA = a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strA != null) {
            if (strA.equals(parameters.getFocusMode())) {
                Log.i("CameraConfiguration", "Focus mode already set to ".concat(strA));
            } else {
                parameters.setFocusMode(strA);
            }
        }
    }

    @TargetApi(15)
    public static void setFocusArea(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + a((Iterable<Camera.Area>) parameters.getFocusAreas()));
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + a((Iterable<Camera.Area>) listA));
        parameters.setFocusAreas(listA);
    }

    public static void setInvertColor(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String strA = a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strA != null) {
            parameters.setColorEffect(strA);
        }
    }

    @TargetApi(15)
    public static void setMetering(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + a((Iterable<Camera.Area>) listA));
        parameters.setMeteringAreas(listA);
    }

    public static void setTorch(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strA = z ? a("flash mode", supportedFlashModes, "torch", "on") : a("flash mode", supportedFlashModes, "off");
        if (strA != null) {
            if (strA.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to ".concat(strA));
            } else {
                Log.i("CameraConfiguration", "Setting flash mode to ".concat(strA));
                parameters.setFlashMode(strA);
            }
        }
    }

    @TargetApi(15)
    public static void setVideoStabilization(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void setZoom(Camera.Parameters parameters, double d2) {
        if (!parameters.isZoomSupported()) {
            Log.i("CameraConfiguration", "Zoom is not supported");
            return;
        }
        Integer numA = a(parameters, d2);
        if (numA == null) {
            return;
        }
        if (parameters.getZoom() == numA.intValue()) {
            Log.i("CameraConfiguration", "Zoom is already set to " + numA);
        } else {
            Log.i("CameraConfiguration", "Setting zoom to " + numA);
            parameters.setZoom(numA.intValue());
        }
    }

    @TargetApi(15)
    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String collectStats(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append("\nBRAND=");
        sb.append(Build.BRAND);
        sb.append("\nCPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append("\nDEVICE=");
        sb.append(Build.DEVICE);
        sb.append("\nDISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append("\nFINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append("\nHOST=");
        sb.append(Build.HOST);
        sb.append("\nID=");
        sb.append(Build.ID);
        sb.append("\nMANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append("\nMODEL=");
        sb.append(Build.MODEL);
        sb.append("\nPRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append("\nTAGS=");
        sb.append(Build.TAGS);
        sb.append("\nTIME=");
        sb.append(Build.TIME);
        sb.append("\nTYPE=");
        sb.append(Build.TYPE);
        sb.append("\nUSER=");
        sb.append(Build.USER);
        sb.append("\nVERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append("\nVERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append("\nVERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("\nVERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] strArrSplit = f48861a.split(charSequence);
            Arrays.sort(strArrSplit);
            for (String str : strArrSplit) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters, int i2, int i3) {
        int[] next;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i("CameraConfiguration", "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int i4 = next[0];
            int i5 = next[1];
            if (i4 >= i2 * 1000 && i5 <= i3 * 1000) {
                break;
            }
        }
        if (next == null) {
            Log.i("CameraConfiguration", "No suitable FPS range?");
            return;
        }
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (Arrays.equals(iArr, next)) {
            Log.i("CameraConfiguration", "FPS range already set to " + Arrays.toString(next));
        } else {
            Log.i("CameraConfiguration", "Setting FPS range to " + Arrays.toString(next));
            parameters.setPreviewFpsRange(next[0], next[1]);
        }
    }

    private static String a(String str, Collection<String> collection, String... strArr) {
        StringBuilder sbY = b.y("Requesting ", str, " value from among: ");
        sbY.append(Arrays.toString(strArr));
        Log.i("CameraConfiguration", sbY.toString());
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    private static String a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @TargetApi(15)
    private static List<Camera.Area> a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }
}
