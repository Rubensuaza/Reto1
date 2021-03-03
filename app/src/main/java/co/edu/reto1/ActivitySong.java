package co.edu.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import co.edu.reto1.model.Artista;

public class ActivitySong extends AppCompatActivity {
   /*private Artista item;
    @BindView(R.id.lbl_nombreCancion)
    TextView nombreCancion;
*/

    MediaPlayer mp;
    int posicion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

       

        /*item=(Artista) getIntent().getSerializableExtra("artistaData");
        nombreCancion.setText(item.getNombre());
*/
    }



    public void destruir(){
        if (mp!=null){
            mp.release();
        }
    }


    public void play(View view) {

        if (mp!=null && mp.isPlaying()==false ){
            mp.seekTo(posicion);
            mp.start();


        }
        else{
            destruir();
            mp=song(R.raw.contra);
            mp.start();
        }

    }

    public void stop(View view){
        if (mp!=null && mp.isPlaying()){
            posicion=mp.getCurrentPosition();
            mp.pause();

        }
    }




    public MediaPlayer song(int resource){
        MediaPlayer mediaPlayer=MediaPlayer.create(this,resource);
        return mediaPlayer;
    }



}