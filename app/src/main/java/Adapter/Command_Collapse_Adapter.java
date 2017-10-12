package Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.billy.lenhcongtac.R;

import java.util.List;

import Model.Command_Collapse;

/**
 * Created by Billy on 10/11/2017.
 */

public class Command_Collapse_Adapter extends ArrayAdapter<Command_Collapse>
{
    Activity context;
    int resource;
    List<Command_Collapse> objects;
    public Command_Collapse_Adapter(Activity context, int resource, List<Command_Collapse> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView textView=row.findViewById(R.id.command_id);
        TextView textView1=row.findViewById(R.id.command_context);
        TextView textView2=row.findViewById(R.id.command_direct);
        TextView textView3=row.findViewById(R.id.command_locate);


        final Command_Collapse hoa = this.objects.get(position);
        textView.setText("Mã lệnh công tác: "+hoa.getId());
        textView1.setText("Nội dung công tác: "+hoa.getContext());
        textView2.setText("Chỉ huy trực tiếp: "+hoa.getDirect());
        textView3.setText("Nơi công tác: "+hoa.getLocate());
        return row;
    }
}
