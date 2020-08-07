package iamrajendra.github.io.twillovideo.base

import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import iamrajendra.github.io.twillovideo.dialog.DialogUtils
import java.security.Permission

open class BaseFragment :Fragment (){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

     fun  checkPermission(permissions: Array<String>, description:String){

         var check:Boolean = false
         permissions.forEach {
            check = ContextCompat.checkSelfPermission(this!!.requireContext(),it)== PackageManager.PERMISSION_GRANTED
         }


        if (!check){
            DialogUtils.getInstance(activity)!!.message(description)
            DialogUtils.getInstance(activity)!!.positiveButton(DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int ->
                requestPermissions(permissions,121)
            })
            DialogUtils.getInstance(activity)!!.show()
        }else{
            permissionIsAlreadyGiven();
        }
    }


    open fun permissionIsAlreadyGiven() {

    }
}