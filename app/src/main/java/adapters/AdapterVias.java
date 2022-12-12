package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escalada.R;

import java.util.ArrayList;

import elements.Via;

public class AdapterVias extends RecyclerView.Adapter<AdapterVias.ViewHolderVias> implements View.OnClickListener {

    // Array de vias con el que vamos a trabajar
    private ArrayList<Via> vias;
    private View.OnClickListener listener;

    // Constructor
    public AdapterVias(ArrayList<Via> vias) {
        this.vias = vias;
    }

    // Metodo que enlaza el adapter con el archivo XML que define la estructura de cada item
    @NonNull
    @Override
    public AdapterVias.ViewHolderVias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // El inflater hincha la vista con el xml creado por nosotros
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_via_adapter, null, false);

        // Poner a escuchar el listener
        view.setOnClickListener(this);

        // Devuelve la vista inflada como la hemos definido
        return new ViewHolderVias(view);
    }

    // Conecta el adaptador con la clase ViewHolderVias
    @Override
    public void onBindViewHolder(@NonNull AdapterVias.ViewHolderVias holder, int position) {

        holder.tvNombre.setText(vias.get(position).getNombre());
        holder.tvGrado.setText(vias.get(position).getGrado());
        holder.tvLongitud.setText(String.format("%dm", vias.get(position).getLongitud()));
        holder.tvChapas.setText(String.valueOf(vias.get(position).getNumChapas()));
    }

    @Override
    public int getItemCount() {
        return vias.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(this.listener == null) return;
        this.listener.onClick(view);
    }

    // Clase en la que se instancian las vistas que contiene nuestro adapter
    class ViewHolderVias extends RecyclerView.ViewHolder {

        TextView tvNombre = itemView.findViewById(R.id.itemViaNombre);
        TextView tvGrado = itemView.findViewById(R.id.itemViaGrado);
        TextView tvLongitud = itemView.findViewById(R.id.itemViaLongitud);
        TextView tvChapas = itemView.findViewById(R.id.itemViaChapas);

        public ViewHolderVias(@NonNull View itemView) {
            super(itemView);
        }
    }
}
