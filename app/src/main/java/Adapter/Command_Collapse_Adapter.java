package Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.billy.lenhcongtac.List_Command;
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
    CheckBox ckbdelete;
    public Command_Collapse_Adapter(Activity context, int resource, List<Command_Collapse> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView textView=row.findViewById(R.id.command_id);
        TextView textView1=row.findViewById(R.id.command_context);
        TextView textView2=row.findViewById(R.id.command_direct);
        TextView textView3=row.findViewById(R.id.command_locate);
         ckbdelete=row.findViewById(R.id.ckbdelete);

        final Command_Collapse hoa = this.objects.get(position);
        textView.setText("Mã lệnh công tác: "+hoa.getId());
        textView1.setText("Nội dung công tác: "+hoa.getContext());
        textView2.setText("Chỉ huy trực tiếp: "+hoa.getDirect());
        textView3.setText("Nơi công tác: "+hoa.getLocate());
if(hoa.isCheck()==0)
{
    ckbdelete.setVisibility(View.GONE);

}
else if(hoa.isCheck()==1)
{
    ckbdelete.setVisibility(View.VISIBLE);
}

        ckbdelete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


               if(b) {
                   objects.get(position).setCheck(2);
                   List_Command.countCheck++;

               }
               else {
                   objects.get(position).setCheck(1);
                   List_Command.countCheck--;

               }
                if(List_Command.countCheck>=1)
                {
                    List_Command.btnxoa.setEnabled(true);
                }else if(List_Command.countCheck<1)
                {
                    List_Command.btnxoa.setEnabled(false);
                }
                if(List_Command.countCheck>=2||List_Command.countCheck<1)
                {
                    List_Command.btnsua.setEnabled(false);
                    List_Command.btnThem.setEnabled(false);

                }
                if(List_Command.countCheck==1) {
                    List_Command.btnsua.setEnabled(true);
                    List_Command.btnThem.setEnabled(true);

                }
            }
        });
        return row;
    }


}
