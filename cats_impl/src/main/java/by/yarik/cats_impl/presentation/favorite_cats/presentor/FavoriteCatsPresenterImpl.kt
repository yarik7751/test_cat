package by.yarik.cats_impl.presentation.favorite_cats.presentor

import android.Manifest
import android.os.Bundle
import by.yarik.cats_impl.R
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.domain.allcats.CatsInteractor
import by.yarik.cats_impl.presentation.favorite_cats.view.FavoriteCatsView
import by.yarik.core.ResourceManager
import by.yarik.core.presentation.presenter.BasePresenterImpl
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavoriteCatsPresenterImpl(view: FavoriteCatsView): BasePresenterImpl<FavoriteCatsView>(view), FavoriteCatsPresenter {

    @Inject
    lateinit var interactor: CatsInteractor

    @Inject
    lateinit var resourceManager: ResourceManager

    override fun onCreateView() {
        CatsComponent.getInstance().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getFavoriteCats()
    }

    private fun getFavoriteCats() {
        addDisposable(interactor.getFavoriteCats()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.startProgress() }
            .doAfterTerminate { view.stopProgress() }
            .subscribe({
                view.updateFaviriteCats(it as MutableList)
            }, {onFailture(it)}))
    }

    override fun downloadFile(url: String, permissions: RxPermissions) {
        addDisposable(permissions.request(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe {
                if (it) {
                    downloadImage(url)
                }
            })
    }

    private fun downloadImage(url: String) {
        addDisposable(interactor.downloadCatImage(url)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it) {
                    view.sendSimpleMessage(resourceManager.getString(R.string.cat_download_true))
                } else{
                    view.sendSimpleMessage(resourceManager.getString(R.string.cat_download_false))
                }
            }, {onFailture(it)}))
    }
}