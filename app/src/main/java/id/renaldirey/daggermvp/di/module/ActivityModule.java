package id.renaldirey.daggermvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import id.renaldirey.daggermvp.di.ActivityContext;
import id.renaldirey.daggermvp.ui.presenter.MoviePresenter;
import id.renaldirey.daggermvp.ui.presenter.helper.MoviePresenterHelper;
import id.renaldirey.daggermvp.ui.view.ListMovieView;
import io.reactivex.disposables.CompositeDisposable;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Kwikku on 16/05/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity provideAppCompatActivity(){
        return appCompatActivity;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(AppCompatActivity context) {
        return new GridLayoutManager(context, 2);
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription(){
        return new CompositeSubscription();
    }

    @Provides
    MoviePresenterHelper<ListMovieView> provideMoviePresenter(MoviePresenter<ListMovieView> moviePresenter){
        return moviePresenter;
    }
}
