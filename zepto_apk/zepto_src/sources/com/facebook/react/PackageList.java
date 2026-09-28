package com.facebook.react;

import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.agontuk.RNFusedLocation.RNFusedLocationPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.appsflyer.reactnative.PCAppsFlyerPackage;
import com.appsflyer.reactnative.RNAppsFlyerPackage;
import com.brentvatne.react.ReactVideoPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.falcon.FalconPackage;
import com.gantix.JailMonkey.JailMonkeyPackage;
import com.horcrux.svg.SvgPackage;
import com.horizon.HorizonPackage;
import com.ibits.react_native_in_app_review.AppReviewPackage;
import com.imagepicker.ImagePickerPackage;
import com.kevinresol.react_native_default_preference.RNDefaultPreferencePackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.RNCConfig.RNCConfigPackage;
import com.mixpanel.reactnative.MixpanelReactNativePackage;
import com.origami.OrigamiPackage;
import com.phoenix.PhoenixPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnativecommunity.blurview.BlurViewPackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativedocumentpicker.RNDocumentPickerPackage;
import com.reactnativemmkv.MmkvPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.rnfs.RNFSPackage;
import com.rnmaps.maps.MapsPackage;
import com.rt2zz.reactnativecontacts.ReactNativeContacts;
import com.sparkfabrikreactnativeidfaaaid.ReactNativeIdfaAaidPackage;
import com.sudoplz.rninappupdates.SpReactNativeInAppUpdatesPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.unistyles.UnistylesPackage;
import com.zmxv.RNSound.RNSoundPackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import in.juspay.hypersdkreact.HyperSdkReactPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.reactnative.maskedview.RNCMaskedViewPackage;

/* loaded from: classes.dex */
public class PackageList {

    /* renamed from: a, reason: collision with root package name */
    public final MainPackageConfig f18434a;

    public PackageList(MainPackageConfig mainPackageConfig) {
        this.f18434a = mainPackageConfig;
    }

    public final ArrayList a() {
        return new ArrayList(Arrays.asList(new MainReactPackage(this.f18434a), new RNSoundPackage(), new ClipboardPackage(), new BlurViewPackage(), new RNDateTimePickerPackage(), new NetInfoPackage(), new RNDocumentPickerPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseCrashlyticsPackage(), new ReactNativeFirebaseMessagingPackage(), new RNCMaskedViewPackage(), new RNSentryPackage(), new ReactNativeIdfaAaidPackage(), new FalconPackage(), new HorizonPackage(), new OrigamiPackage(), new PhoenixPackage(), new HyperSdkReactPackage(), new JailMonkeyPackage(), new LottiePackage(), new MixpanelReactNativePackage(), new RNAppsFlyerPackage(), new PCAppsFlyerPackage(), new ReactNativeBlobUtilPackage(), new RNCConfigPackage(), new ReactNativeContacts(), new RNDefaultPreferencePackage(), new RNDeviceInfo(), new RNFSPackage(), new RNFusedLocationPackage(), new RNGestureHandlerPackage(), new ImagePickerPackage(), new AppReviewPackage(), new LinearGradientPackage(), new MapsPackage(), new MmkvPackage(), new PagerViewPackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SvgPackage(), new ReactVideoPackage(), new RNViewShotPackage(), new RNCWebViewPackage(), new SpReactNativeInAppUpdatesPackage(), new ReactSliderPackage(), new UnistylesPackage()));
    }
}
