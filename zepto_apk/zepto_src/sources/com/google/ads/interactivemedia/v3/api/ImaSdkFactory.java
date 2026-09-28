package com.google.ads.interactivemedia.v3.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.AdsRequestImpl;
import com.google.ads.interactivemedia.v3.impl.ImaSdkSettingsImpl;
import com.google.ads.interactivemedia.v3.impl.data.zzbo;
import com.google.ads.interactivemedia.v3.impl.data.zzbp;
import com.google.ads.interactivemedia.v3.impl.data.zzby;
import com.google.ads.interactivemedia.v3.impl.data.zzh;
import com.google.ads.interactivemedia.v3.impl.zzad;
import com.google.ads.interactivemedia.v3.impl.zzam;
import com.google.ads.interactivemedia.v3.impl.zzbq;
import com.google.ads.interactivemedia.v3.impl.zzbs;
import com.google.ads.interactivemedia.v3.impl.zzc;
import com.google.ads.interactivemedia.v3.impl.zzu;
import com.google.ads.interactivemedia.v3.impl.zzy;
import com.google.ads.interactivemedia.v3.internal.zzec;
import com.google.ads.interactivemedia.v3.internal.zztj;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class ImaSdkFactory {

    @Nullable
    private static ImaSdkFactory zza;

    private ImaSdkFactory() {
    }

    @KeepForSdk
    private AdsLoader createAdsLoader(Context context, @Nullable Uri uri, BaseDisplayContainer baseDisplayContainer, ImaSdkSettings imaSdkSettings) {
        zzec zzecVar = new zzec();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_START);
        if (uri == null) {
            uri = zzb(imaSdkSettings);
        }
        zzu zzuVar = new zzu(context, uri, imaSdkSettings, baseDisplayContainer, zzecVar, zza());
        zzuVar.zzp();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_END);
        return zzuVar;
    }

    @NonNull
    public static ImaSdkFactory getInstance() {
        if (zza == null) {
            zza = new ImaSdkFactory();
        }
        return zza;
    }

    private static ExecutorService zza() {
        zztj zztjVar = new zztj();
        zztjVar.zza("imasdk-%d");
        return Executors.newCachedThreadPool(zztjVar.zzb());
    }

    private static final Uri zzb(ImaSdkSettings imaSdkSettings) {
        return (imaSdkSettings == null || !imaSdkSettings.isDebugMode()) ? zzam.zza : zzam.zzb;
    }

    @NonNull
    @Deprecated
    public AdDisplayContainer createAdDisplayContainer() {
        return new zzc(null, null);
    }

    @NonNull
    public AdsRenderingSettings createAdsRenderingSettings() {
        return new zzh();
    }

    @NonNull
    public AdsRequest createAdsRequest() {
        return new AdsRequestImpl();
    }

    @NonNull
    @Deprecated
    public AdDisplayContainer createAudioAdDisplayContainer(@NonNull Context context) {
        context.getClass();
        return new zzy(context, null);
    }

    @NonNull
    public CompanionAdSlot createCompanionAdSlot() {
        return new zzad();
    }

    @NonNull
    public FriendlyObstruction createFriendlyObstruction(@NonNull View view, @NonNull FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        zzbo zzboVarBuilder = zzbp.builder();
        zzboVarBuilder.view(view);
        zzboVarBuilder.purpose(friendlyObstructionPurpose);
        zzboVarBuilder.detailedReason(str);
        return zzboVarBuilder.build();
    }

    @NonNull
    public ImaSdkSettings createImaSdkSettings() {
        return new ImaSdkSettingsImpl();
    }

    @NonNull
    public StreamRequest createLiveStreamRequest(@NonNull String str, @Nullable String str2) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzd(str);
        zzbsVar.zzc(str2);
        return zzbsVar;
    }

    @NonNull
    public StreamRequest createPodStreamRequest(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzi(str);
        zzbsVar.zzg(str2);
        zzbsVar.zzc(str3);
        return zzbsVar;
    }

    @NonNull
    public StreamRequest createPodVodStreamRequest(@NonNull String str) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzi(str);
        return zzbsVar;
    }

    @NonNull
    @Deprecated
    public StreamDisplayContainer createStreamDisplayContainer() {
        return new zzbq(null, null);
    }

    @NonNull
    public StreamRequest createVideoStitcherLiveStreamRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzi(str);
        zzbsVar.zzg(str2);
        zzbsVar.zzh(str3);
        zzbsVar.zzl(str4);
        zzbsVar.zzk(str5);
        zzbsVar.zzj(str6);
        return zzbsVar;
    }

    @NonNull
    public StreamRequest createVideoStitcherVodStreamRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzi(str);
        zzbsVar.zzl(str2);
        zzbsVar.zzk(str3);
        zzbsVar.zzj(str4);
        zzbsVar.zzn(str5);
        return zzbsVar;
    }

    @NonNull
    public StreamRequest createVodStreamRequest(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zze(str);
        zzbsVar.zzm(str2);
        zzbsVar.zzc(str3);
        return zzbsVar;
    }

    @NonNull
    public static AdDisplayContainer createAdDisplayContainer(@NonNull ViewGroup viewGroup, @NonNull VideoAdPlayer videoAdPlayer) {
        viewGroup.getClass();
        videoAdPlayer.getClass();
        return new zzc(viewGroup, videoAdPlayer);
    }

    @NonNull
    public static StreamDisplayContainer createStreamDisplayContainer(@NonNull ViewGroup viewGroup, @NonNull VideoStreamPlayer videoStreamPlayer) {
        viewGroup.getClass();
        videoStreamPlayer.getClass();
        return new zzbq(viewGroup, videoStreamPlayer);
    }

    @NonNull
    public static AdDisplayContainer createAudioAdDisplayContainer(@NonNull Context context, @NonNull VideoAdPlayer videoAdPlayer) {
        context.getClass();
        videoAdPlayer.getClass();
        return new zzy(context, videoAdPlayer);
    }

    @NonNull
    public StreamRequest createVideoStitcherVodStreamRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        zzbs zzbsVar = new zzbs();
        zzbsVar.zzf(str);
        zzbsVar.zzi(str2);
        zzbsVar.zzl(str3);
        zzbsVar.zzk(str4);
        zzbsVar.zzj(str5);
        zzbsVar.zzb(str6);
        return zzbsVar;
    }

    @NonNull
    public AdsLoader createAdsLoader(@NonNull Context context, @NonNull ImaSdkSettings imaSdkSettings, @NonNull AdDisplayContainer adDisplayContainer) {
        ExecutorService executorServiceZza = zza();
        zzec zzecVar = new zzec();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_START);
        zzu zzuVar = new zzu(context, zzb(imaSdkSettings), imaSdkSettings, adDisplayContainer, zzecVar, executorServiceZza);
        zzuVar.zzp();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_END);
        return zzuVar;
    }

    @NonNull
    public AdsLoader createAdsLoader(@NonNull Context context, @NonNull ImaSdkSettings imaSdkSettings, @NonNull StreamDisplayContainer streamDisplayContainer) {
        ExecutorService executorServiceZza = zza();
        zzec zzecVar = new zzec();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_START);
        zzu zzuVar = new zzu(context, zzb(imaSdkSettings), imaSdkSettings, streamDisplayContainer, zzecVar, executorServiceZza);
        zzuVar.zzp();
        zzecVar.zze(zzby.EVENT_NATIVE_API_ADSLOADER_CONSTRUCTOR_END);
        return zzuVar;
    }
}
