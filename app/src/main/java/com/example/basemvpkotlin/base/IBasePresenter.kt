package com.example.basemvpkotlin.base

interface IBasePresenter<V: IBaseView> {
     /**For Attaching Views**/
     fun onAttach(baseView:V)
     /**For Detaching Views**/
     fun onDetach()
     /**For Destroy attached views components**/
     fun onDestroy()
}