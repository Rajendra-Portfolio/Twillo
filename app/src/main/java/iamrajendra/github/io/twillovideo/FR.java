package iamrajendra.github.io.twillovideo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.twilio.video.VideoView;

import iamrajendra.github.io.twillovideo.twillo.LocalParticipant;

public class FR  extends Fragment {
    EditText editTextRoomName;
    private LocalParticipant localParticipant;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextRoomName  = view.findViewById(R.id.room_name);
        localParticipant = LocalParticipant.getInstance(getContext());
        VideoView videoView  = view.findViewById(R.id.localVideoView);
//        localParticipant.localVideoTrack.addRenderer(videoView);
        AlertDialog alertDialog ;

    }
}
