package com.zeptoconsumerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.util.ArrayMap;
import bridges.CommsModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonElement;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigData;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigDataAdapter;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Arrays;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    public static String f47559a = "";

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f47560b = {"home_layout_native_prefetch", "home_layout_native_prefetch_v2", "home_layout_native_prefetch_v3"};

    /* renamed from: c, reason: collision with root package name */
    public static final List f47561c = Arrays.asList("com.instagram.android", "com.google.android.gm", "com.facebook.katana", "com.twitter.android", "com.linkedin.android", "com.whatsapp", "com.whatsapp.w4b", "com.dreamplug.androidapp", "org.npci.upiapp", "com.google.android.apps.nbu.paisa.user", "com.zerodha.kite3", "com.phonepe.app", "net.one97.paytm", "in.amazon.mShop.android.shopping", "com.flipkart.android", "com.grofers.customerapp", "in.swiggy.android", "com.application.zomato", "com.netflix.mediaclient", "com.amazon.avod.thirdpartyclient", "com.mxtech.videoplayer.ad", "com.graymatrix.did", "com.dream11.fantasy.cricket.football.kabaddi", "in.startv.hotstar", "com.spotify.music", "com.amazon.mp3", "com.bt.bms", "com.google.android.youtube", "com.nextbillion.groww", "in.indwealth", "com.smallcase.android", "com.smartspends", "com.binance.dev", "com.zerodha.coin", "com.csam.icici.bank.imobile", "com.snapwork.hdfc", "com.sbi.lotusintouch", "com.axis.mobile", "com.idfcfirstbank.optimus", "com.meesho.supply", "com.urbanclap.urbanclap", "com.fsn.nykaa", "com.myntra.android", "com.inditex.zara", "com.naviapp", "com.simpl.android", "com.olacabs.customer", "com.ubercab", "com.oyo.consumer", "com.makemytrip", "com.booking", "com.airbnb.android", "com.blusmart.rider", "com.snapchat.android", "in.mohalla.sharechat", "org.telegram.messenger", "com.Slack", "com.microsoft.teams", "com.spotify.music", "com.bumble.app", "com.mygate.user", "com.app.nobrokerhood", "com.zepto.rider", "in.dmart", "com.pengyou.cloneapp", "com.oasisfeng.island", "com.excelliance.multiaccounts", "com.excelliance.multiaccount", "multi.parallel.dualspace.cloner", "com.licious", "com.freshtohome", "org.adaway", "com.adguard.android", "com.cloneapp.parallelspace.dualspace", "com.ril.ajio", "com.fsn.nds", "com.healthifyme.basic", "fit.cure.android", "com.nike.ntc", "com.squats.fittr", "com.netpulse.mobile.goldsgymmypath", "com.mindvalley.mva", "com.practo.fabric", "com.NetmedsMarketplace.Netmeds", "com.apollo.patientapp", "com.aranoah.healthkart.plus", "com.phonegap.rxpal", "com.chaayos", "com.chaipoint.chaipointblack", "com.starbucks.in", "in.thirdwavecoffee.android", "com.ccd.app.global", "com.bodyshop", "com.app.smytten", "com.manash.purplle", "com.caratlane.android", "co.giva.jewellery", "com.titancompany.tanishqapp", "com.bluestone.android", "com.app.pepperfry", "com.urbanladder.catalog", "in.hamleys.www", "fc.admin.fcexpressadmin", "com.mycity4kids", "com.divum.MoneyControl", "app.mycountrydelight.in.countrydelight", "com.mrmilkman.akshayakalpa", "com.truecaller", "com.application.zomato.district", "com.godrej.naturesbasketltd", "com.duolingo", "com.tul.tatacliq", "cards.scapia.android", "com.hm.goe", "com.evamall.evacustomer", "com.uniqlo.in.catalogue", "com.applications.homecentre", "com.mns", "com.milkbasket.app", "com.noisefit", "com.kisankonnect.in", "com.rentomojo", "com.furlenco.android", "com.cityfurnish", "money.jupiter", "com.epifi.paisa", "com.medium.reader", "com.acko.android", "com.godigit.digit", "com.reddit.frontpage", "sinet.startup.inDriver", "in.pluckk", "app.namdhari", "in.clovertech.bumblebee.nucleus", "com.wotu.app", "com.gourmetgarden.gourmetgarden", "in.zeta.android", "com.zaggle", "co.shopney.snitch", "com.blinkit.bistro", "in.swiggy.android.pop", "com.swishapp", "app.slikk.club", "org.altruist.BajajExperia", "com.jar.app", "com.reglobe.cashify", "com.agoda.mobile.consumer", "com.magicpin.local", "com.grofers.customerapp", "in.swiggy.android", "com.bigbasket.mobileapp", "in.swiggy.android.instamart", "com.snapdeal.main", "com.cashkaro", "com.whizdm.moneyview.loans", "com.kreditbee.android");

    /* renamed from: d, reason: collision with root package name */
    public static Gson f47562d = null;

    public static boolean a(Context context, String str) throws JSONException {
        String string = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).getString("userExperiments", "");
        if (!string.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String string2 = jSONObject.getString("rolledOutExperiments");
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("experiments"));
                JSONObject jSONObject3 = new JSONObject(string2);
                if (jSONObject3.has(str)) {
                    return k(str, jSONObject3);
                }
                if (jSONObject2.has(str)) {
                    return k(str, jSONObject2);
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static Bitmap b(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            double dPow = (options.outHeight > 1200 || options.outWidth > 1200) ? Math.pow(2.0d, (int) Math.round(Math.log(1200 / Math.max(r1, options.outWidth)) / Math.log(0.5d))) : 1.0d;
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = (int) dPow;
            return BitmapFactory.decodeFile(str, options2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Gson c() {
        if (f47562d == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            ResolvedConfigDataAdapter resolvedConfigDataAdapter = new ResolvedConfigDataAdapter();
            if (JsonElement.class.isAssignableFrom(ResolvedConfigData.class)) {
                throw new IllegalArgumentException("Cannot override built-in adapter for " + ResolvedConfigData.class);
            }
            if (resolvedConfigDataAdapter instanceof InstanceCreator) {
                gsonBuilder.f45244d.put(ResolvedConfigData.class, (InstanceCreator) resolvedConfigDataAdapter);
            }
            gsonBuilder.f45245e.add(TreeTypeAdapter.e(new TypeToken(ResolvedConfigData.class), resolvedConfigDataAdapter));
            f47562d = gsonBuilder.a();
        }
        return f47562d;
    }

    public static Boolean d(Context context) {
        if ("prod".startsWith("cafe")) {
            return Boolean.FALSE;
        }
        String[] strArr = f47560b;
        for (int i2 = 0; i2 < 3; i2++) {
            if (a(context, strArr[i2])) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static String e(String str) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length > 1) {
                arrayMap.put(strArrSplit[0], strArrSplit[1]);
            } else {
                arrayMap.put(strArrSplit[0], "");
            }
        }
        return (String) arrayMap.get(PaymentConstants.ORDER_ID_CAMEL);
    }

    public static String f(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            String string2 = sharedPreferences.getString("isUserLoggedIn", null);
            if (string2 != null && Boolean.parseBoolean(string2) && (string = sharedPreferences.getString("userId", null)) != null && !string.isEmpty()) {
                return string;
            }
            String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string3 != null ? !string3.isEmpty() ? string3 : "user not found" : "user not found";
        } catch (Exception unused) {
            return "user not found";
        }
    }

    public static String g(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
            String string = sharedPreferences != null ? sharedPreferences.getString("isUserLoggedIn", null) : null;
            return !(string != null ? Boolean.parseBoolean(string) : false) ? "true" : "false";
        } catch (Exception e2) {
            i(e2);
            return "true";
        }
    }

    public static String h() {
        ResponseBody responseBody;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.i("https://ik.imagekit.io/jupdt2k6txi/production/app/images/WorkerConfig.json");
        try {
            Response responseD = okHttpClient.a(builder.b()).d();
            if (!responseD.c() || (responseBody = responseD.f56356g) == null) {
                return null;
            }
            return responseBody.r();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void i(Throwable th) {
        try {
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (firebaseCrashlytics == null) {
                return;
            }
            firebaseCrashlytics.recordException(th);
        } catch (Exception unused) {
        }
    }

    public static void j(ReactContext reactContext, String str, Object obj) {
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
        } catch (Throwable th) {
            i(th);
        }
    }

    public static boolean k(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(str));
            if (!jSONObject2.has("data")) {
                return false;
            }
            JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("data"));
            if (jSONObject3.has("enable")) {
                return jSONObject3.getBoolean("enable");
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }
}
