package com.google.ads.interactivemedia.v3.api;

import android.support.v4.media.b;
import androidx.annotation.NonNull;
import androidx.fragment.app.e;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes3.dex */
public final class AdError extends Exception {
    private final AdErrorCode zza;
    private final AdErrorType zzb;

    public enum AdErrorCode {
        INTERNAL_ERROR(-1),
        VAST_MALFORMED_RESPONSE(100),
        UNKNOWN_AD_RESPONSE(1010),
        VAST_TRAFFICKING_ERROR(200),
        VAST_LOAD_TIMEOUT(301),
        VAST_TOO_MANY_REDIRECTS(302),
        VAST_NO_ADS_AFTER_WRAPPER(303),
        VIDEO_PLAY_ERROR(400),
        VAST_MEDIA_LOAD_TIMEOUT(402),
        VAST_LINEAR_ASSET_MISMATCH(403),
        OVERLAY_AD_PLAYING_FAILED(500),
        OVERLAY_AD_LOADING_FAILED(502),
        VAST_NONLINEAR_ASSET_MISMATCH(503),
        COMPANION_AD_LOADING_FAILED(603),
        UNKNOWN_ERROR(900),
        VAST_EMPTY_RESPONSE(1009),
        FAILED_TO_REQUEST_ADS(1005),
        VAST_ASSET_NOT_FOUND(1007),
        ADS_REQUEST_NETWORK_ERROR(1012),
        INVALID_ARGUMENTS(1101),
        PLAYLIST_NO_CONTENT_TRACKING(1205),
        UNEXPECTED_ADS_LOADED_EVENT(1206),
        ADS_PLAYER_NOT_PROVIDED(1207);

        private final int zzb;

        AdErrorCode(int i2) {
            this.zzb = i2;
        }

        @NonNull
        public static AdErrorCode getErrorCodeByNumber(int i2) {
            for (AdErrorCode adErrorCode : values()) {
                if (adErrorCode.getErrorNumber() == i2) {
                    return adErrorCode;
                }
            }
            return i2 == 1204 ? INTERNAL_ERROR : UNKNOWN_ERROR;
        }

        public int getErrorNumber() {
            return this.zzb;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return b.o(b.y("AdErrorCode [name: ", name(), ", number: "), this.zzb, "]");
        }
    }

    public enum AdErrorType {
        LOAD,
        PLAY
    }

    public AdError(@NonNull AdErrorType adErrorType, int i2, @NonNull String str) {
        this(adErrorType, AdErrorCode.getErrorCodeByNumber(i2), str);
    }

    @NonNull
    public AdErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeNumber() {
        return this.zza.getErrorNumber();
    }

    @NonNull
    public AdErrorType getErrorType() {
        return this.zzb;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    @NonNull
    @KeepForSdk
    public String toString() {
        AdErrorCode adErrorCode = this.zza;
        String strValueOf = String.valueOf(this.zzb);
        String strValueOf2 = String.valueOf(adErrorCode);
        return b.r(e.v("AdError [errorType: ", strValueOf, ", errorCode: ", strValueOf2, ", message: "), getMessage(), "]");
    }

    public AdError(@NonNull AdErrorType adErrorType, @NonNull AdErrorCode adErrorCode, @NonNull String str) {
        super(str);
        this.zzb = adErrorType;
        this.zza = adErrorCode;
    }
}
