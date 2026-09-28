package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public class PlaybackException extends Exception {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5415d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5416e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f5417f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f5418g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f5419h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f5420i;

    /* renamed from: a, reason: collision with root package name */
    public final int f5421a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5422b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f5423c;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    static {
        int i2 = Util.f5744a;
        f5415d = Integer.toString(0, 36);
        f5416e = Integer.toString(1, 36);
        f5417f = Integer.toString(2, 36);
        f5418g = Integer.toString(3, 36);
        f5419h = Integer.toString(4, 36);
        f5420i = Integer.toString(5, 36);
    }

    public PlaybackException(String str, Throwable th, int i2, Bundle bundle, long j2) {
        super(str, th);
        this.f5421a = i2;
        this.f5423c = bundle;
        this.f5422b = j2;
    }

    public static String b(int i2) {
        if (i2 == -100) {
            return "ERROR_CODE_DISCONNECTED";
        }
        if (i2 == -6) {
            return "ERROR_CODE_NOT_SUPPORTED";
        }
        if (i2 == -4) {
            return "ERROR_CODE_PERMISSION_DENIED";
        }
        if (i2 == -3) {
            return "ERROR_CODE_BAD_VALUE";
        }
        if (i2 == -2) {
            return "ERROR_CODE_INVALID_STATE";
        }
        if (i2 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i2 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i2) {
            case -110:
                return "ERROR_CODE_CONTENT_ALREADY_PLAYING";
            case -109:
                return "ERROR_CODE_END_OF_PLAYLIST";
            case -108:
                return "ERROR_CODE_SETUP_REQUIRED";
            case -107:
                return "ERROR_CODE_SKIP_LIMIT_REACHED";
            case -106:
                return "ERROR_CODE_NOT_AVAILABLE_IN_REGION";
            case -105:
                return "ERROR_CODE_PARENTAL_CONTROL_RESTRICTED";
            case -104:
                return "ERROR_CODE_CONCURRENT_STREAM_LIMIT";
            case -103:
                return "ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED";
            case -102:
                return "ERROR_CODE_AUTHENTICATION_EXPIRED";
            default:
                switch (i2) {
                    case 1000:
                        return "ERROR_CODE_UNSPECIFIED";
                    case DateUtils.SEMI_MONTH /* 1001 */:
                        return "ERROR_CODE_REMOTE_ERROR";
                    case 1002:
                        return "ERROR_CODE_BEHIND_LIVE_WINDOW";
                    case 1003:
                        return "ERROR_CODE_TIMEOUT";
                    case 1004:
                        return "ERROR_CODE_FAILED_RUNTIME_CHECK";
                    default:
                        switch (i2) {
                            case 2000:
                                return "ERROR_CODE_IO_UNSPECIFIED";
                            case 2001:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                            case 2002:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                            case 2003:
                                return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                            case 2004:
                                return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                            case 2005:
                                return "ERROR_CODE_IO_FILE_NOT_FOUND";
                            case 2006:
                                return "ERROR_CODE_IO_NO_PERMISSION";
                            case 2007:
                                return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                            case 2008:
                                return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                            default:
                                switch (i2) {
                                    case 3001:
                                        return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                    case 3002:
                                        return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                    case 3003:
                                        return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                    case 3004:
                                        return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                    default:
                                        switch (i2) {
                                            case 4001:
                                                return "ERROR_CODE_DECODER_INIT_FAILED";
                                            case 4002:
                                                return "ERROR_CODE_DECODER_QUERY_FAILED";
                                            case 4003:
                                                return "ERROR_CODE_DECODING_FAILED";
                                            case 4004:
                                                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                            case 4005:
                                                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                            case 4006:
                                                return "ERROR_CODE_DECODING_RESOURCES_RECLAIMED";
                                            default:
                                                switch (i2) {
                                                    case 5001:
                                                        return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
                                                    case 5002:
                                                        return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
                                                    case 5003:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_WRITE_FAILED";
                                                    case 5004:
                                                        return "ERROR_CODE_AUDIO_TRACK_OFFLOAD_INIT_FAILED";
                                                    default:
                                                        switch (i2) {
                                                            case 6000:
                                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                                            case 6001:
                                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                            case 6002:
                                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                            case 6003:
                                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                            case 6004:
                                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                            case 6005:
                                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                            case 6006:
                                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                            case 6007:
                                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                            case 6008:
                                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                            default:
                                                                return i2 >= 1000000 ? "custom error code" : "invalid error code";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public boolean a(PlaybackException playbackException) {
        if (this == playbackException) {
            return true;
        }
        if (playbackException != null && getClass() == playbackException.getClass()) {
            Throwable cause = getCause();
            Throwable cause2 = playbackException.getCause();
            if (cause == null || cause2 == null) {
                if (cause == null && cause2 == null) {
                }
            } else if (!Util.a(cause.getMessage(), cause2.getMessage()) || !cause.getClass().equals(cause2.getClass())) {
                return false;
            }
            if (this.f5421a == playbackException.f5421a && Util.a(getMessage(), playbackException.getMessage()) && this.f5422b == playbackException.f5422b) {
                return true;
            }
        }
        return false;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(f5415d, this.f5421a);
        bundle.putLong(f5416e, this.f5422b);
        bundle.putString(f5417f, getMessage());
        bundle.putBundle(f5420i, this.f5423c);
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(f5418g, cause.getClass().getName());
            bundle.putString(f5419h, cause.getMessage());
        }
        return bundle;
    }
}
