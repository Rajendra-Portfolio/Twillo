package iamrajendra.github.io.twillovideo.fragment

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twilio.video.VideoView
import iamrajendra.github.io.twillovideo.R
import iamrajendra.github.io.twillovideo.base.BaseFragment
import iamrajendra.github.io.twillovideo.dialog.DialogUtils
import iamrajendra.github.io.twillovideo.twillo.ConnectionManager
import iamrajendra.github.io.twillovideo.twillo.LocalParticipant

class VideoChatFragment :BaseFragment(){
    private var  localVideoView:VideoView?=null
    private  var  localParticipant: LocalParticipant?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.video_fragment,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        showLocalStream(view)

checkPermission(arrayOf(Manifest.permission.RECORD_AUDIO,Manifest.permission.CAMERA),"Record audio and Camera permission are required for proper functioning");
    }

    override fun permissionIsAlreadyGiven() {
        super.permissionIsAlreadyGiven()
        view?.let { showLocalStream(it) }
    }



    private fun showLocalStream(view: View) {
        localParticipant =
            LocalParticipant.getInstance(context)
        localParticipant?.createVideoTrack()
        val videoView: VideoView = view.findViewById(R.id.localVideoView)
        localParticipant?.localVideoTrack?.addRenderer(videoView)
        var  roomName: String? = arguments?.getString("room_name")

        localParticipant?.let { ConnectionManager.getConnectionManager(it)?.connectToRoom(roomName)


        }


    }


}