package cl.zcloud.www.bluethooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DeviceListAdapter  extends ArrayAdapter<BluetoothDevice>{

    private LayoutInflater mLayoutInflater;
    private ArrayList<BluetoothDevice> mDevices;
    private int mViewResourceId;

    public DeviceListAdapter(@NonNull Context context, int tvResourceId, @NonNull ArrayList<BluetoothDevice> devices) {
        super(context, tvResourceId, devices);

        this.mDevices = devices;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = tvResourceId;

    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        convertView = mLayoutInflater.inflate(mViewResourceId, null);
        BluetoothDevice device = mDevices.get(position);
        if (device != null){
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAddress= (TextView) convertView.findViewById(R.id.tvDeviceAddress);

            if (deviceName != null){
                deviceName.setText(device.getName());
            }
            if (deviceAddress != null){
                deviceAddress.setText(device.getAddress());
            }
        }
        return convertView;
    }
}
