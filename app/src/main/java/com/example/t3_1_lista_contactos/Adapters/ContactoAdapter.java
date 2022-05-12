package com.example.t3_1_lista_contactos.Adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t3_1_lista_contactos.Clases.Contacto;
import com.example.t3_1_lista_contactos.R;

import org.w3c.dom.Text;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactosViewHolder>{

    List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactosViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contactos,parent, false);

        return new ContactosViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ContactoAdapter.ContactosViewHolder holder, int position) {
        View view= holder.itemView;
        Contacto contacto= contactos.get(position);

        TextView tvNombre =view.findViewById(R.id.tvNombre);
        TextView tvNumero = view.findViewById(R.id.tvNumero);

        Button tvLlamar = view.findViewById(R.id.btnLlamar);
        Button tvSms = view.findViewById(R.id.btnSms);

        tvNombre.setText(contacto.Nombre);
        tvNumero.setText(contacto.Numero);

        tvSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = "";//The phone number you want to text
                String sms= "";//The message you want to text to the phone

                Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", contacto.Numero, null));
                smsIntent.putExtra("sms_body",sms);
                view.getContext().startActivity(smsIntent);


               /* Uri uri = Uri.parse("smsto:+5111111111");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Este es un mensaje de texto");
                view.getContext().startActivity(intent);  */
            }
        });

        tvLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contacto.Numero));
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ContactosViewHolder extends RecyclerView.ViewHolder{

        public ContactosViewHolder( View itemView) {
            super(itemView);
        }
    }
}
