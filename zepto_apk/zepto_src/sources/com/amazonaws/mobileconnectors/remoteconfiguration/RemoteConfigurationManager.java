package com.amazonaws.mobileconnectors.remoteconfiguration;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.media.b;
import androidx.constraintlayout.motion.widget.a;
import com.amazonaws.mobileconnectors.remoteconfiguration.exceptions.MalformedAppConfigIdException;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ArcusThrottler;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.Arn;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.AttributesImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ConfigurationDb;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.ConfigurationImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear.Checks;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear.LocalConfigInstanceIdGenerationHelper;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfigurationImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.net.AndroidRemoteConfigurationFetcher;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.net.RemoteConfigurationFetcher;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RemoteConfigurationManager {

    /* renamed from: a, reason: collision with root package name */
    public final String f15249a;

    /* renamed from: b, reason: collision with root package name */
    public final ConfigurationDb f15250b;

    /* renamed from: c, reason: collision with root package name */
    public final RemoteConfigurationFetcher f15251c;

    /* renamed from: d, reason: collision with root package name */
    public final Attributes f15252d;

    /* renamed from: e, reason: collision with root package name */
    public final SharedPreferences f15253e;

    /* renamed from: f, reason: collision with root package name */
    public int f15254f;

    /* renamed from: g, reason: collision with root package name */
    public final ArcusThrottler f15255g;

    public RemoteConfigurationManager(Builder builder) {
        this(builder.f15258b, builder.f15257a, builder.f15259c, builder.f15260d);
    }

    public static void a(String str) {
        try {
            Arn.fromArn(str);
        } catch (IllegalArgumentException e2) {
            throw new MalformedAppConfigIdException("Invalid appConfigId ARN.", e2);
        }
    }

    public static void b(String str) {
        try {
            Arn.fromArn(str);
        } catch (IllegalArgumentException e2) {
            throw new MalformedAppConfigIdException("Invalid appConfigId ARN.", e2);
        }
    }

    public static Builder forAppId(Context context, String str) {
        return new Builder(context, str);
    }

    public static RemoteConfigurationManager getInstance(String str) {
        Checks.checkNotNull(str, "The App Configuration ID may not be null");
        return Builder.f15256e.get(str);
    }

    public Attributes openAttributes() {
        return this.f15252d;
    }

    public Configuration openConfiguration() {
        return this.f15250b.readConfiguration();
    }

    public void overwriteConfiguration(JSONObject jSONObject) throws Throwable {
        Checks.checkNotNull(jSONObject, "The Configuration cannot be null");
        this.f15250b.saveConfiguration(new RemoteConfigurationImpl(new ConfigurationImpl(jSONObject.toString(), new Date()), this.f15249a, 3, null, false));
    }

    public void setRampingKey(String str) {
        if (str == null) {
            throw new NullPointerException("The ramping key cannot be null.");
        }
        if (str.isEmpty() || str.length() > 64) {
            throw new IllegalArgumentException("The ramping key cannot be empty and its length is limited to 64 characters.");
        }
        String strGenerateLocalConfigInstanceId = LocalConfigInstanceIdGenerationHelper.generateLocalConfigInstanceId(str);
        SharedPreferences.Editor editorEdit = this.f15253e.edit();
        editorEdit.putString("localConfigurationInstanceId", strGenerateLocalConfigInstanceId);
        editorEdit.apply();
    }

    public void sync(ConfigurationSyncCallback configurationSyncCallback) {
        Checks.checkNotNull(configurationSyncCallback, "ConfigurationSyncCallback cannot be null");
        b(configurationSyncCallback);
    }

    public RemoteConfigurationManager(Context context, String str, JSONObject jSONObject, boolean z) {
        this(context, str, jSONObject, ConfigurationDb.getOrCreateInstance(context, str), "https://arcus-uswest.amazon.com", z);
    }

    public static Builder forAppId(Context context, String str, boolean z) {
        return new Builder(context, str, z);
    }

    public final String a() {
        return b.r(new StringBuilder(), this.f15249a, "_configuration.prefs");
    }

    public final void b(ConfigurationSyncCallback configurationSyncCallback) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executorServiceNewSingleThreadExecutor.submit(new a(16, this, configurationSyncCallback));
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    public RemoteConfigurationManager(Context context, String str, JSONObject jSONObject, ConfigurationDb configurationDb, String str2, boolean z) throws Throwable {
        this.f15255g = new ArcusThrottler();
        Checks.checkNotNull(context, "appContext cannot be null");
        Checks.checkNotNull(str, "appConfigId cannot be null");
        b(str);
        context = z ? context : context.getApplicationContext();
        try {
            URL url = new URL(str2);
            this.f15249a = str;
            this.f15253e = context.getSharedPreferences(a(), 0);
            AttributesImpl attributesImpl = new AttributesImpl(context);
            this.f15252d = attributesImpl;
            this.f15254f = attributesImpl.hashCode();
            this.f15250b = configurationDb;
            this.f15251c = new AndroidRemoteConfigurationFetcher(context, url);
            if (jSONObject != null) {
                RemoteConfiguration remoteConfiguration = configurationDb.readRemoteConfiguration(str);
                if (remoteConfiguration == null || remoteConfiguration.getOrigin() == 1) {
                    configurationDb.saveConfiguration(new RemoteConfigurationImpl(new ConfigurationImpl(jSONObject.toString(), new Date()), str, 1, null, false));
                }
            }
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid endpoint", e2);
        }
    }

    public static class Builder {

        /* renamed from: e, reason: collision with root package name */
        public static final ConcurrentHashMap<String, RemoteConfigurationManager> f15256e = new ConcurrentHashMap<>();

        /* renamed from: a, reason: collision with root package name */
        public final String f15257a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f15258b;

        /* renamed from: c, reason: collision with root package name */
        public JSONObject f15259c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f15260d;

        public Builder(Context context, String str) {
            this.f15259c = new JSONObject();
            this.f15260d = false;
            if (context == null) {
                throw new NullPointerException("The Context may not be null");
            }
            if (str == null) {
                throw new NullPointerException("The App Configuration ID may not be null");
            }
            RemoteConfigurationManager.a(str);
            this.f15258b = context;
            this.f15257a = str;
        }

        public RemoteConfigurationManager createOrGet() {
            String str = this.f15257a;
            if (str == null) {
                throw new IllegalStateException("An App Configuration ID must be specified");
            }
            ConcurrentHashMap<String, RemoteConfigurationManager> concurrentHashMap = f15256e;
            if (!concurrentHashMap.containsKey(str)) {
                if (this.f15258b == null) {
                    throw new IllegalStateException("The Context may not be null");
                }
                String str2 = this.f15257a;
                if (str2 == null) {
                    throw new IllegalStateException("The App Configuration ID may not be null");
                }
                if (this.f15259c == null) {
                    throw new IllegalStateException("The default configuration may not be null");
                }
                concurrentHashMap.putIfAbsent(str2, new RemoteConfigurationManager(this));
            }
            return concurrentHashMap.get(this.f15257a);
        }

        public Builder withDefaultConfiguration(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new NullPointerException("The default configuration may not be null");
            }
            this.f15259c = jSONObject;
            return this;
        }

        public Builder(Context context, String str, boolean z) {
            this(context, str);
            this.f15260d = z;
        }
    }
}
