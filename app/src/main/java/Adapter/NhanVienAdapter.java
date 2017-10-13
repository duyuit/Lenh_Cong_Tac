package Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.billy.lenhcongtac.R;

import java.util.ArrayList;
import java.util.List;

import Model.NhanVien;

/**
 * Created by Hoi on 10/13/2017.
 */

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {

    Activity context;
    int resource;
    List<NhanVien> objects,tempCustomer,suggestions;
    public NhanVienAdapter(Activity context, int resource, List<NhanVien> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
        tempCustomer=new ArrayList<NhanVien>(objects);
        suggestions=new ArrayList<NhanVien>(objects);;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView textView=row.findViewById(R.id.txta);
        TextView textView1=row.findViewById(R.id.txtb);
        TextView textView2=row.findViewById(R.id.txtc);



        final NhanVien nhanVien = this.objects.get(position);
        textView.setText( nhanVien.getTen());
        textView1.setText( nhanVien.getBac());
        textView2.setText( nhanVien.getDonVi());

        return row;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            NhanVien customer = (NhanVien) resultValue;
            return customer.getTen();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (NhanVien people : tempCustomer) {
                    if (people.getTen().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        suggestions.add(people);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<NhanVien> c = (ArrayList<NhanVien>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (NhanVien cust : c) {
                    add(cust);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
