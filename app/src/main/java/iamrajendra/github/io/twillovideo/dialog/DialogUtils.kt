package iamrajendra.github.io.twillovideo.dialog

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import iamrajendra.github.io.twillovideo.R


class DialogUtils (activity: Activity){

    var title:String? ="";
    var message:String? ="";
    var  mActivity: Activity
    var  alertDialog1:AlertDialog?=null
    init {
 mActivity = activity
    }


    fun message(message:String){
        this.message = message
        showAlert()
    }
    fun message(title:String,message:String){
        this.message = message
        this.title = title;
        showAlert()
    }


   private fun showAlert(){

         alertDialog1 = AlertDialog.Builder(
            mActivity  ).create()

        alertDialog1!!.setTitle(title)

        alertDialog1!!.setMessage(message)

    }
    fun positiveButton(callback:DialogInterface.OnClickListener){

        alertDialog1!!.setButton(DialogInterface.BUTTON_POSITIVE,"ok",callback)
    }

    fun  show (){
        alertDialog1!!.show()

    }







    companion object {
        private var dialogUtils: DialogUtils? =
            null

        @JvmStatic
        @Synchronized
        fun getInstance(activity: Activity?): DialogUtils? {
            if (dialogUtils == null) {
                dialogUtils =
                    DialogUtils(activity!!)
            }
            return dialogUtils
        }
    }
}