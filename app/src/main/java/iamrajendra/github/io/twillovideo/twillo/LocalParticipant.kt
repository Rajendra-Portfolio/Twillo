package iamrajendra.github.io.twillovideo.twillo

import android.content.Context
import com.twilio.video.CameraCapturer
import com.twilio.video.LocalAudioTrack
import com.twilio.video.LocalVideoTrack

class  LocalParticipant(private val context: Context?) {
     var localAudioTrack: LocalAudioTrack? = null
     var localVideoTrack: LocalVideoTrack? = null
    private var cameraCapturer: CameraCapturer? = null
    var mContext:Context?=null

    init {
        if (context != null) {
            mContext = context
        }
    }

    fun createVideoTrack() {
        localAudioTrack = LocalAudioTrack.create(mContext!!, true)
        cameraCapturer = CameraCapturer(
            mContext!!,
            CameraCapturer.CameraSource.FRONT_CAMERA
        )
        localVideoTrack = LocalVideoTrack.create(mContext!!, true, cameraCapturer!!)
    }

    fun enableAudio() {
        localAudioTrack!!.enable(true)
    }

    fun disableAudio() {
        localAudioTrack!!.enable(false)
    }

    fun enableVideo() {
        localVideoTrack!!.enable(true)
    }

    fun disableVideo() {
        localVideoTrack!!.enable(false)
    }

    fun swtichCamera() {
        cameraCapturer!!.switchCamera()
    }

    companion object {
        private var localParticipant: LocalParticipant? =
            null

        @JvmStatic
        @Synchronized
        fun getInstance(context: Context?): LocalParticipant? {
            if (localParticipant == null) {
                localParticipant =
                    LocalParticipant(context)
            }
            return localParticipant
        }
    }

}