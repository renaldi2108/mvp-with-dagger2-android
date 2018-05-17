package id.renaldirey.daggermvp.ui.presenter;

import java.util.List;

import javax.inject.Inject;

import id.renaldirey.daggermvp.network.ServiceGenerator;
import id.renaldirey.daggermvp.network.response.Response;
import id.renaldirey.daggermvp.network.response.ResponsePopular;
import id.renaldirey.daggermvp.network.service.MovieService;
import id.renaldirey.daggermvp.holder.AppConstants;
import id.renaldirey.daggermvp.ui.presenter.helper.MoviePresenterHelper;
import id.renaldirey.daggermvp.ui.view.ListMovieView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kwikku on 13/05/2018.
 */

public class MoviePresenter<V extends ListMovieView> implements MoviePresenterHelper<ListMovieView> {


    @Inject
    CompositeDisposable compositeDisposable;

    private MovieService movieService;
    private ListMovieView listMovieView;

    @Inject
    public MoviePresenter() {
        //
    }

    @Override
    public void attachView(ListMovieView view) {
        this.listMovieView = view;
    }

    @Override
    public void detachView() {
        this.listMovieView = null;
    }

    @Override
    public boolean isViewAttached() {
        return this.listMovieView != null;
    }

    @Override
    public void destroy() {
        compositeDisposable.dispose();
    }

    public void getPopularMovie(int page){
        movieService = ServiceGenerator
                .createBaseService(listMovieView.getContext(), MovieService.class);

        listMovieView.showProgress();
        compositeDisposable.add(
                movieService.popularService(AppConstants.API_KEY, page)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<Response<List<ResponsePopular>>>() {
                            @Override
                            public void onNext(Response<List<ResponsePopular>> listResponse) {
                                listMovieView.showData(listResponse);
                            }

                            @Override
                            public void onError(Throwable e) {
                                listMovieView.isError(e.toString());
                            }

                            @Override
                            public void onComplete() {
                                listMovieView.hideProgress();
                            }
                        })
        );
    }

}
