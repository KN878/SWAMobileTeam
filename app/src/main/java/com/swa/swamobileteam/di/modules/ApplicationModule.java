package com.swa.swamobileteam.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.swa.swamobileteam.AcmeApplication;
import com.swa.swamobileteam.di.AppScope;
import com.swa.swamobileteam.transportApi.TransportApiClient;
import com.swa.swamobileteam.utils.constants.AuthorizationConstants;
import com.units.transcrypt.di.qualifiers.CommonRetrofit;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class ApplicationModule {
    private final static String TRANSCRYPT_SHARED_PREFERENCES = "com.swa.swamobileteam.prefs";

    @AppScope
    @Provides
    public TransportApiClient provideTransportApiClient(Retrofit retrofit) {
        return new TransportApiClient(retrofit);
    }

    @AppScope
    @Provides
    @CommonRetrofit
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJavaCallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(AuthorizationConstants.acmeApiUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @AppScope
    @Provides
    public OkHttpClient provideRetrofitOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @AppScope
    @Provides
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @AppScope
    @Provides
    public RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @AppScope
    @Provides
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.tag("okHttp").d(message)).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    /*@AppScope
    @Provides
    public AuthorizationManager provideAuthorizationManager(SharedPreferences preferences,
                                                            Encrypter encrypter,
                                                            KeyStorage keyStorage) {
        return new AuthorizationManager(preferences, encrypter, keyStorage);
    }*/

    @AppScope
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(TRANSCRYPT_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    /*@AppScope
    @Provides
    public KeyStorage provideKeyStorage(Context context, SharedPreferences preferences) {
        return new KeyStorage(context, preferences);
    }

    @AppScope
    @Provides
    public NetworkManager provideNetworkManager(Context context) {
        return new NetworkManager(context);
    }

    @AppScope
    @Provides
    public Encrypter provideCrypto() {
        return new Encrypter();
    }

    @AppScope
    @Provides
    public ExpiredTokenInterceptor provideExpiredTokenInterceptor(TranscryptApiAuthClient api,
                                                                  AuthorizationManager authManager) {
        return new ExpiredTokenInterceptor(api, authManager);
    }

    @AppScope
    @Provides
    public LastQueryDao provideLastQueryDao(AppDatabase appDatabase) {
        return appDatabase.getLastQueryDao();
    }

    @AppScope
    @Provides
    public AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "transcrypt-database").build();
    }

    @AppScope
    @Provides
    PresenterCache providePresenterCache() {
        return new PresenterCache();
    }

    @AppScope
    @Provides
    public FileDownloadManager provideFileDownloadManager(Context context) {
        return new FileDownloadManager(context);
    }

    @AppScope
    @Provides
    public UriUtils provideUriUtils(Context context) {
        return new UriUtils(context);
    }*/

    @Module
    public interface Declarations {
        @AppScope
        @Binds
        Context bindContext(AcmeApplication application);
    }
}
