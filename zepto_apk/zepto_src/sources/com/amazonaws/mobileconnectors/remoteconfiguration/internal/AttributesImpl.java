package com.amazonaws.mobileconnectors.remoteconfiguration.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.amazonaws.mobileconnectors.remoteconfiguration.exceptions.RemoteConfigurationException;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear.Checks;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class AttributesImpl implements Attributes {
    public static final String KEY_APP_VERSION = "_applicationVersion";

    /* renamed from: d, reason: collision with root package name */
    public static final String f15269d = "AttributesImpl";

    /* renamed from: a, reason: collision with root package name */
    public final String f15270a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f15271b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentMap<String, Object> f15272c;

    public AttributesImpl(Context context) {
        this.f15272c = new ConcurrentHashMap(5, 0.9f, 1);
        this.f15270a = context.getPackageName();
        this.f15271b = a(context);
    }

    public final synchronized <T> T a(String str, Class<T> cls) {
        String country;
        char c2;
        try {
            Checks.checkNotNull(str, "attrKey cannot be null");
            Checks.checkNotNull(cls, "The class cannot be null");
            if (str.startsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)) {
                switch (str.hashCode()) {
                    case -1987945465:
                        if (!str.equals(KEY_APP_VERSION)) {
                            c2 = 65535;
                            break;
                        } else {
                            c2 = 0;
                            break;
                        }
                    case -1563395599:
                        if (!str.equals("_localeLanguage")) {
                            c2 = 65535;
                            break;
                        } else {
                            c2 = 1;
                            break;
                        }
                    case -794057366:
                        if (!str.equals("_localeCountryCode")) {
                            c2 = 65535;
                            break;
                        } else {
                            c2 = 2;
                            break;
                        }
                    case -527144166:
                        if (!str.equals("_applicationIdentifier")) {
                            c2 = 65535;
                            break;
                        } else {
                            c2 = 3;
                            break;
                        }
                    case 1965201874:
                        if (!str.equals("_platform")) {
                            c2 = 65535;
                            break;
                        } else {
                            c2 = 4;
                            break;
                        }
                    default:
                        c2 = 65535;
                        break;
                }
                country = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? null : "Android" : this.f15270a : Locale.getDefault().getCountry() : Locale.getDefault().getLanguage() : this.f15271b;
            } else {
                country = this.f15272c.get(str);
            }
            if (country == null) {
                return null;
            }
            if (cls.isAssignableFrom(country.getClass())) {
                return cls.cast(country);
            }
            throw new RemoteConfigurationException("Unable to retrieve value associated with attrKey = " + str + " as a " + cls.getSimpleName() + CLConstants.DOT_SALT_DELIMETER);
        } finally {
        }
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public void addAttribute(String str, String str2) {
        addAttributePrivate(str, str2);
    }

    public synchronized void addAttributePrivate(String str, Object obj) {
        Checks.checkNotNull(str, "attrKey cannot be null");
        Checks.checkNotNull(obj, "attrValue cannot be null");
        Checks.checkArgument(!str.startsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX), "Custom attributes cannot begin with _");
        if (this.f15272c.size() >= 100) {
            throw new RemoteConfigurationException("Custom attributes limit 100 reached");
        }
        this.f15272c.put(str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AttributesImpl attributesImpl = (AttributesImpl) obj;
        if (a(this.f15272c, attributesImpl.f15272c) && a(Locale.getDefault().getCountry(), Locale.getDefault().getCountry()) && a(Locale.getDefault().getLanguage(), Locale.getDefault().getLanguage()) && a("Android", "Android") && a(this.f15270a, attributesImpl.f15270a)) {
            return a(this.f15271b, attributesImpl.f15271b);
        }
        return false;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public synchronized Map<String, Object> getAllAttributes() {
        HashMap map;
        map = new HashMap();
        map.put("_platform", "Android");
        map.put("_localeLanguage", Locale.getDefault().getLanguage());
        map.put("_localeCountryCode", Locale.getDefault().getCountry());
        map.put("_applicationIdentifier", this.f15270a);
        map.put(KEY_APP_VERSION, this.f15271b);
        map.putAll(this.f15272c);
        return Collections.unmodifiableMap(map);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public Boolean getBoolean(String str) {
        return (Boolean) a(str, Boolean.class);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public Double getDouble(String str) {
        return (Double) a(str, Double.class);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public Integer getInt(String str) {
        return (Integer) a(str, Integer.class);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public Long getLong(String str) {
        return (Long) a(str, Long.class);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public String getString(String str) {
        return (String) a(str, String.class);
    }

    public int hashCode() {
        return a(this.f15271b) + ((a(this.f15270a) + ((a("Android") + ((a(Locale.getDefault().getLanguage()) + ((a(Locale.getDefault().getCountry()) + (a(this.f15272c) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public synchronized Object remove(String str) {
        Checks.checkNotNull(str, "attrKey cannot be null");
        Checks.checkArgument(!str.startsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX), "Unable to delete attributes with _ prefix");
        if (!this.f15272c.containsKey(str)) {
            return null;
        }
        return this.f15272c.remove(str);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public void addAttribute(String str, Integer num) {
        addAttributePrivate(str, num);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public void addAttribute(String str, Long l2) {
        addAttributePrivate(str, l2);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized AttributesImpl m56clone() {
        return new AttributesImpl(this.f15270a, this.f15271b, this.f15272c);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public void addAttribute(String str, Double d2) {
        if (d2 != null && (d2.isNaN() || d2.isInfinite())) {
            throw new IllegalArgumentException("Invalid attribute value: " + d2);
        }
        addAttributePrivate(str, d2);
    }

    public AttributesImpl(String str, Integer num, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(5, 0.9f, 1);
        this.f15272c = concurrentHashMap;
        this.f15270a = str;
        this.f15271b = num;
        concurrentHashMap.putAll(map);
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.Attributes
    public void addAttribute(String str, Boolean bool) {
        addAttributePrivate(str, bool);
    }

    public Integer a(Context context) {
        try {
            return Integer.valueOf(context.getPackageManager().getPackageInfo(this.f15270a, 0).versionCode);
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            Log.wtf(f15269d, "Package not found for: " + this.f15270a, e2);
            return null;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return false;
        }
        if (obj == obj2) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
