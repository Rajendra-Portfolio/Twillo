package iamrajendra.github.io.twillovideo.twillo

import android.content.Context
import android.util.Log
import com.twilio.video.*

class ConnectionManager(localParticipant: LocalParticipant) {
    private val localParticipant: LocalParticipant? = null
    private val mContext: Context?
    private val mLocalAudioTrack: LocalAudioTrack?
    private val mLocalVideoTrack: LocalVideoTrack?
    private fun roomListener(): Room.Listener {
        return object : Room.Listener {
            override fun onConnected(room: Room) {
                Log.i(TAG, "onConnected: "+room.name)

            }
            override fun onConnectFailure(
                room: Room,
                twilioException: TwilioException
            ) {
                Log.i(TAG, "onConnectFailure: "+room.name)

            }

            override fun onReconnecting(
                room: Room,
                twilioException: TwilioException
            ) {
                Log.i(TAG, "onReconnecting: "+room.name)

            }

            override fun onReconnected(room: Room) {}
            override fun onDisconnected(
                room: Room,
                twilioException: TwilioException?
            ) {
                Log.i(TAG, "onReconnected: "+room.name)

            }

            override fun onParticipantConnected(
                room: Room,
                remoteParticipant: RemoteParticipant
            ) {
                Log.i(TAG, "onParticipantConnected: "+room.name)

            }

            override fun onParticipantDisconnected(
                room: Room,
                remoteParticipant: RemoteParticipant
            ) {
                Log.i(TAG, "onParticipantDisconnected: "+room.name)

            }

            override fun onRecordingStarted(room: Room) {
                Log.i(TAG, "onRecordingStarted: "+room.name)

            }
            override fun onRecordingStopped(room: Room) {
                Log.i(TAG, "onRecordingStopped: "+room.name)

            }
        }
    }

    fun connectToRoom(roomName: String?) {
        val connectOptions = ConnectOptions.Builder("94b557e1ba64cc4845e0dd4018b13c94")
            .roomName(roomName!!)
            .audioTracks(arrayListOf(mLocalAudioTrack))
            .videoTracks(arrayListOf(mLocalVideoTrack)) //                .dataTracks(localDataTracks)
            .build()
        Video.connect(mContext!!, connectOptions, roomListener())
    }

    companion object {
        private var connectionManager: ConnectionManager? = null
        var TAG:String  = "ConnectionManager"

        @Synchronized
        fun getConnectionManager(localParticipant: LocalParticipant): ConnectionManager? {
            if (connectionManager == null) connectionManager =
                ConnectionManager(localParticipant)
            return connectionManager
        }
    }

    init {
        mContext = localParticipant.mContext
        mLocalAudioTrack = localParticipant.localAudioTrack
        mLocalVideoTrack = localParticipant.localVideoTrack
    }
}