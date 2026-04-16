package com.sajib.neckbandpopup;
import android.app.*;
import android.bluetooth.*;
import android.bluetooth.le.*;
import android.content.Intent;
import android.os.*;
import androidx.core.app.NotificationCompat;
public class BLEScanService extends Service {
    private final String TARGET = "88:0E:85:7F:9F:4A";
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationChannel chan = new NotificationChannel("c", "Scan", NotificationManager.IMPORTANCE_LOW);
        getSystemService(NotificationManager.class).createNotificationChannel(chan);
        startForeground(1, new NotificationCompat.Builder(this, "c").setContentTitle("Scanning...").setSmallIcon(android.R.drawable.stat_sys_data_bluetooth).build());
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null && adapter.isEnabled()) {
            adapter.getBluetoothLeScanner().startScan(new ScanCallback() {
                public void onScanResult(int ct, ScanResult res) {
                    if (TARGET.equalsIgnoreCase(res.getDevice().getAddress())) {
                        Intent i = new Intent(BLEScanService.this, PopupActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    }
                }
            });
        }
        return START_STICKY;
    }
    public IBinder onBind(Intent intent) { return null; }
}
