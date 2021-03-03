package co.edu.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import co.edu.reto1.model.Artista;

public class ActivitySong extends AppCompatActivity {
    private Artista item;




    TextView nombreCancion;
    TextView nombreAlbum;
    ImageView logo;



    MediaPlayer mp;
    int posicion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        item=(Artista) getIntent().getSerializableExtra("artistaData");

        nombreCancion=findViewById(R.id.lbl_nombreCancion);
        nombreAlbum=findViewById(R.id.lbl_nombreAlbum);
        logo=findViewById(R.id.lblArtista);
        nombreCancion.setText(item.getCancion().getNombre());
        nombreAlbum.setText(item.getCancion().getAlbum());
        logo.setImageResource(item.getImagen());
        mp=song(item.getCancion().getSong());




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
            //mp=song(R.raw.contra);
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