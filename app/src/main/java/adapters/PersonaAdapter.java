package adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.R;

import java.util.List;

import models.Persona;


    public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaHolder> {
        List<Persona> ListasPersona;

        public PersonaAdapter(List<Persona> listasPersona) {
            ListasPersona = listasPersona;
        }

        @NonNull
        @Override
        public PersonaAdapter.PersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater ly = LayoutInflater.from(parent.getContext());
            View vistapersona = ly.inflate(R.layout.itempersona,parent,false);
            return new PersonaHolder(vistapersona);
        }

        @Override
        public void onBindViewHolder(@NonNull PersonaAdapter.PersonaHolder holder, int position) {
            holder.setData(ListasPersona.get(position));
            holder.itemView.setBackgroundColor(ListasPersona.get(position).getColor());
        }

        @Override
        public int getItemCount() {
            return ListasPersona.size();
        }

        public class PersonaHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            TextView txtNombre, txtTelefono, txtIr;
            Persona persona;
            Context context;

            public PersonaHolder(@NonNull View itemView){
                super(itemView);
                context = itemView.getContext();
                txtNombre = itemView.findViewById(R.id.txtNombre);
                txtTelefono = itemView.findViewById(R.id.txtTelefono);
                txtIr = itemView.findViewById(R.id.txtIr);
                itemView.setOnClickListener(this);

                txtTelefono.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+persona.getTelefono()));
                        context.startActivity(intent);
                    }
                });

                txtIr.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent intentos = new Intent(Intent.ACTION_VIEW);
                        intentos.setData(Uri.parse("geo:"+persona.getUbicacion()));
                        context.startActivity(intentos);

//                        new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.7749,-122.4149"));

                    }
                });


                txtNombre.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intento = new Intent(v.getContext(), DatosPersona.class);
                        intento.putExtra("persona", persona);
                        context.startActivity(intento);
                    }
                });
            }

            public void setData(Persona persona){
                this.persona = persona;
                txtNombre.setText(persona.getNombre());
                txtTelefono.setText(persona.getTelefono());
            }

            @Override
            public void onClick(View view) {
            }
        }


    }








