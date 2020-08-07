package iamrajendra.github.io.twillovideo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import iamrajendra.github.io.twillovideo.R
import iamrajendra.github.io.twillovideo.base.BaseFragment
import iamrajendra.github.io.twillovideo.dialog.DialogUtils

class RoomFragment : BaseFragment() {
    var editTextRoomName: EditText? = null
    var  buttonRoom:Button?=null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.room_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextRoomName = view.findViewById(R.id.room_name)
        buttonRoom  = view.findViewById(R.id.create_room)
        buttonRoom?.setOnClickListener {
            openRoom(editTextRoomName?.text.toString())

        }
    }

    private fun openRoom(roomName: String?) {
        if (roomName.isNullOrEmpty()){
            DialogUtils.getInstance(activity)?.message("Please enter room name")
            DialogUtils.getInstance(activity)?.show()
            return
        }
        val bundle = bundleOf("room_name" to roomName)

        findNavController().navigate(R.id.action_RoomFragment_to_VideoChatFragment,bundle)



    }


}