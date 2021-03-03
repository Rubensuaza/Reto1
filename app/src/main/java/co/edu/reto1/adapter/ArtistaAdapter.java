package co.edu.reto1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.reto1.ActivitySong;
import co.edu.reto1.MainActivity;
import co.edu.reto1.R;
import co.edu.reto1.model.Artista;

public class ArtistaAdapter extends BaseAdapter implements Filterable {
    private final LayoutInflater inflater;
    private List<Artista> artistasIn;
    private List<Artista> artistasOut;
    private Context context;

    public ArtistaAdapter(Context context, List<Artista> artistas){
        this.context=context;
        artistasIn=artistas;
        artistasOut=artistas;
        inflater= LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return artistasOut.size();
    }

    @Override
    public Object getItem(int position) {
        return artistasOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Artista item=(Artista) getItem(i);
        ViewHolder viewHolder;
        if(view!=null){
            viewHolder=(ViewHolder) view.getTag();

        }else{
            view=inflater.inflate(R.layout.artista_item,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);


        }
        viewHolder.imagen.setImageResource(artistasOut.get(i).getImagen());
        viewHolder.nombre.setText(artistasOut.get(i).getNombre());
        viewHolder.descripcion.setText(artistasOut.get(i).getDescripcion());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,ActivitySong.class);

                //intent.putExtra("artistaData",item);
                context.startActivity(intent); }

        });





        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter= new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results=new FilterResults();
                List<Artista> filteredArrList=new ArrayList<>();
                if(artistasIn==null){
                    artistasIn=new ArrayList<>(artistasOut);
                }
                if(constraint==null){
                    results.count=artistasIn.size();
                    results.values=artistasIn;
                }
                else{
                    constraint=constraint.toString().toLowerCase();
                    for(int i =0;i< artistasIn.size();i++ ){
                        String data=artistasIn.get(i).getNombre();
                        if(data.toLowerCase().contains(constraint.toString())){
                            filteredArrList.add(artistasIn.get(i));

                        }

                    }
                    results.count=filteredArrList.size();
                    results.values=filteredArrList;

                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                artistasOut=(List<Artista>) filterResults.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }

    class ViewHolder {
        @BindView(R.id.image)
        ImageView imagen;

        @BindView(R.id.nombre)
        TextView nombre;

        @BindView(R.id.descripcion)
        TextView descripcion;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
