package io.sentry.android.core.internal.util;

import io.sentry.protocol.Device;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class DeviceOrientations {
    public static Device.DeviceOrientation a(int i2) {
        if (i2 == 1) {
            return Device.DeviceOrientation.PORTRAIT;
        }
        if (i2 != 2) {
            return null;
        }
        return Device.DeviceOrientation.LANDSCAPE;
    }
}
