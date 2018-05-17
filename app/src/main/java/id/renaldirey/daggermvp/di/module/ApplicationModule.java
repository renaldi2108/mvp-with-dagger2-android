package id.renaldirey.daggermvp.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import id.renaldirey.daggermvp.di.ApplicationContext;

/**
 * Created by Kwikku on 16/05/2018.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

//    @Provides
//    @Singleton
//    OkHttpClient.Builder provideBuilder(){
//        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
//        okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
//        okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
//        okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);
//
//        return okhttpBuilder;
//    }
//
//    @Provides
//    @Singleton
//    Retrofit provideRetrofit(OkHttpClient.Builder builder) {
//        OkHttpClient.Builder okhttpBuilder = builder;
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        builder.addInterceptor(interceptor);
//
//        okhttpBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Request newReq = request.newBuilder()
//                        .header("Accept", "application/json")
//                        .build();
//                return chain.proceed(newReq);
//            }
//        });
//
//        OkHttpClient client = okhttpBuilder.build();
//
//        return new Retrofit.Builder()
//                .baseUrl(AppConstants.BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    @SuppressWarnings("unused")
//    public MovieService provideMovieService(Retrofit retrofit) {
//        return retrofit.create(MovieService.class);
//    }
//
//    @Provides
//    @Singleton
//    @SuppressWarnings("unused")
//    public NetworkService provideNetworkService(MovieService movieService) {
//        return new NetworkService(movieService);
//    }
//
//    @Provides
//    MoviePresenterHelper<ListMovieView> provideMoviePresenter(MoviePresenter<ListMovieView> moviePresenter){
//        return moviePresenter;
//    }
}

